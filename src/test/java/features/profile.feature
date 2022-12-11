Feature: Profile

Scenario: Edit profile

Given the user is on the customer dashboard page
When the user clicks the account button
And the user clicks the profile button
And the user enters the <field> field with <value>
And the user clicks the update button
Then the profile is updated for <field> with <value>

Examples:
|field|value|
|firstname|Diego|
|lastname|López|
|phone|98765|
|state|Spain|
|city|Barcelona|
|zip|08039|
|address1|Rambla de Mar|