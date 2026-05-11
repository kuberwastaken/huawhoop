"""Scan for nearby BLE devices and identify the Huawei Band 10."""
import asyncio
from bleak import BleakScanner


async def scan():
    print("Scanning for BLE devices (10 seconds)...\n")
    devices = await BleakScanner.discover(timeout=10.0, return_adv=True)

    huawei_devices = []
    other_devices = []

    for addr, (device, adv) in devices.items():
        name = device.name or adv.local_name or ""
        entry = {"address": addr, "name": name, "rssi": adv.rssi}
        if any(kw in name.upper() for kw in ["HUAWEI", "HONOR", "BAND", "FIT"]):
            huawei_devices.append(entry)
        else:
            other_devices.append(entry)

    if huawei_devices:
        print("=== Likely Huawei/Honor devices ===")
        for d in huawei_devices:
            print(f"  [{d['rssi']:>4} dBm]  {d['address']}  {d['name']!r}")
        print()

    print("=== All other devices ===")
    for d in sorted(other_devices, key=lambda x: x["rssi"], reverse=True):
        print(f"  [{d['rssi']:>4} dBm]  {d['address']}  {d['name']!r}")

    print(f"\nTotal devices found: {len(devices)}")
    if not huawei_devices:
        print("\nNo Huawei devices detected. Make sure your Band 10 is:")
        print("  - On your wrist and awake (tap screen)")
        print("  - NOT actively connected to your phone (disconnect from Huawei Health app first)")


asyncio.run(scan())
