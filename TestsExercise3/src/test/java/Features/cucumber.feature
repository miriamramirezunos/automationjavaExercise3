Feature: cucumber feature
Scenario: Go to amazon page, login, search products and validate
Then Go to Amazon.com.mx
Given Login with valid credentials
And Search for product Samsung Galaxy S9 64GB 
And Select first product and save the price
And Click on the product
Then Validate first price vs detail price
When Click on Add to Cart
Then Validate again, first price vs current price
Then Validate that the Shop car has <1> as a number
When Search for another product: Alienware Aw3418DW
And Select First product
And Add to Cart
Then Verify that the cart number is now <2>
When End of test