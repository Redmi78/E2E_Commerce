Feature: Search and Add to Cart

  Scenario: Search for a product and add it to cart
    Given I open the PrestaShop demo site
    When I search for "Mug"
    And Click on search button
    Then I should see search results for "Mug"
   And Verify all products related to Mugs