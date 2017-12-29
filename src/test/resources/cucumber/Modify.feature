@modify
Feature: modify
  Scenario: modifyNameOk
    Given I want to modify
    And 1,name1,mail1 is present
    When i click modify1
    And I modify key 1 name to Lucia
    And i click ok
    Then 1,Lucia,mail1 is present
    Scenario: modifyMailOk
    Given I want to modify
    And 1,name1,mail1 is present
    When i click modify1
    And I modify key 1 mail to lucia.it
    And i click ok
    Then 1,name1,lucia.it is present
     Scenario: modifyBothOk
    Given I want to modify
    And 1,name1,mail1 is present
    When i click modify1
    And I modify key 1 mail to lucia.it
    And I modify key 1 name to Lucia
    And i click ok
    Then 1,Lucia,lucia.it is present
    Scenario: modifyEmptyMail
    Given I want to modify
     And 1,name1,mail1 is present
    When i click modify1
    And I insert empty mail  
    And i click ok
    And there is a label empty
    When i click Return
    Then 1,name1,mail1 is present
    Scenario: modifyEmptyName
    Given I want to modify
     And 1,name1,mail1 is present
    When i click modify1
    And I insert empty name  
    And i click ok
    And there is a label empty
    When i click Return
    Then 1,name1,mail1 is present
