# Training tools required for AEP in Java
# Kiet T. Tran, 2014.
#
# Download and Install the software below

## Java JDK 7
  - Download the latest JDK 7. I have not tested with JDK 8. In addition, I had some issues in recent pass
    on JDK 8 while it was in Beta.
  - JDK 6 should works also.
  
## Eclipse IDEL for Java EE Developers (4.x)
  - Install from http://www.eclipse.org
  - Choose JEE version

  
## PhantomJS:
	
	PhantomJS is a headless WebKit scriptable with a JavaScript API. 
	It has fast and native support for various web standards: DOM handling, CSS selector, JSON, 
	Canvas, and SVG.
	
	We use PhantomJS to facilitate the execution of client-side unit tests via the Resharper test runner. 
	After installing PhantomJS using the link below,
	go into Resharper Options...Tools...Unit Testing...JavaScript Tests and select Run Tests With PhantomJS. 
	Enter the path to your PhantomJS executable in the applicable field in this screen.

  - [Download PhantomJS] (http://phantomjs.org/)

## Git Tools

 - Download and install git tool from http://git-scm.com

## Ruby & RubyMine

- Go here: rubyinstaller.org
 	- Install ruby 1.9.3
 		- check all the boxes
 	- Get devkit from the same page Make sure it is the 32 bit one!
 		- Run the exe and set the destination to C:\DevKit

- Go here: command prompt
	- Type ruby -v
	- should say it's 1.9.3
	- cd into your devkit directory
	- Type ruby dk.rb init
	- Type ruby dk.rb install
	- Type gem install bundler

- Go here: http://code.google.com/p/selenium/downloads/
 	- Download the IEDriverServer_Win32, unzip it and and throw the exe in the ruby bin directory (If that link dies, start here: http://code.google.com/p/selenium/wiki/InternetExplorerDriver)

- Go here: http://chromedriver.storage.googleapis.com/index.html
	- Download the latest chromedriver_win32.zip, unzip it and and throw the exe in the ruby bin directory.

- Go here at: www.jetbrains.com/ruby
	- Install RubyMine

- Run the RubyMine application
  - Click "Open directory" and navigate to training\Cukes and open it.  You need to tell RubyMine about git. 
    In the green dialogue that pops up, click Configure. When the settings open up, click the "Add root" 
	link in the pink warning strip. Click apply and leave the settings open.
  - Rubymine also noticed that you have missing gems. Clicking the link in that yellow warning 
    dialogue doesn't help until we tell RubyMine about the proxy.
  - May need to set proxy if corporate network requires it.
  
- Go to Rubymine menu: Tools / Bundler / install
	- Stuff will scroll on the bottom half of the screen. Then it will say it's done (Ignore the rake warnings).
- Go to the page on how to run Ruby tests and follow the instructions for running tests to ensure 
  everything is setup properly.

----

## Node Package Manager & Karma SpecRunner Plugin for RubyMine
- Go here: http://nodejs.org/download/
	- Download the 32-bit Windows Installer and install it.  If prompted, make sure NPM (Node Package Manager) 
	  is installed as well.
- Go here: command prompt
	- Type npm -v
	- should say it's ~ 1.3.24
	- Type npm config set proxy http://xyz.xyz.com -g (Proxy only)
	- If those proxy settings don't work try the following:
		- Type npm config set proxy http://userNameHere:passwordHere@proxy.xyz.com:8080
		- Type npm config set https-proxy http://userNameHere:passwordHere@proxy.xyz.com:8080
	- Type npm install karma -g 
	- Type npm install karma-jasmine -g
	- Check with a teammate to see if you need JUnit Reporter
		- Type npm install karma-junit-reporter -g 
	
- Run the RubyMine application
- Go to File > Settings > Plugins and search for "Karma".  
- Click the "Browse" link in the search results
- Install the Karma plugin for rubymine.

# DEVELOPMENT ENVIRONMENT SETUP 

These steps are needed prior to opening the solution 
> ***ALWAYS RUN VISUAL STUDIO AS AN ADMINISTRATOR***

## Source Code

  Development will be done in a branch called "develop".  The URLs for the repository are listed below: 

  - View the Repository in [GitHub](URL here)
  - Clone (checkout) the repository locally: 
    git clone git-hub URL 

## Install Tomcat Server (7.0.14)
