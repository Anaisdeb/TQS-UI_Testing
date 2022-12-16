Feature: Company 

Scenario: Move to Social Media
Given the user is on phptravels
When the user cliks to move to <AbaoutUs>
And the user move to the social <Account>
Then the page is the right social <Media>

Examples: 
|AbaoutUs                                                                               |Account                                       |Media   |
|//*[@id="fadein"]/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[8]/ul/li[1]/a |//*[@id="fadein"]/div[4]/div/div[2]/p[6]/a[1] |twitter |
|//*[@id="fadein"]/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[8]/ul/li[1]/a |//*[@id="fadein"]/div[4]/div/div[2]/p[6]/a[2] |facebook|

Scenario: Move to Campany Tabs
Given the user is on phptravels
When the user cliks to move to <Page>
Then the page is <Right> page

Examples: 
|Page                                                                                   |Right   |
|//*[@id="fadein"]/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[8]/ul/li[2]/a |Terms   |
|//*[@id="fadein"]/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[8]/ul/li[3]/a |FAQ     |
|//*[@id="fadein"]/header/div/div/div/div/div/div[2]/div/div[1]/nav/ul/li[8]/ul/li[4]/a |Book    |


