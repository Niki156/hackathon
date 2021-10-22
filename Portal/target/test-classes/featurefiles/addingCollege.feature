Feature: verifying college page functionalities

  Scenario: verifying add college page opened
    Given navigating to college page
    When user clicks on add college Button
    Then verify addCollegePage is opened

  Scenario: Adding a college
    Given navigating to college page
    When user clicks on add college Button
    And User adding college details
    |america paulings|cse|hyd|krish|le@gmail.com|9912418247|
    And click on save button
    Then verify CollegeAdded with given details