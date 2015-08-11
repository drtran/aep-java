# Selenium's note:
Kiet T. Tran

_11 August 2015_

This Java project contains various sample code using Selenium webdriver.
For a W3C specification on webdriver, check this [link](https://w3c.github.io/webdriver/webdriver-spec.html "W3C WebDriver").

## Straight Selenium code
- _TestPuppiesWebSite.java_: This contains Java code using selenium webdrive to test a website. It uses firefox driver. It is a form of java application with static main method.

- _PuppiesTest.java_: this also contains a JUnit test method similar to that of the TestPuppiesWebSite. It uses remote webdriver instead. In this case it is hard coded to use
PhantomJS GhostDriver (run phantomjs --webdriver=8910). You would need a download of phantomJS
software package [here](http://phantomjs.org/ "PhantomJS").

- If you want to test with a different browsers using remote webdrivers such as firefox or chrome, you would need to run selenium server that you can download [here](http://www.seleniumhq.org/download/ "Selenium Server"). The code is very much the same with an URL to the selenium server like this: http://127.0.0.1:4444/wd/hub. Assuming you run selenium server with a default port 4444.
