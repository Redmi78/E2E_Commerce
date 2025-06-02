Feature: Customer Registration and Payment

  Scenario Outline: Verify customer Registration and Payment
    Given I open the PrestaShop demo site
    When I search for products '<Products>'
    And Click on search button
    And click on the specific product '<Product Name>'
    Then select quantity '<Quantity>'
    And click on the "Add to cart" button
    Then I should see the product "<Product Name>" in the cart with quantity "<Quantity>"
    And Click on proceed to checkout button
    And I fill user personal details



    Examples:
      | Products | Quantity | Product Name             |
      | Mug      | 2        | Mug The Adventure Begins |
