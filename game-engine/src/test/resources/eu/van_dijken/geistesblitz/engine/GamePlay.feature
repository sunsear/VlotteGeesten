Feature: Game Play
  In order to play the game
  players
  want to enforce rules on the order and rules of play

  Scenario: 14. Minimum number of players allowed
    Given a new game of GeistesBlitz
    Then the minimum number of players is 2

  Scenario: 15. Maximum number of players allowed
    Given a new game of GeistesBlitz
    Then the maximum number of players is 8.