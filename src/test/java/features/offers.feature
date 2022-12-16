Feature: Offers

Scenario: Information on offers

Given the user is on the offers page
When the user clicks the <offer> offer
Then the offer information is <price>, <phone>, <email>, <date>

Examples:
|offer|price|phone|email|date|
|Lunch|USD 25|123456789|email@domain.com|January 1 1970|
|Rent Car|USD 80|123456789|email@phptravels.com|January 1 1970|
|Cheap Flights Tickets|USD 600|123456789|email@domain.com|January 1 1970|
|3 Nights Aegean Cruise|USD 200|123456789|email@domain.com|January 1 1970|
|Hotels Deals|USD 99|123456789|email@domain.com|January 1 1970|
|Summer Vacation|USD 150|123456789|email@domain.com|January 1 1970|