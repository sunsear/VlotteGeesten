Feature: Winning Conditions
  As soon as the deck is empty or the players decide to quit, the player with the most cards wins. If there is a tie and
  there is more than 1 player with the highest number of cards, there is no winner.

  Background: Setting up a 3 player game
    Given a new game of Vlotte Geesten
    And 3 players in the game

  Scenario: Player with the most cards wins.
    Given player 1 has won 30 cards
    And player 2 has won 15 cards
    And player 3 has won 15 cards
    When the game finishes
    Then player 1 has won the game

  Scenario: Highest player tied, no winner.
    Given player 1 has won 25 cards
    And player 2 has won 25 cards
    And player 3 has won 10 cards
    When the game finishes
    Then there is no winner
