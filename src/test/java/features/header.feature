Feature: Header

Scenario: Change the currency
Given the user is on the main page
When the user click the <Currency_Button> dropdown
And the user change the <Currency>
Then the page is in the right <Currency>

Examples: 
|Currency|Currency_Button|
|EUR     |currency       |
|RUB     |currency       |
|TRY     |currency       |
|PKR     |currency       |
|JPY     |currency       |

Scenario: Change the language
Given the user is on the main page
When the user click the <Language_Button> dropdown
And the user change the <Language>
Then the page is in the right <lan>

Examples: 
|Language|lan      |Language_Button|
|Russian |Гостиницы|languages      |
|Spanish |Hoteles  |languages      |