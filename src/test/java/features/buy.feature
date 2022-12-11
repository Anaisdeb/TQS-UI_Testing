Feature: Buy

Scenario: Buy a Fly
  
Given the user is on the application landing page
When the user clicks the cookie
And the user clicks the fly destination
And the user clicks the first fly
And the user enters the personal information <FirstName>, <LastName>, <Email>, <Phone>, <Address>
And the user enters the travellers information <FirstName1>, <LastName1>, <Passport>
And the user confirm the Booking
Then the booking status is pending

Examples:
|FirstName|LastName|FirstName1|LastName1|Email           |Phone    |Address  |Passport |
|Maria    |Fortune |Maria     |Fortune  |mariaF@gmail.com|123456789|barcelona|Passport1|

