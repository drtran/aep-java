Feature: Adopting multiple puppies
  In order to have the puppies chew my furniture
  As a pet owner,
  I want to adopt two puppies
  
 @scenario-1
  Scenario: Adopting two puppies from the website - version 1.
    Given that I am at the website "http://puppies.herokuapp.com/"
    When I adopt for these pets, 
      | Brook   |
      | Tipsy   |
      | Twinkie |
    And I pay for the adoption using this type of payment:
      | paymentType | orderName   | orderAddress    | orderEmail         |
      | Check       | Mr. Baloney | 123 Main Street | baloney@sleezy.com |
    Then I should be back at the main page with a thank you note, "Thank you for adopting a puppy!" 
  
@scenario-2
  Scenario Outline: Adopting two puppies from the website using Outline - version 2.
    Given that I am at the website "http://puppies.herokuapp.com/"
#    When I adopt for these pets, "<pet1>", "<pet2>", and "<pet3>"
    When I adopt for these pets, 
      | <pet1> |
      | <pet2> |
      | <pet3> |
    And I pay for the adoption using this type of payment:
      | paymentType | orderName   | orderAddress    | orderEmail         |
      | <payment>   | Mr. Baloney | 123 Main Street | baloney@sleezy.com |
    Then I should be back at the main page with a thank you note, "Thank you for adopting a puppy!"
  Examples:
  	| pet1     | pet2   | pet3    | payment     |
  	| Hanna    | Topsy  | Twinkie | Check       |
  	| Ruby Sue | Sparky | Spud    | Credit card |
  	