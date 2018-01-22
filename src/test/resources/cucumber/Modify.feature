@modify
Feature: modify
  Scenario: modifyNameOk
    Given I want to modify
    And An employee with 1,name1,mail1 is present
    When I click modify1
    And I modify key 1 name to Lucia
    And I click ok
    Then An employee with 1,Lucia,mail1 is present
    Scenario: modifyMailOk
    Given I want to modify
    And An employee with 1,name1,mail1 is present
    When I click modify1
    And I modify key 1 mail to lucia.it
    And I click ok
    Then An employee with 1,name1,lucia.it is present
     Scenario: modifyBothOk
    Given I want to modify
    And An employee with 1,name1,mail1 is present
    When I click modify1
    And I modify key 1 mail to lucia.it
    And I modify key 1 name to Lucia
    And I click ok
    Then An employee with 1,Lucia,lucia.it is present
    Scenario: modifyEmptyMail
    Given I want to modify
     And An employee with 1,name1,mail1 is present
    When I click modify1
    And I insert empty mail  
    And I click ok
    And there is a label empty
    When I click Return
    Then An employee with 1,name1,mail1 is present
    Scenario: modifyEmptyName
    Given I want to modify
     And An employee with 1,name1,mail1 is present
    When I click modify1
    And I insert empty name  
    And I click ok
    And There is a label empty
    When I click Return
    Then An employee with 1,name1,mail1 is present
