Feature: Validate Links in Bulls Home Page
Scenario: Validate Footer Links
Given Land on Bulls Home Page with "firefox"
When Scroll to Footer
And Write Footer Links to Excel in "footerHyperLinks.xlsx"
Then Assert if any Link is a Duplicate