Feature: Sorted
  Sorted algorithm works

  Scenario Outline: Sorted
    Given input is "<input>"
    When it is sorted
    Then output should be "<output>"

    Examples:
      |         input          |         output         |
      | 1,2,3,4,5              | 1,2,3,4,5              |
      | 2,1,3,5,4              | 1,2,3,4,5              |
      | 4,1,2,5,3              | 1,2,3,4,5              |
      | 1                      | 1                      |
      | 1,2                    | 1,2                    |
      | 5,4                    | 4,5                    |
      | 1,2,3                  | 1,2,3                  |
      | 5,3,1,4                | 1,3,4,5                |
      |                        |                        |
      | -1,-2,-3,-4,-5         | -5,-4,-3,-2,-1         |
      | -590,754,-687,-317,731 | -687,-590,-317,731,754 |
      | -128,76,675,632,-985   | -985,-128,76,632,675   |
      | -138,949,996,-189,-638 | -638,-189,-138,949,996 |
      | 485,-720,869,-119,-646 | -720,-646,-119,485,869 |