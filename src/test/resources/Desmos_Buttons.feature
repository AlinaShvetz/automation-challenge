Feature: For any button input calculator displays correct output
  Background: User is on Desmos calculator branding page

    Scenario Outline: Verify that all numeric key inputs correspond to numeric key outputs (0-9)
      When  I click on <digit_btn> keyboard input
      Then The output screen is displaying <digit>
      Examples:
                |digit_btn  |digit   |
                |"0"        |"0"     |
                |"1"        |"1"     |
                |"2"        |"2"     |
                |"3"        |"3"     |
                |"4"        |"4"     |
                |"5"        |"5"     |
                |"6"        |"6"     |
                |"7"        |"7"     |
                |"8"        |"8"     |
                |"9"        |"9"     |



    Scenario Outline: Verify that all operation key inputs correspond to operation key outputs ( +, -, /, *, Sqrt, =, .)
      When I click on any operation <button> on calculator keyboard
      Then The <operation> on the output screen corresponds to the input
      Examples:
                |button|operation|
                |+     |+        |
                |-     |-        |
                |/     |/        |
                |*     |*        |
                |Sqrt  |Sqrt     |
                |=     |=        |
                |.     |.        |

    Scenario Outline: Verify that "Enter" button stores user's input
      When  I create a new <input> and click "Enter"
      Then  The inputted value is stored on upper section of the screen
      Examples:
               |input  |
               |3      |
               |3+19   |
               |Srt16  |

   Scenario Outline: Verify that navigation buttons on action bar work correspondingly
    Given There are 3 inputs on calculator screen
    When  I click a navigation button
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
      When  I click any deletion button
             |button  |
             |<button>|
      Then  The corresponding number of <input> is deleted
      Examples:
             |button   |input    |
             |Cross    |1 digit  |
             |Clear    |1 input  |
             |Clear all|4 inputs |





