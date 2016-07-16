@echo off
color 0A
set currentpath=%~dp0
pushd "%currentpath%"
set module=server
set version=1.0.0
set config=%currentpath%/application.properties
set exec=../../../target/%module%-%version%.jar
java -jar %exec% --spring.config.location=%config%