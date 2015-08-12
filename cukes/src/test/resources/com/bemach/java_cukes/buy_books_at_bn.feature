@buy_bn
Feature: Buy books at bn website
  In order to read a book
  As a reader I want to buy books at bn.com

  @buy_bn_1
  Scenario Outline: Buy a book at overstock website
    Given that I am on bn website url:
    """
       http://www.bn.com
    """
    And I search for a "<search_text>" book
    And I choose "<book_name>"
    When I click Add to Cart button
    Then I should see "<count>" item in my shopping cart
  Examples:
    | search_text | book_name                                                                                       | count  |
    | Scrum       | Scrum: The Art of Doing Twice the Work in Half the Time                                         | 1 item |
    | Scrum       | Scrum, (Mega Pack), For the Agile Scrum Master, Product Owner, Stakeholder and Development Team | 1 item |


  @buy_bn_2
  Scenario Outline: Buy several books at overstock website
    Given that I am on bn website url:
    """
       http://www.bn.com
    """
    And I search for a "<search_text>" book
    And I choose these books:
      | Book Title                                                                                      |
      | Scrum: The Art of Doing Twice the Work in Half the Time                                         |
      | Scrum, (Mega Pack), For the Agile Scrum Master, Product Owner, Stakeholder and Development Team |
    Then I should see "<count>" item in my shopping cart
    Examples:
      | search_text |count   |
      | Scrum       |2 items |
