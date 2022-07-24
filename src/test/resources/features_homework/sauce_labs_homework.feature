Feature: Checkout was successful
  As a user,
  I want to log-in
  So I can buy products

  Scenario:
    Given I navigate to login page
    When I login with credentials 'standard_user' and 'secret_sauce'
    Then I am successfully logged in to page
    When I add one product to cart
    Then I go to cart
    And I see it in cart
    When I click on check-out
    Then I fill the name with 'Name', surname with 'Surname' and zip code with 'LV1212' in check-out page
    Then I can continue check-out
    When I reach the Overview page, I check the information is correct
    Then I finish the purchase
    Then I make sure everything is good
    Then I go back to Home page

  Scenario:
    Given I navigate to login page
    When I login with credentials 'standard_user' and 'secret_sauce'
    Then I go to cart
    Then I click on check-out
    Then I check if name is mandatory field
    And I check if the error message of name field is correct
    When I fill the name field
    Then I check if surname field is mandatory
    And I check if the error message of surname field is correct
    When I fill the name and surname field
    Then I check if zip code field is mandatory
    And I check if the error message of zipcode field is correct