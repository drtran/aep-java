require 'test/unit/assertions'
include Test::Unit::Assertions

Given(/^that I am on Amazon website$/) do
  @browser.goto "http://www.amazon.com"
end

And(/^I search for a "([^"]*)" book$/) do |search_text|
  @browser.text_field(:id => 'twotabsearchtextbox').send_keys(search_text)
  @browser.button(:class => 'nav-submit-input').click
end

And(/^I choose "([^"]*)"$/) do |book_name|
  texts = @browser.spans(:class => 'lrg bold').map do |span|
    if span.text.include? book_name
      span.parent.click
      break
    end
  end
end

And(/^I click Add to Cart button$/) do
  @browser.button(:id => 'add-to-cart-button').click
end

Then(/^I should see "([^"]*)" item in my shopping cart$/) do |arg|
  assert @browser.span(:id => 'nav-cart-count').text, "1"
  puts 'success!'
end
