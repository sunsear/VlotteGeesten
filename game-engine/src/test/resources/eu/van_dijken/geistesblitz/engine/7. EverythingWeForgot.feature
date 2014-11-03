Feature: Scenarios we forgot
  It turns out that the features we came up with lead to a game that works, mostly ;-) These scenarios include rules
  that we figured out while actually wiring up the game

  Scenario: 21. Neither player chooses the correct solution
    What happens if neither player selects the correct solution? In our initial implementation this resulted in...
    Wait for it...
    A NullPointerException, Yay!
    Given a new round of play showing a card with a "Gray Mouse" and a "Green Book"
    And player 1 has won 1 cards
    And player 2 has won 1 cards
    When player 1 chooses the "Green Bottle"
    And player 2 chooses the "Blue Book"
    And the round finishes
    Then the shown card is no longer in the deck
    And no player has won the card
    And player 1 still has 1 cards
    And player 2 still has 1 cards

  Scenario: 22-?. The correctly colored item is only shown on a card once with each other item
    Using the features and examples you have gotten so far, we initially generate a deck of 120 cards. As the game
    requires 60 cards, this means that we have to prune a bunch of cards. Upon further analysing the deck that is in
    the actual physical game, it turns out that there is an extra rule for card generation. Each correctly colored
    game item is shown once with each other item which is then not in the correct color. This means that in a deck, we
    only have 4 cards showing a White Ghost and some other item.

    Good luck!
