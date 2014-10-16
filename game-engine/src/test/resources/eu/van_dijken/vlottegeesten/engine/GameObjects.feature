Feature: Game Objects
  In order to start the game
  Gamemaster
  wants to check the starting game state

  Scenario: 1. Checking the game tokens
    Given A new game of Vlotte Geesten
    Then the following game tokens should be present:
      | color | type   |
      | White | Ghost  |
      | Red   | Chair  |
      | Blue  | Book   |
      | Green | Bottle |
      | Grey  | Mouse  |
    And the following game tokens should not be present:
      | color | type   |
      | White | Chair  |
      | Blue  | Bottle |

  Scenario: 2. Checking the deck of cards
    Given A new game of Vlotte Geesten
    Then the deck should contain 60 cards
