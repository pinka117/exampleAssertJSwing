@insert
Feature: insert

  @insert
  Scenario: labels
    Given The main frame is visible
    When I click Add contact
    Then A label Name is visible
    And A label Id is visible
    And A label Mail is visible

  @insert
  Scenario: insertOkOneContact
    Given The main frame is visible
    And I click Add contact
    When I insert name Mario
    And I insert id 1
    And I insert mail mario.it
    And I click Ok
    And I click Return
    Then A label 1 is visible
    And A label Mario is visible
    And A label mario.it is visible
@insert
  Scenario: insertOkMoreContacts
    Given The main frame is visible
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
    Then A label 1 is visible
    And A label Mario is visible
    And A label mario.it is visible
    And A label 2 is visible
    And A label Lucia is visible
    And A label lucia.it is visible
     @insert
  Scenario: insertEmptyId
    Given The main frame is visible
    And I click Add contact
    And I insert name Mario
    And I insert mail mario.it
    When I click Ok
    Then There is an error message empty
    Scenario: insertEmptyName
    Given The main frame is visible
    And I click Add contact
    And I insert mail mario.it
    And I insert id 1
    When I click Ok
    Then There is an error message empty
    Scenario: insertEmptyMail
    Given The main frame is visible
    And I click Add contact
    And I insert name Mario
    And I insert id 1
    When I click Ok
    Then There is an error message empty
    @insert
  Scenario: insertEmptyLineThenOKLine
    Given The main frame is visible
    And I click Add contact
    And I click Ok
    And There is an error message empty
    When I insert name Mario
    And I insert id 1
    And I insert mail mario.it
    And I click Ok
    And I click Return
    Then A label 1 is visible
    And A label Mario is visible
    And A label mario.it is visible
      @insert
  Scenario: duplicateId
  Given The main frame is visible
    And I click Add contact
    When I insert name Mario
    And I insert id 1
    And I insert mail mario.it
    And I click Ok
    When I insert name Mario
    And I insert id 1
    And I insert mail mario.it
    And I click Ok
    Then There is an error message Duplicate Id