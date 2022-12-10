Feature: Login

Scenario: Login with credentials

Given the user is on the application landing page
When the user clicks the account option
And the user clicks the <profile> login
And the user enters valid <email> and valid <password>
And the user clicks the login button
Then the user login is <login>

Examples:
|profile|email|password|login|
|Customer|user@phptravels.com|demouser|1|
|Agents|agent@phptravels.com|demoagent|1|
|Supplier|supplier@phptravels.com|demosupplier|1|
|Customer|user@phptravels.com|a|0|
|Agents|agent@phptravels.com|b|0|
|Supplier|supplier@phptravels.com|c|0|