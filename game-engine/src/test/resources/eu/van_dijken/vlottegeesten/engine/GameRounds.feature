Feature: Game Rounds
  Each round starts by the game providing a random card from the deck. Players can attempt to provide a solution
  for the card shown. The first player to select the correct solution is given the card that was shown. That player
  adds the card shown to his pile. A player providing an incorrect solution will lose a card from his pile. A
  player may only provide a single solution.

  Background: Setting up a 2 player game
    Given a new game of Vlotte Geesten
    And 2 players in the game

  Scenario: Player chooses the correct solution
    Given a new round of play showing a card with a "Gray Mouse"
    When player 1 chooses the "Gray Mouse"
    And the round finishes
    Then player 1 has won the shown card
    And the shown card is no longer in the deck

  Scenario: Player 1 chooses an incorrect solution and has to give a card to winning player 2.
    Given a new round of play showing a card with a "Gray Mouse" and a "Green Book"
    And player 1 has won 1 cards
    When player 1 chooses the "Green Bottle"
    And player 2 chooses the "Gray Mouse"
    And the round finishes
    Then player 2 has won the shown card
    And the shown card is no longer in the deck
    And player 1 has to give a card away, reducing his total of won cards to 0
    And player 2 has received an extra card, making his total of won cards 2

  Scenario: Player 1 chooses an incorrect solution but has no cards to give away.
    Given a new round of play showing a card with a "Gray Mouse" and a "Green Book"
    And player 1 has won 0 cards
    When player 1 chooses the "Green Bottle"
    And player 2 chooses the "Gray Mouse"
    And the round finishes
    Then player 2 has won the shown card
    And the shown card is no longer in the deck