@delete
Feature: delete

  @delete
  Scenario: deleteOk
    Given I want to delete
    And An employee with id 1 is present
    When I remove an employee with id 1
    Then An employee with id 1 is not present
