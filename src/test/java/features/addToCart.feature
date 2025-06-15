Feature: Search and Add to Cart

  Scenario: Search for a product and add it to cart
    Given I open the PrestaShop demo site
    When I search for "Mug"
    And Click on search button
    Then I should see search results for 'Mug'


  Scenario Outline: Search for a product and add it to cart with specific quantity
    Given I open the PrestaShop demo site
    When I search for products '<Products>'
    And Click on search button
    And click on the specific product '<Product Name>'
    Then select quantity '<Quantity>'
    And click on the "Add to cart" button
    Then I should see the product "<Product Name>" in the cart with quantity "<Quantity>"

    Examples:
      | Products | Quantity | Product Name             |
      | Mug      | 2        | Mug The Adventure Begins |



  Scenario: Search for a product and do a sorting
    Given I open the PrestaShop demo site
    When I search for "Mug"
    And Click on search button
    Then I should see search results for 'Mug'
    And I sort the products by "Price, low to high"





