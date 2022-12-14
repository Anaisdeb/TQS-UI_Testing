Feature: Buy

Scenario: Buy a Fly
  
Given the user is on the application index page
When the user click cookie button
And the user clicks the <Offers>
And the user click the fly hour
And the user enters the personal information <FirstName>, <LastName>, <Email>, <Phone>, <Address>
And the user enters the traveller information <FirstName1>, <LastName1>, <Passport>
And the user confirm the Booking
Then the booking status is <Pending>

Examples:
|Email              |Password|FirstName|LastName|FirstName1|LastName1|Email           |Phone    |Address  |Passport |Offers                          |Pending                                                                                       |
|user@phptravels.com|demouser|Maria    |Fortune |Maria     |Fortune  |mariaF@gmail.com|123456789|barcelona|Passport1|//*[@id="new-york"]/div/div[2]/a|//*[@id="fadein"]/section/div/div/div/div/div[2]/div[3]/strong/div[2]/div/div[1]/form/input[3]|

Scenario: Buy a Hotel

Given the user is on the application index page
When the user click cookie button
And the user clicks the <Offers>
And the user click the first hotel option
And the user enters the personal information <FirstName>, <LastName>, <Email>, <Phone>, <Address>
And the user enters the travellers information <FirstName1>, <LastName1>, <FirstName2>, <LastName2>, <FirstName3>, <LastName3>, <FirstName4>, <LastName4>
And the user confirm the Booking
Then the booking status is <Pending>

Examples:
|Email              |Password|FirstName|LastName|FirstName1|LastName1|FirstName2|LastName2|FirstName3|LastName3|FirstName4|LastName4|Email           |Phone    |Address  |Offers                                                                                |Pending                                                                                   |
|user@phptravels.com|demouser|Maria    |Fortune |Marc      |Fortune  |Juan      |Fortune  |Luis      |Fortune  |Maria     |Fortune  |mariaF@gmail.com|123456789|barcelona|//*[@id="fadein"]/section[3]/div/div/div[2]/div/div/div/div[1]/div/div[7]/div/div[1]/a|//*[@id="fadein"]/section[1]/div/div/div/div/div[2]/div[3]/div[3]/div/div[1]/form/input[3]|

Scenario: Buy a Tour
  
Given the user is on the application index page
When the user click cookie button
And the user clicks the <Offers>
And the user enters the tour participants
And the user enters the personal information <FirstName>, <LastName>, <Email>, <Phone>, <Address>
And the user enters the tour travellers information <FirstName1>, <LastName1>, <FirstName2>, <LastName2>, <FirstName3>, <LastName3>, <FirstName4>, <LastName4>
And the user confirm the Booking
Then the booking status is <Pending>

Examples:
|Email              |Password|FirstName|LastName|FirstName1|LastName1|FirstName2|LastName2|FirstName3|LastName3|FirstName4|LastName4|Email           |Phone    |Address  |Offers                                                            |Pending                                                                                     |
|user@phptravels.com|demouser|Maria    |Fortune |Marc      |Fortune  |Juan      |Fortune  |Luis      |Fortune  |Maria     |Fortune  |mariaF@gmail.com|123456789|barcelona|//*[@id="fadein"]/section[4]/div/div/div[2]/div[1]/div/div[1]/a[1]|//*[@id="fadein"]/section[1]/div/div/div/div/div[2]/div[3]/div[3]/div/div[1]/form/input[3]|