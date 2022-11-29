Feature: Login

Scenario: Login with credentials

Given the user is on the application landing page
When the user clicks the account option
And the user clicks the <profile> option
And the user enters valid <email> and valid <password>
And the user clicks the login button
Then the user login is <status>

Examples:
|profile|email|password|status|
|Customer|user@phptravels.com|demouser|valid|
|Agents|agent@phptravels.com|demoagent|valid|
|Supplier|supplier@phptravels.com|demosupplier|valid|
|Customer|user@phptravels.com|a|invalid|
|Agents|agent@phptravels.com|b|invalid|
|Supplier|supplier@phptravels.com|c|invalid|