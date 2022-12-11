Feature: Research

Scenario: Research flights

Given the user is on the application research page
When the user clicks the flights option
And the user enters the <way>, <type>, <from>, <to>, <departure>, <back>, <adults>, <childs>, <infants> fields
And the user clicks the research button
Then the research result is <way>, <type>, <from>, <to>, <departure>, <back>, <adults>, <childs>, <infants>

Examples:
|way|type|from|to|departure|back|adults|childs|infants|
|one-way|Economy|PAR|BCN|25-12-2022||1|0|0|
|one-way|Economy Premium|BUD|PRG|01-02-2023||1|1|1|
|round-trip|Business|MIL|ATH|15-03-2023|18-03-2023|2|2|2|
|round-trip|First|MAD|LIS|20-04-2023|04-05-2023|3|3|3|