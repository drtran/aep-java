Feature: Outside-in development demonstration

Scenario: Hello World
Given I want to display "Hello World"
When I execute the application
Then I should see the "Hello World"

Scenario: Hello World
Given I want to display "Hello World"
When I execute the application
Then I should not see the "Hello, World!"