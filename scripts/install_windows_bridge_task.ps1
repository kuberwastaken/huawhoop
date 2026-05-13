$ErrorActionPreference = "Stop"

$taskName = "Huawhoop Bridge"
$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$repoRoot = Split-Path -Parent $scriptDir
$startScript = Join-Path $scriptDir "start_bridge_task.ps1"

if (-not (Test-Path $startScript)) {
    throw "Missing bridge start script: $startScript"
}

$actionArgs = "-NoProfile -ExecutionPolicy Bypass -WindowStyle Hidden -File `"$startScript`""
$action = New-ScheduledTaskAction -Execute "powershell.exe" -Argument $actionArgs -WorkingDirectory $repoRoot
$trigger = New-ScheduledTaskTrigger -AtLogOn
$settings = New-ScheduledTaskSettingsSet -AllowStartIfOnBatteries -DontStopIfGoingOnBatteries -ExecutionTimeLimit (New-TimeSpan -Days 7) -MultipleInstances IgnoreNew
$principal = New-ScheduledTaskPrincipal -UserId $env:USERNAME -LogonType Interactive -RunLevel Limited

Register-ScheduledTask -TaskName $taskName -Action $action -Trigger $trigger -Settings $settings -Principal $principal -Description "Runs the Huawhoop local BLE bridge and PWA server at logon." -Force | Out-Null

Write-Host "Installed scheduled task '$taskName'."
Write-Host "Start now with: Start-ScheduledTask -TaskName '$taskName'"
Write-Host "Dashboard URL: http://127.0.0.1:8765/dashboard/"
