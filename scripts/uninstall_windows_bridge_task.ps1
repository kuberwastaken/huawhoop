$ErrorActionPreference = "Stop"

$taskName = "Huawhoop Bridge"

if (Get-ScheduledTask -TaskName $taskName -ErrorAction SilentlyContinue) {
    Unregister-ScheduledTask -TaskName $taskName -Confirm:$false
    Write-Host "Removed scheduled task '$taskName'."
} else {
    Write-Host "Scheduled task '$taskName' is not installed."
}

$startupShortcut = Join-Path ([Environment]::GetFolderPath("Startup")) "Huawhoop Bridge.lnk"
if (Test-Path $startupShortcut) {
    Remove-Item -LiteralPath $startupShortcut -Force
    Write-Host "Removed Startup shortcut '$startupShortcut'."
}
