Feature: The deck of cards

  Scenario: The deck of cards
    Given a game of GeistesBlitz
    Then there should be a deck of 1 different valid cards
#In progress towards: Then there should be a deck of 80 different valid cards

  Scenario Outline: Each combination of two items is depicted the same number of times
    Given a game of GeistesBlitz
    Then there should be 1 cards depicting <item1> and <item2>
#In progress towards: Then there should be 8 cards depicting <item1> and <item2>

    Examples:
      | item1 | item2  |
      | ghost | mouse  |
#In progress towards:
#      | chair | bottle |

#  Scenario Outline: Each combination of two items is used once to lead to each depicted item as the desired item
#    Given a game of GeistesBlitz
#    Then there should be 1 card depicting <item1> and <item2> for which the desired item is <item1>
#
#    Examples:
#      | item1 | item2 |
#      | ghost | chair |
#      | chair | ghost |
#
##Next step: get the above to "green" + 2nd scenario in ValidCards
#
#  Scenario Outline: Each combination of two items is used at least once to lead to each item not depicted as the desired item
#    Given a game of GeistesBlitz
#    Then there should be at least 1 card depicting <item1> and <item2> for which the desired item is <item3>
#
#    Examples:
#      | item1 | item2 | item3  |
#      | ghost | chair | bottle |
#      | ghost | chair | mouse  |
#
#  Scenario Outline: Each item is the desired item the same number of times
#    Given a game of GeistesBlitz
#    Then there should be 16 cards for which the desired item is <item>
#
#    Examples:
#      | item  |
#      | ghost |
#      | chair |
