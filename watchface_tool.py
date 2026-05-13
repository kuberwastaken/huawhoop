import argparse
import json
import sys
import zipfile
from pathlib import Path
from xml.etree import ElementTree


RESOLUTION_BY_THEME = {
    "HWHD01": "390*390",
    "HWHD02": "454*454",
    "HWHD03": "240*120",
    "HWHD04": "160*80",
    "HWHD05": "460*188",
    "HWHD06": "456*280",
    "HWHD07": "368*194",
    "HWHD08": "320*320",
    "HWHD09": "466*466",
    "HWHD10": "360*320",
    "HWHD11": "480*336",
    "HWHD12": "240*240",
    "HWHD13": "480*408",
    "HWHD14": "482*286",
    "HNHD01": "466*466",
    "HNHD02": "368*194",
    "HNHD03": "450*390",
    "HNHD04": "454*454",
    "QXHD01": "402*256",
    "QXHD02": "502*410",
}


def _zip_read(zf: zipfile.ZipFile, name: str) -> bytes | None:
    try:
        return zf.read(name)
    except KeyError:
        return None


def _xml_text(root: ElementTree.Element, tag: str) -> str:
    found = root.find(f".//{tag}")
    return (found.text or "").strip() if found is not None else ""


def _extract_watchface_bin(container: bytes) -> tuple[int, str]:
    try:
        from io import BytesIO

        with zipfile.ZipFile(BytesIO(container)) as nested:
            watchface_bin = _zip_read(nested, "watchface.bin")
            if watchface_bin:
                return len(watchface_bin), "nested_zip/watchface.bin"
    except zipfile.BadZipFile:
        pass
    return len(container), "raw_watchface_payload"


def validate_watchface(path: Path, width: int = 194, height: int = 368) -> dict:
    result = {
        "path": str(path),
        "valid": False,
        "errors": [],
        "warnings": [],
        "metadata": {},
    }
    expected_screen = f"{height}*{width}"
    if not path.exists():
        result["errors"].append("file does not exist")
        return result

    try:
        with zipfile.ZipFile(path) as zf:
            names = set(zf.namelist())
            description = _zip_read(zf, "description.xml")
            if not description:
                result["errors"].append("missing description.xml")
                return result

            if description.startswith(b"\xef\xbb\xbf"):
                description = description[3:]
            root = ElementTree.fromstring(description)
            root_name = root.tag
            is_honor = root_name == "HnTheme"
            if root_name not in {"HwTheme", "HnTheme"}:
                result["errors"].append(f"unexpected description root: {root_name}")

            metadata = {
                "root": root_name,
                "title": _xml_text(root, "title"),
                "title_cn": _xml_text(root, "title-cn"),
                "author": _xml_text(root, "author"),
                "designer": _xml_text(root, "designer"),
                "screen": _xml_text(root, "screen"),
                "version": _xml_text(root, "version"),
                "font": _xml_text(root, "font"),
                "font_cn": _xml_text(root, "font-cn"),
            }
            result["metadata"] = metadata

            screen = metadata["screen"]
            mapped_screen = RESOLUTION_BY_THEME.get(screen)
            if mapped_screen and mapped_screen != expected_screen:
                result["errors"].append(f"theme {screen} maps to {mapped_screen}, expected {expected_screen}")
            elif not mapped_screen and screen != expected_screen:
                result["warnings"].append(f"unknown screen/theme '{screen}', expected {expected_screen} or HWHD07/HNHD02")

            if "preview/cover.jpg" not in names:
                result["warnings"].append("missing preview/cover.jpg")

            payload_name = "com.honor.watchface" if is_honor else "com.huawei.watchface"
            payload = _zip_read(zf, payload_name)
            if not payload:
                result["errors"].append(f"missing {payload_name}")
            else:
                size, payload_kind = _extract_watchface_bin(payload)
                result["payload"] = {
                    "container_name": payload_name,
                    "kind": payload_kind,
                    "watchface_bin_size": size,
                }
                if size <= 0:
                    result["errors"].append("empty watchface payload")

    except zipfile.BadZipFile:
        result["errors"].append("not a zip/hwt package")
    except ElementTree.ParseError as e:
        result["errors"].append(f"description.xml parse error: {e}")
    except Exception as e:
        result["errors"].append(repr(e))

    result["valid"] = not result["errors"]
    return result


def main(argv: list[str]) -> int:
    parser = argparse.ArgumentParser(description="Validate Huawei Band watchface packages before any device upload.")
    parser.add_argument("path", type=Path)
    parser.add_argument("--width", type=int, default=194, help="Target device width in pixels.")
    parser.add_argument("--height", type=int, default=368, help="Target device height in pixels.")
    parser.add_argument("--json", action="store_true", help="Emit machine-readable JSON.")
    args = parser.parse_args(argv)

    result = validate_watchface(args.path, width=args.width, height=args.height)
    if args.json:
        print(json.dumps(result, indent=2))
    else:
        status = "valid" if result["valid"] else "invalid"
        print(f"{args.path}: {status}")
        for key, value in (result.get("metadata") or {}).items():
            if value:
                print(f"  {key}: {value}")
        if result.get("payload"):
            print(f"  payload: {result['payload']['kind']} ({result['payload']['watchface_bin_size']} bytes)")
        for warning in result["warnings"]:
            print(f"  warning: {warning}")
        for error in result["errors"]:
            print(f"  error: {error}")
    return 0 if result["valid"] else 1


if __name__ == "__main__":
    raise SystemExit(main(sys.argv[1:]))
