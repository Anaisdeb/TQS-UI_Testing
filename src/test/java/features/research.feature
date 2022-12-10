Feature: Research

Scenario: Research flights

Given the user is on the application landing page
When the user clicks the flights option
And the user enters the <way> <type> <from> <to> <back> <return> <adults> <childs> <infants> fields
And the user clicks the research button
Then the first flight is <first> <price>

Examples:
|way|type|from|to|departure|back|adults|childs|infants|first|price|
|one-way|Economy|PAR|BCN|25-12-2022||1|0|0|3:35|116.6|
|one-way|Business|PAR|BCN|25-12-2022||1|0|0|10:05|345.4|
|one-way|Economy|PAR|BCN|25-12-2022||2|1|1|3:35|377.3|
|round-trip|First|MAD|LIS|01-01-2023|05-01-2023|1|0|0|6:30|88|