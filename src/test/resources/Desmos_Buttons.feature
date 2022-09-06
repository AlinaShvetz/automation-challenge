Feature: For any button input calculator displays correct output
  Background: User is on Desmos calculator branding page

    Scenario Outline: Verify that all numeric key inputs correspond to numeric key outputs (0-9)
      When The user clicks on any number <button> on calculator keyboard
      Then The <number> on the output screen corresponds to the input
      Examples:
                |button|number|
                |0     |0     |
                |1     |1     |
                |2     |2     |
                |3     |3     |
                |4     |4     |
                |5     |5     |
                |6     |6     |
                |7     |7     |
                |8     |8     |
                |9     |9     |
                |0     |0     |


    Scenario Outline: Verify that all operation key inputs correspond to operation key outputs ( +, -, /, *, V, =, .)
      When The user clicks on any operation <button> on calculator keyboard
      Then The <operation> on the output screen corresponds to the input
      Examples:
                |button|operation|
                |+     |+        |
                |-     |-        |
                |/     |/        |
                |*     |*        |
                |v     |v        |
                |=     |=        |
                |.     |.        |

    Scenario Outline: Verify that by hitting "Enter" button the user's input is stored
      When  The user creates a new <input> and clicks Enter button
      Then  The inputted value is stored on upper section of the screen
      Examples:
               |input|
               |3    |
               |3+19 |
               |v16  |

   Scenario Outline: Verify that navigation buttons on action bar work correspondingly
    Given There are 3 inputs on calculator screen
    When  The user clicks a navigation button "Back" button
              |button  |
              |<button>|
    Then  The the corresponding <input> is available for editing
    Examples:
              |button |input|
              |Back   |3    |
              |Back   |2    |
              |Forward|3    |

    Scenario Outline: Verify that deletion related buttons on calculator action bar work correspondingly
      Given There are 4 inputs on calculator screen
      When  The user clicks a deletion button
             |button  |
             |<button>|
      Then  The corresponding number of inputs is deleted
      Examples:
             |button   |input    |
             |Cross    |1 digit  |
             |Clear    |1 input  |
             |Clear all|4 inputs |





