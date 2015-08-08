A Java-based web project with Primefaces
========================================
Introduction
------------
In this project, I want to create a simple Java web app
using Eclipse IDE. This project uses primefaces as a JSF-based 
component library for the user interface.

I want to use this as a teaching tool for my students on how to 
implement a modern Java-based (or Java Enterprise Edition / JEE) 
web application. The focus is really __testability__ of an application.
By that I mean to think of testing first before a piece of production 
code is written. How do I test this yet-to-be-written piece of software?

I want to employ the layering approach pattern by dividing the 
application into these three basic layers: 1) web-ui, 
2) business-logic, and 3) data-access. Besides using the Primefaces
JSF component library, I also want to use Spring Framework for the
dependency-injection (DI) feature mainly. DI helps realize my 
goal of software testability easier.

- Create a web dynamic project to make sure we get TOMCAT7 server
- Convert to MAVEN