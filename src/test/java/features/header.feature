Feature: Header

Scenario: Change the currency
Given the user is on the main page
When the user click the currency
And the user change the <Currency>
Then the price is in the right <Currency>

Examples: 
|Currency|
|EUR     |
|RUB     |
|TRY     |
|GBP     |
|JPY     |
