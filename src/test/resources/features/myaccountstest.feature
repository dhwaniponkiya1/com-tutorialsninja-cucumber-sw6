Feature: My accounts Feature

  @sanity @smoke @regression
  Scenario: Verify user should navigate to register page successfully
    Given I am on homepage
    When I click on my accounts link
    And I click on register link
    Then Verify the text "Register Account"

  @smoke @regression
  Scenario: Verify user should navigate to login page successfully
    Given I am on homepage
    When I click on my accounts link
    And I click on login link
    Then Verify the login text "Returning Customer"

  @regression
  Scenario: Verify user register account successfully
    Given I am on homepage
    When I click on my accounts link
    And I click on register link
    And I register to ac using data: "Prime", "Testing", "p346@gmail.com", "07833662976", "prime@123", "prime@123"
    Then Verify the Message Your Account Has Been Created!
    And I click on continue button after register
    And I click on my accounts link
    And I click on logout link
    Then Verify the logout text "Account Logout"

  @regression
  Scenario: Verify user login and logout successfully
    Given I am on homepage
    When I click on my accounts link
    And I click on login link
    And I enter "p346@gmail.com", "prime@123" and login
    Then Verify text after login "My Account"
    And I click on my accounts link
    And I click on logout link
    Then Verify the logout text "Account Logout"





