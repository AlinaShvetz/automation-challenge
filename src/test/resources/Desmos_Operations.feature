Feature: Calculator displays correct results for any of any arithmetical operation
  Background: User is on Desmos calculator branding page

   Scenario Outline: Verify that arithmetical operations with negative numbers could be performed
     When I perform an arithmetic operation with any negative number
       |input1  |operation   |input2  |
       |<input1>|<operation> |<input2>|

     Then I get a correct <result>
       Examples:
         |input1|operation|input2 |result|
         |-82   |+        |-892   |-974  |
         |221   |*        |-22    |-4862 |


   Scenario Outline: Verify that any arithmetic operation with decimal numbers could be performed
     When I perform an arithmetic operation with any decimal number
       |input1  |operation   |input2  |
       |<input1>|<operation> |<input2>|
     Then I get a correct <result>
       Examples:
         |input1  |operation   |input2  |result|
         |22.2    |*           |7       |155.4 |
         |29.0    |/           |0.2     |145   |


  Scenario Outline: Verify that arithmetic operations are executed in the correct order
    When I perform an arithmetic operation with more than two numbers
      |input1  |operation   |input2  |operation2  |input3  |operation3  |input4  |
      |<input1>|<operation> |<input2>|<operation2>|<input3>|<operation3>|<input4>|
    Then I get a correct <result> thus the order of operations is respected
    Examples:
      |input1  |operation   |input2  |operation2  |input3  |operation3  |input4  |result|
      |55      |/           |5       |+           |6       |-           |2       |15    |
      |11      |+           |14      |*           |200     |-           |7       |2804  |


  Scenario Outline: Verify that * and / operations can not be executed consequentially
    When I perform two arithmetic operation consequentially
        |input1  |operation   |operation2  |input2  |
        |<input1>|<operation> |<operation2>|<input2>|

    Then I get either a valid result or an error message
        |result  |
        |<result>|
      Examples:
        |input1  |operation   |operation2  |input2  |result |
        |7       |-           |-           |2       |9      |
        |18      |*           |/           |23      |"error"|

  Scenario Outline: Verify that square root operation can be performed for square and non-square numbers
    When I extract square root from any square or non-square numbers
      |SquareRoot    |input1  |
      |<SquareRoot>  |<input1>|
    Then I get a correct <result>
    Examples:
      |SquareRoot  |input1   |result|
      |v           |25       |5     |
      |V           |17       |4.1   |


  Scenario Outline: Verify that square root operation can be performed in context of other arithmetical operations
    When I perform any arithmetic operation under square root
      |SquareRoot    |input1  |operation  |input2  |
      |<SquareRoot>  |<input1>|<operation>|<input2>|
    Then I get a correct <result>
    Examples:
      |SquareRoot    |input1   |operation  |input2   |result|
      |V             |200      |/          |25       |15    |
      |V             |100      |*          |32       |320   |

  Scenario Outline: Verify that Not any zero related arithmetic operation is possible to perform
    When I accomplish any zero related operation
      |input1  |operation   |input2  |
      |<input1>|<operation> |<input2>|
    Then I get a corresponding <result>
    Examples:
      |input1  |operation   |input2  |result  |
      |0       |*           |7       |0       |
      |29.0    |\           |0       |"error" |
