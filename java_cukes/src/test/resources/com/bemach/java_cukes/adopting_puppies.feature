Feature: Adopting puppies
  As a puppy lover
  I want to adopt puppies
  So they can chew my furniture

  Background:
    Given I am on the puppy adoption site

  Scenario: Adopting a puppy using a table --> List<PaymentInfo>
    When I click the View Details button for "Brook"
    And I click the Adopt Me! button
    And I click the Complete the Adoption button
    And I complete the adoption with
    | name   | address             | email              | pay_type |
    | Cheezy | 123 Main Street     | cheezy@example.com | Check    |
    Then I should see "Thank you for adopting a puppy!"
    
  Scenario: Adopting three puppies using a table --> List<String>
    When I adopt multiple puppies
    | Brook    |
    | Hanna    |
    | Ruby Sue |
    And I click the Complete the Adoption button
    And I complete the adoption with
    | name   | address             | email              | pay_type          |
    | Cheezy | 123 Main Street     | cheezy@example.com | Purchase order    |
    Then I should see "Thank you for adopting a puppy!"
    