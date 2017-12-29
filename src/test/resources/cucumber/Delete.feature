@delete
Feature: delete

  @delete
  Scenario: deleteOk
    Given I want to delete
    And id 1 is present
    When i remove id 1
    Then id 1 not present
