Feature: Order confirmation after Registration and Payment

  Scenario Outline: Verify customer order confirmation after Registration and Payment
    Given I open the PrestaShop demo site
    When I search for products '<Products>'
    And Click on search button
    And click on the specific product '<Product Name>'
    Then select quantity '<Quantity>'
    And click on the "Add to cart" button
    Then I should see the product "<Product Name>" in the cart with quantity "<Quantity>"
    And Click on proceed to checkout button
    And I fill user personal details
    And  I fill address details
    And I select shipping method
    And I select payment method
    Then I should see order confirmation message



    Examples:
      | Products | Quantity | Product Name             |
      | Mug      | 2        | Mug The Adventure Begins |