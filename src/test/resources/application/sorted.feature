Feature: Sorted
  Sorted algorithm works

  Scenario Outline: Sorted
    Given input is "<input>"
    When it is sorted
    Then output should be "<output>"

    Examples:
      | input      | output    |
      | 1,2,3,4,5  | 1,2,3,4,5 |
      | 2,1,3,5,4  | 1,2,3,4,5 |
      | 4,1,2,5,3  | 1,2,3,4,5 |