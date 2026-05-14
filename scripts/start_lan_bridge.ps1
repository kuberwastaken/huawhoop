param(
    [string]$HostAddress = "0.0.0.0",
    [int]$Port = 8765
)

$ErrorActionPreference = "Stop"

$repoRoot = Split-Path -Parent $PSScriptRoot
Set-Location $repoRoot

$env:BAND10_DASHBOARD_HOST = $HostAddress
$env:BAND10_DASHBOARD_PORT = "$Port"

Write-Host "Starting Huawhoop bridge on $HostAddress`:$Port"
Write-Host "Local dashboard: http://127.0.0.1:$Port/dashboard/"

Get-NetIPAddress -AddressFamily IPv4 |
    Where-Object { $_.IPAddress -notlike "127.*" -and $_.PrefixOrigin -ne "WellKnown" } |
    ForEach-Object {
        Write-Host "LAN dashboard:   http://$($_.IPAddress):$Port/dashboard/"
    }

python run_dashboard.py
