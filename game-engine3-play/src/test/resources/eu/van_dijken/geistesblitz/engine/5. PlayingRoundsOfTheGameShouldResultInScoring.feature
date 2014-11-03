Feature: Playing rounds of the game should result in scoring
  Each round starts by drawing a card from the randomized deck. Players attempt to provide the desired item
  for the card shown. The first player to provide the desired item is given the card that was shown. That player
  adds the card shown to his pile. A player providing an incorrect item will lose a card from his pile. A
  player may only make one attempt.

  Background: Setting up a 2 player game
    Given a new game of GeistesBlitz
    And 2 players in the game

  Scenario: 16. Player chooses the correct solution
    Given a new round of play showing a card
    When player 1 provides the desired item
    Then the round finishes
    And player 1 has won the shown card
    And the shown card is no longer in the deck

  Scenario: 17. Player 1 chooses an incorrect item and has to give a card to winning player 2.
    Given a new round of play showing a card
    And player 1 has won 1 cards
    And player 2 has won 0 cards
    When player 1 provides an incorrect item
    And player 2 provides the desired item
    Then the round finishes
    And player 2 has won the shown card
    And the shown card is no longer in the deck
    And player 1 has to give a card away, reducing his total of won cards to 0
    And player 2 has received an extra card, making his total of won cards 2

  Scenario: 18. Player 1 chooses an incorrect item but has no cards to give away.
    Given a new round of play showing a card
    And player 1 has won 0 cards
    When player 1 provides an incorrect item
    And player 2 provides the desired item
    Then the round finishes
    And player 2 has won the shown card
    And the shown card is no longer in the deck
    And player 1 now has a total of won cards of 0
    And player 2 now has a total of won cards of 1
