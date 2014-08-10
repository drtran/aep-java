Given(/^I am on the puppy adoption site$/) do
  @browser.goto "http://puppies.herokuapp.com"
end

And(/^I click the Adopt Me! button$/) do
  @browser.button(:value => 'Adopt Me!').click
  @cart = ShoppingCartPage.new(@browser)
end

And(/^I click the Complete the Adoption button$/) do
  @cart.proceed_to_checkout
  @checkout = CheckoutPage.new(@browser)
end

And(/^I enter "(.*?)" in the name field$/) do |name|
  @checkout.name = name
end

And(/^I enter "(.*?)" in the address field$/) do |address|
  @checkout.address = address
end

And(/^I enter "(.*?)" in the email field$/) do |email|
  @checkout.email = email
end

And(/^I select "(.*?)" from the pay with dropdown$/) do |pay_type|
  @checkout.pay_type = pay_type
end

And(/^I click the Place Order button$/) do
  @browser.button(:value => 'Place Order').click
end

Then(/^I should see "(.*?)"$/) do |expected|
  @browser.text.should include expected
end

When(/^I click the first View Details button$/) do
  @browser.button(:value => 'View Details', :index => 0).click
end

And(/^I click the Adopt Another Puppy button$/) do
  @browser.button(:value => 'Adopt Another Puppy').click
end

And(/^I click the second View Details button$/) do
  @browser.button(:value => 'View Details', :index => 1).click
end

Then(/^I should see "(.*?)" as the name for line item (\d+)$/) do |puppy_name, line_item|
  @cart.name_for_line_item(line_item.to_i).should include puppy_name
end

And(/^I should see "(.*?)" as the subtotal for line item (\d+)$/) do |subtotal, line_item|
  @cart.subtotal_for_line_item(line_item.to_i).should == subtotal
end

And(/^I should see "(.*?)" as the cart total$/) do |total|
  @cart.cart_total.should == total
end
