@echo off
set currentpath=%~dp0
pushd "%currentpath%"
set BASE_DIR=%currentpath%
set NSSMEXE=%currentpath%\nssm.exe
set SERVICE_NAME=RazorbreakRemoteServer

%NSSMEXE% install %SERVICE_NAME% %BASE_DIR%\StartServer.bat