Feature: Checking the number of players
  A game of GeistesBlitz only works with 2 to 8 players.

  Scenario: 14. Minimum number of players allowed
    Given a new game of GeistesBlitz
    Then the minimum number of players is 2

  Scenario: 15. Maximum number of players allowed
    Given a new game of GeistesBlitz
    Then the maximum number of players is 8.