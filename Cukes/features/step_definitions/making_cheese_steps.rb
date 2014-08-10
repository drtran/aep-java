Given(/^I have no cheese$/) do
  puts 'I am so sad. I have no cheese :('
end

When(/^I press the make "(.*?)" cheese button$/) do |type_of_cheese|
  puts 'I am making #{type_of_cheese} cheese!'
end

Then(/^I should see the "(.*?)" message$/) do |expected|
  puts expected
end
