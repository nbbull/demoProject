@echo off
set BUILD_ID=dontKillMe
echo ֹͣռ�ö˿ڵķ���......
setlocal enabledelayedexpansion
set port=8081
for /f "tokens=1-5" %%a in ('netstat -ano ^| find ":%port%"') do (
    if "%%e%" == "" (
        set pid=%%d
    ) else (
        set pid=%%e
    )
    echo !pid!
    taskkill /f /pid !pid!
)
echo ���ư���������......
copy  /y C:\Users\nb_bu\.jenkins\workspace\demo_job3\target\demo-0.0.1-SNAPSHOT.jar  C:\jenkins\demo.jar  
echo ����sprintBoot����......
java -jar C:\jenkins\demo.jar 
