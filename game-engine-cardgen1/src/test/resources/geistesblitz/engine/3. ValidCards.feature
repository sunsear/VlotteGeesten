Feature: Valid cards
  Every card depicts two different items and leads to one desired item.

  Scenario: A) Item depicted in its original color. That item is the desired item.
    Given a card for which the desired item is the "mouse"
    And depicting the "mouse" and the "ghost"
    Then the "mouse" is depicted in "gray" and the "ghost" in neither "gray" nor "white"

#  Scenario:
#    Given a card for which the desired item is the "chair"
#    And depicting the "mouse" and the "chair"
#    Then the "chair" is depicted in "red" and the "mouse" in neither "red" nor "gray"

#  Scenario: B) No item depicted in its original color. The desired item is the item that is not depicted and whose original color is not shown on the card
#    Given a card for which the desired item is the "bottle"
#    And depicting the "mouse" and the "ghost"
#    Then the "mouse" is depicted in "blue" and the "ghost" in "red" or the "mouse" is depicted in "red" and the "ghost" in "blue"

#  Scenario: 
#    Given a card for which the desired item is the "ghost"
#    And depicting the "bottle" and the "chair"
#    Then the "bottle" is depicted in "gray" and the "chair" in "blue" or the "bottle" is depicted in "blue" and the "chair" in "gray"
