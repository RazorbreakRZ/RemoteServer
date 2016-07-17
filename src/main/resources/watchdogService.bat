@echo off
set service=RazorbreakRemoteServer
set logPath=C:\Users\Razorbreak\Documents\GitHub\RemoteServer\src\main\resources\logs\server.log
tasklist /FI "SERVICES eq %service%" /NH | find "nssm"
if %errorlevel%==1 (
	echo %date% %time%0  INFO      --- [watchdog] watchdogService.bat                  : Starting service "%service%">>%logPath%
	net start %service%	
)