# JMeter Notes:

## Activities:

- I download the latest JMeter from [here](jmeter.apache.org, "Apache's Jmeter").

- I unzip the download and store it under my directory here: C:\csd-work\win\bin\apache-jmeter-2.13\bin. I start JMeter.bat Windows program. A GUI program is started and the left panel has two options "Test Plan" and "WorkBench".

- I download HP Loadrunner 12 Software E-Media [here](https://ssl.www8.hp.com/us/en/ssl/dlc/secure_software.html?prodNumber=T7177FAEF "Loadrunner").
Download the community edition (~ 800MB).

- I ran the program and it unzip the installation DVD into my directory here: C:\csdwin\bin\hp-loadrunner\DVD. 

- I run _StartServer.bat_ Windows Batch file. The Apache server is launched and I visit this URL: http://localhost:1080/webTours. The batch file is located here: _C:\csdwin\bin\hp-loadrunner\DVD\lrunner\MSI\HP\LoadRunner\WebTours_

- I start recording activities under the browser with JMeter. To do that, I need to tell the browser to use a proxy port that Jmeter is listening on. I decide to use port 9999 since my other commonly used ports (8080, etc.) are occupied. I avoid using Chrome and IE because they share proxy setup and that I am using Chrome for my internet activities. I use Firefox and change the proxy to localhost:9999 for all the protocols.  FF: settings/options/advanced/network settings. Make sure to undo the proxy settings if you want to use FF for the internet for other activities later only.

- I configure a recording session using Jmeter's WorkBench/Add/Non-Test Elements/HTTP(s) Test-Script Records option. I name it "My Test Recorder 1" and set port to 9999 (matched with the proxy port above). I choose "Put each group in a new controller" Grouping and select "Add suggested Excludes" to avoid unnecessary stuffs on webpages.

- I need to select the right target controller and click on the Start button in my recorder screen to start recording. Jmeter records activities and labels them into step numbers. I can change the name to make it more meaningful.

- I visit google.com website with my FF browser. JMeter is recording because he is the proxy between my FF and the Internet.

- I then stop recording and inspecting my recording session.

- I create a new Thread Group (users) Add/Thread (Users)/Thread Group. I name it My Thread Group.

- I copy the recording session that I point to a testing website into my Thread group. I configure it o 10 users, ramp-up period is 15 seconds and loop count is at 100. __WARNING: DONOT DO TO ANY WEBSITE YOU DO NOT OWN. IT HARMS THE SITE YOU ARE TESTING__. Some website like google can detect your attempt to load test their website and refuse. Other websites may not be so sophisticated and therefore, you can do some damage to their presence. __WARNING WARNING WARNING__.

- I chose a few types of reporting: View Results Tree, View Results in Table, and Graph Results.

- OK. I download extra plug-ins from [here](http://jmeter-plugins.org/ "JMeter Plug-ins"). I chose Standard Set [here](http://jmeter-plugins.org/wiki/StandardSet/ "Standard Set Plug-ins"). The actual download is located [here](http://jmeter-plugins.org/downloads/all/ "Plug-ins download").

- I unzip the download and store the content inside 'ext' folder to <apache-jmeter>lib/ext folder. I stop and start jmeter so that it picks up new plug-ins. Not that what was in WorkBecn is now cleaned. I notice that I now have two addition options in New/Thread (Users) menu and a bunch of additional listeners. They all start with 'jp@gc'.

---

## Testing Login with Cookie Manager in Jmeter:

- I create another recording using this [website: http://the-internet.herokuapp.com/login](http://the-internet.herokuapp.com/login "Testing login").

- I login the website using given uid/passwd.

- I verify login successfully.

- I log out.

- I stop the WorkBench recorder. I create a new test plan Thread Group as shown above. Make sure to Add Cookie Manager so that a session is maintained for the login.

- I copy the activities from workbench to my new thread group. I run just one time to see if this work.

- I use the View Results Tree report to verify the result of the login session. 

- I use the information from the results tree to do the assertion on my test. I create two assertions: contains text and equal result code.

- I add more assertions on the logout event: HTML assertion, Size Assertion, and Duration Assertion.

---

## Controllers:

- Create a workbench to record activities from this website: [http://newtours.demoaut.com/](http://newtours.demoaut.com/). uid/psw = test/test.

## Selenium Runs:

- When I export a JAR that contains unit tests with Selenium, I have to make sure to include
the seleium-api.jar and selenium-firefox-driver.jar (2.47.1) along with the app jar in <jmeter>/lib/junit folder. Make sure all supporting JARs are included here otherwise, Jmeter JUNIT won't show your test classes.














