# Given(/^I am on the puppy adoption site$/) do
#   visit(HomePage)
# end

When(/^I click the View Details button for "(.*?)"$/) do |puppy_name|
  on(HomePage).select_puppy puppy_name
end

# And(/^I click the Adopt Me! button$/) do
#   on(DetailsPage).add_to_cart
# end
#
# And(/^I click the Complete the Adoption button$/) do
#   on(ShoppingCartPage).proceed_to_checkout
# end

And(/^I complete the adoption with$/) do |table|
  on(CheckoutPage).checkout(table.hashes.first)
end

# Then(/^I should see "(.*?)"$/) do |expected|
#   @current_page.text.should include expected
# end

When /^I complete the adoption using a Credit card$/ do
  on(CheckoutPage).checkout('pay_type' => 'Credit card')
end

When /^I complete the adoption$/ do
  on(CheckoutPage).checkout
end

When /^I complete the adoption of a puppy$/ do
  on(HomePage).select_puppy "Brook"
  on(DetailsPage).add_to_cart
  on(ShoppingCartPage).proceed_to_checkout
  on(CheckoutPage).checkout
end