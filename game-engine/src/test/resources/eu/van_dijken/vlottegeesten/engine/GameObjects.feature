Feature: Game Objects
  In order to start the game
  Gamemaster
  wants to check the starting game state

  Scenario: 1. Checking the game items
    Given a new game of Vlotte Geesten
    Then the following items should be present:
      | color | type   |
      | White | Ghost  |
      | Red   | Chair  |
      | Blue  | Book   |
      | Green | Bottle |
      | Gray  | Mouse  |
    And the following items should not be present:
      | color | type   |
      | White | Chair  |
      | Blue  | Bottle |

  Scenario: 2. Checking the deck of cards
    Given a new game of Vlotte Geesten
    Then the deck should contain 60 cards
