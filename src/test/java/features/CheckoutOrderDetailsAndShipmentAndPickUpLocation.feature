Feature:
  As a customer
  I want to be able proceed to checkout
  So can check totals prices on the Order Details and Shipment and Pick up Location pages

  @XXXX
  Scenario: Proceed to checkout, final review
    Given I am anonymous customer and I open main page
    When I search for 1934793 product and I am redirected to search results page
    And I click "Add to Cart" button for product "1934793"
    And I select Check out in cart pop-up (Shopping Cart Form) and I am redirected to Cart page (Order Details page)
    Then I can review order summary
      | Subtotal | Total  |
      | $99.85   | $99.85 |
    When I click checkout button after redirect to cart page (Order Details page)
    And I checkout as guest user with "test@user.com" email and I am redirected to a "Multocheckout delivery address page" (Shipment And Pick Up Location page)
    Then I have the following final review
      | Submotal | Total  | Tax   |
      | $99.85   | $99.85 | $4.75 |
