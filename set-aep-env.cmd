REM 
REM Setting up the environment for AEP class
REM
REM Kiet T. Tran, Ph.D. 2014
REM

REM **** JAVA ****
REM
SET JAVA_HOME=C:\Program Files\Java\jdk1.7.0_45
SET PATH=%JAVA_HOME%\bin;%PATH%

SET TRAINING_HOME=C:\dev\aep

REM **** SONAR ****
SET SONAR_RUNNER=%TRAINING_HOME%\sonar-runner-2.3
SET PATH=%PATH%;%SONAR_RUNNER%\bin

REM **** MAVEN ****
SET MAVEN_HOME=%TRAINING_HOME%\apache-maven-3.0.3
SET PATH=%PATH%;%MAVEN_HOME%\bin

