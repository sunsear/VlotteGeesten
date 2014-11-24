Feature: Game Materials

  Scenario:

  Scenario: Number of items
    Given a game of GeistesBlitz
	Then there should be 5 items present

  Scenario Outline: Items present
	Given a game of GeistesBlitz
	Then a <color> <item> should be present.
    Examples:
      | color | item   |
      | White | Ghost  |
      | Red   | Chair  |
      | Blue  | Book   |
      | Green | Bottle |
      | Gray  | Mouse  |

  Scenario: 2. The deck of cards
    Given a new game of GeistesBlitz
    Then the deck should contain 60 cards
