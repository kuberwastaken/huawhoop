$ErrorActionPreference = "Stop"

$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
$repoRoot = Split-Path -Parent $scriptDir
$logDir = Join-Path $repoRoot "logs"
$logFile = Join-Path $logDir "bridge-task.log"

New-Item -ItemType Directory -Force -Path $logDir | Out-Null
Set-Location $repoRoot

if (-not $env:BAND10_DIRECT_CONNECT_FALLBACK) { $env:BAND10_DIRECT_CONNECT_FALLBACK = "1" }
if (-not $env:BAND10_KEEPALIVE_MODE) { $env:BAND10_KEEPALIVE_MODE = "battery" }
if (-not $env:BAND10_KEEPALIVE_SECONDS) { $env:BAND10_KEEPALIVE_SECONDS = "60" }
if (-not $env:BAND10_SYNC_INTERVAL_SECONDS) { $env:BAND10_SYNC_INTERVAL_SECONDS = "300" }
if (-not $env:BAND10_FULL_SYNC_EVERY) { $env:BAND10_FULL_SYNC_EVERY = "6" }
if (-not $env:BAND10_INITIAL_FULL_SYNC) { $env:BAND10_INITIAL_FULL_SYNC = "1" }
if (-not $env:BAND10_ENABLE_PASSIVE_SETTINGS) { $env:BAND10_ENABLE_PASSIVE_SETTINGS = "1" }

"[$(Get-Date -Format s)] Starting Huawhoop bridge in $repoRoot" | Add-Content -Path $logFile
python run_dashboard.py *>> $logFile
