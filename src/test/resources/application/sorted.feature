Feature: Sorted
  Sorted algorithm works

  Scenario Outline: Sorted
    Given Input is "<input>"
    When It is sorted
    Then Output should be "<output>"

    Examples:
      | input      | output    |
      | 1,2,3,4,5  | 1,2,3,4,5 |
      | 2,1,3,5,4  | 1,2,3,4,5 |
      | 4,1,2,5,3  | 1,2,3,4,5 |