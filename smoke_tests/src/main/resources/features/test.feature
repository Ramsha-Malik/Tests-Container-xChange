
Feature: Support & FAQ page
Smoke Testcases for Suppot & FAQ page 

Scenario: Title and Search field are shown properly
When user navigates to Support & FAQ page
Then title displays successfully
And search field is shown

Scenario: All main tabs heading and text is displayed properly
When user navigates to Support & FAQ page
Then total all tabs should be displayed with correct text

Scenario Outline: Article searching feature is working
When user navigates to Support & FAQ page
And user enters "<search>" and press enter
Then total "<no_of_articles>" results for "<search>" should be shown
Examples:
|search        |no_of_articles|
|not connecting|66            |
|support			 |17						|

Scenario: Navigation from main page to Getting Started page is working properly
When user navigates to Support & FAQ page
And user scrolls down
And  user clicks on Getting started button
Then Getting Started title appears
And subheading Create a new team appears
And user scrolls down
Then subheading First steps with Wire appears
And subheading Group conversations appears

Scenario: Navigation from main page to Team Management page is working properly
When user navigates to Support & FAQ page
And user scrolls down
And user clicks on Team Management button
Then Team Management title appears
And subheading Adjusting settings & permissions appears
And subheading Billing, payments & plans appears
And user scrolls down
Then subheading Authentication appears
And subheading Services appears
 
Scenario: Navigation from Getting Started page to sub tab Team Management is working properly
When user navigates to Support & FAQ page
And user scrolls down
And user clicks on Getting started button
And user clicks on Team Management tab
Then Team Management title appears
And subheading Adjusting settings & permissions appears
And subheading Billing, payments & plans appears
And user scrolls down
Then subheading Authentication appears
And subheading Services appears


  	