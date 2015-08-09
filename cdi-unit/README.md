# Sample code for Contexts and Dependency Injection (CDI) Unit Tests

This project contains sample code related to implementing and testing application
using CDI & CDI-Unit package. Exercises are grouped into several packages. Code
are repeated to see the progression. 

## Description

In a Java web application, I can employ one or more of these types of user authentication
(_https://tomcat.apache.org/tomcat-6.0-doc/realm-howto.html_): JDBC, DataSource, JNDI, User
Database, Memory, JAAS, Combined, and LockOut. In this project, I will attempt to implement
JDBC, Datasource, JNDI, User Database and JAAS. Here is the table Tomcat suggest to use:

		create table users (
		  user_name         varchar(15) not null primary key,
		  user_pass         varchar(15) not null
		);
		
		create table user_roles (
		  user_name         varchar(15) not null,
		  role_name         varchar(15) not null,
		  primary key (user_name, role_name)
		);

First, I create an interface for the authentication service as follows:

		public interface AuthenticateService {
			public UserInfo authenticate(String userId, String psw);
		}
		
		public interface UserInfo {
			public String getUserId();
			public String getEncryptedPsw();
			public List<String> getRoles();
			public Date getLoginAt();
			public Date getLastLoginAt();
			public Boolean isActive();
			public Boolean isExpired();
			public Boolean getLoginFailCount();
			public Boolean isNill();
		}

## exercise 01 (package: com.bemach.cdi.cdi_unit.ex01)


## exercise 02 (package: com.bemach.cdi.cdi_unit.ex02)


