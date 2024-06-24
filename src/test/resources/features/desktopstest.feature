Feature: Desktop menu Feature

  @sanity @smoke @regression
  Scenario: Verify product arrange in alphabetical order
    Given I am on homepage
    When I mouse hover and click on desktop link
    And I click on Show all desktops link
    And I select Sort By position Name (Z to A)
    Then Verify the product arrange in descending order

  @smoke @regression
  Scenario Outline: Verify product added to shopping cart successfully
    Given I am on homepage
    When I mouse hover and click on currency dropdown and pound sterling
    And I mouse hover and click on desktop link
    And I click on Show all desktops link
    And I select Sort By position Name (A to Z)
    And I select "<product>"
    Then Verify text "<product>"
    And I enter qty "1"
    And I click on add to cart button
    Then Verify the Message Success: You have added "<product>" to your shopping cart!
    And I click on link shopping cart into message
    Then Verify Shopping cart text "Shopping Cart"
    Then Verify the Product name "<product>"
    Then Verify the Model "<model>"
    Then Verify the Total "<price>"
    Examples:
      | product   | model      | price   |
      | HP LP3065 | Product 21 | £74.73 |


