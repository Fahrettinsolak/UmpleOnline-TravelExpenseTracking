@echo off
@setlocal enableextensions
@cd /d "%~dp0"

echo Running Application
java -jar TravelExpenseTracking/target/TravelExpenseTracking-1.0-SNAPSHOT.jar

echo Operation Completed!
pause