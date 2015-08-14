# Selenium's note:
Kiet T. Tran

_11 August 2015_

This Java project contains various sample code using Selenium webdriver.
For a W3C specification on webdriver, check this [link](https://w3c.github.io/webdriver/webdriver-spec.html "W3C WebDriver").

## Straight Selenium code

- _PetAdoptionTest1.java_: Testing adopting one pet with one payment type. The test is exercised
using the following brwoser drivers:

		+ Chrome
		+ Firefox 
		+ Remote Chrome with Selenium Server
		+ Remote Firefox with Selenium Server
		+ Remote Headless browser (Ghost Driver) with PhamtomJS Ghost Driver.
		
The code is straight forward one string of activities contains all necessary steps to complete
an adoption of one pet. Download Selenium Server [here](http://www.seleniumhq.org/download/ "Selenium Server") and PhantomJS Ghost Driver [here](http://phantomjs.org/ "PhantomJS"). To run these standalone servers, use these commands:

		java -jar selenium-server-standalone-?.?.?.jar (?: version you download.
		phantomjs --webdriver=???? (????: port number. i.e., 8910)
		
- _PetAdoptionTest2.java_: This class contains the same tests as _PuppyAdoptionTest1_ but broken down into smaller steps. Also, PageObject concept is also employed. The code can be refactored for better organization. That is done in _PuppyAdoptionTest3.java_.

