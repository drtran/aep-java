Feature: Buy books at amazon website
  In order to read a book
  As a reader I want to buy a book at amazon

  Scenario: Buy a book at Amazon website
    Given that I am on Amazon website
    And I search for a "Scrum" book
    And I choose "Essential Scrum: A Practical Guide to the Most Popular Agile Process"
    And I click Add to Cart button
    Then I should see "1" item in my shopping cart
