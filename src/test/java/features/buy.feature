Feature: Buy

Scenario: Buy a Fly
  
Given the user is on the application index page
When the user clicks the cookie
And the user clicks the fly destination
And the user clicks the first fly
And the user enters the personal information <FirstName>, <LastName>, <Email>, <Phone>, <Address>
And the user enters the traveller information <FirstName1>, <LastName1>, <Passport>
And the user confirm the Booking
Then the fly booking status is pending

Examples:
|FirstName|LastName|FirstName1|LastName1|Email           |Phone    |Address  |Passport |
|Maria    |Fortune |Maria     |Fortune  |mariaF@gmail.com|123456789|barcelona|Passport1|

Scenario: Buy a Hotel

Given the user is on the application index page
When the user clicks the cookie
And the user clicks the hotel
And the user clicks the first option
And the user enters the personal information <FirstName>, <LastName>, <Email>, <Phone>, <Address>
And the user enters the travellers information <FirstName1>, <LastName1>, <FirstName2>, <LastName2>, <FirstName3>, <LastName3>, <FirstName4>, <LastName4>
And the user confirm the Booking
Then the hotel booking status is pending

Examples:
|FirstName|LastName|FirstName1|LastName1|FirstName2|LastName2|FirstName3|LastName3|FirstName4|LastName4|Email           |Phone    |Address  |Passport |
|Maria    |Fortune |Marc      |Fortune  |Juan      |Fortune  |Luis      |Fortune  |Maria     |Fortune  |mariaF@gmail.com|123456789|barcelona|Passport1|


Scenario: Buy a Tour
  
Given the user is on the application index page
When the user clicks the cookie
And the user clicks the tour 
And the user enters the tour participants
And the user enters the personal information <FirstName>, <LastName>, <Email>, <Phone>, <Address>
And the user enters the tour travellers information <FirstName1>, <LastName1>, <FirstName2>, <LastName2>, <FirstName3>, <LastName3>, <FirstName4>, <LastName4>
And the user confirm the Booking
Then the tour booking status is pending

Examples:
|FirstName|LastName|FirstName1|LastName1|FirstName2|LastName2|FirstName3|LastName3|FirstName4|LastName4|Email           |Phone    |Address  |Passport |
|Maria    |Fortune |Marc      |Fortune  |Juan      |Fortune  |Luis      |Fortune  |Maria     |Fortune  |mariaF@gmail.com|123456789|barcelona|Passport1|