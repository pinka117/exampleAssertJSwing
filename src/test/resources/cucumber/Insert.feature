@insert
Feature: insert

  @insert
  Scenario: labels
    Given the main frame is visible
    When I click Add contact
    Then a label Name is visible
    And a label Id is visible
    And a label Mail is visible

  @insert
  Scenario: insertOkOneContact
    Given the main frame is visible
    And I click Add contact
    When I insert name Mario
    And I insert id 1
    And I insert mail mario.it
    And I click Ok
    And I click Return
    Then a label 1 is visible
    And a label Mario is visible
    And a label mario.it is visible
@insert
  Scenario: insertOkMoreContacts
    Given the main frame is visible
    And I click Add contact
    When I insert name Mario
    And I insert id 1
    And I insert mail mario.it
    And I click Ok
    And I insert name Lucia
    And I insert id 2
    And I insert mail lucia.it
    And I click Ok
    And I click Return
    Then a label 1 is visible
    And a label Mario is visible
    And a label mario.it is visible
    And a label 2 is visible
    And a label Lucia is visible
    And a label lucia.it is visible
     @insert
  Scenario: insertEmptyLine
    Given the main frame is visible
    And I click Add contact
    When I click Ok
    Then Error message empty
    @insert
  Scenario: insertEmptyLineThenOKLine
    Given the main frame is visible
    And I click Add contact
    And I click Ok
    And Error message empty
    When I insert name Mario
    And I insert id 1
    And I insert mail mario.it
    And I click Ok
    And I click Return
    Then a label 1 is visible
    And a label Mario is visible
    And a label mario.it is visible
      @insert
  Scenario: duplicateId
  Given the main frame is visible
    And I click Add contact
    When I insert name Mario
    And I insert id 1
    And I insert mail mario.it
    And I click Ok
    When I insert name Mario
    And I insert id 1
    And I insert mail mario.it
    And I click Ok
    Then Error message Duplicate Id