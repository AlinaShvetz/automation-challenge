Feature: Calculator displays correct Results
  Background: User is on calculator page

  Scenario Outline: Checking the validity of results of TWO Integer numbers
    When User performs mathematical operation <operation> on two one digit numbers: <numberA> and <numberB>
    Then He gets the correct result <result>
    Examples:
      |numberA| operation| numberB|  result    |
      |9      |    /     | 3      |   3.0      |
      |8      |    +     | 3      |   11.0     |
      |2      |    *     | 7      |   14.0     |
      |9      |    -     | 8      |   1.0      |
      |2      |    v     | 8      |   5.656854 |

  Scenario Outline: Checking the validity of results of THREE Integer numbers
    When User performs mathematical operation <operation> on three numbers: <numberA> and <numberB> and <numberC>
    Then He gets the correct result <result>
    Examples:
      |numberA| operation| numberB| operation| numberC|result|
      |343    |+         |30      |+         |3       | 376.0  |
      |894    |-         |33      |-         |342     | 519.0  |
      |403    |/         |10      |/         |5       | 8.06   |
      |100    |*         |2       |*         |8       |1600.0  |


  Scenario Outline: Checking the validity of results by applying mixed operations

    When User performs mixed mathematical operation on three numbers: <numberA> <operation> <numberB> <operation2> <numberC>
    Then He gets the correct result <result>
    Examples:
      |numberA| operation| numberB| operation2| numberC|result      |
      |3      |+         |9       |-          |6       |   6.0      |
      |2      |v         |25      |*          |3       |   30.0     |
      |1      |-         |35      |/          |2       |  -16.5     |
      |34     |*         |2       |+          |7       |   75.0     |
      |2      |v         |16      |*          |5       |    40      |