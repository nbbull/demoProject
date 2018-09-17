@echo off
set BUILD_ID=dontKillMe
echo 停止占用端口的服务......
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
echo 复制包并重命名......
copy  /y C:\Users\nb_bu\.jenkins\workspace\demo_job3\target\demo-0.0.1-SNAPSHOT.jar  C:\jenkins\demo.jar  
echo 启动sprintBoot服务......
java -jar C:\jenkins\demo.jar 
