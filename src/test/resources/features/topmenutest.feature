Feature: Top menu Feature

  @sanity @smoke @regression
  Scenario: Verify user should navigate to desktops page successfully
    Given I am on homepage
    When I mouse hover and click on desktop link
    And I click on Show all desktops link
    Then Verify Desktops text

   @smoke @regression
  Scenario: Verify user should navigate to laptops and notebooks page successfully
    Given I am on homepage
    When I mouse hover and click on laptops and notebooks link
    And I click on Show all laptops and notebooks link
    Then Verify Laptops & Notebooks text

  @regression
  Scenario: Verify user should navigate to components page successfully
    Given I am on homepage
    When I mouse hover and click on components link
    And I click on Show all components link
    Then Verify Components text