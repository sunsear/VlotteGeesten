Feature: Scenarios we forgot
  It turns out that the features we came up with lead to a game that works, mostly ;-) These scenarios include rules
  that we figured out while actually wiring up the game

  Background: Setting up a 2 player game
    Given a new game of GeistesBlitz
    And 2 players in the game

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
