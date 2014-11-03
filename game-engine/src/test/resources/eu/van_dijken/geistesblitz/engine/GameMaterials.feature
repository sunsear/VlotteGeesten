Feature: Game Materials

  Scenario: Number of items
    Given a new game of GeistesBlitz
	Then there should be 5 items present

	Scenario: Items present
	Given a new game of GeistesBlitz
	Then the following items should be present:
      | color | type   |
      | White | Ghost  |
      | Red   | Chair  |
      | Blue  | Book   |
      | Green | Bottle |
      | Gray  | Mouse  |

  Scenario: 2. The deck of cards
    Given a new game of GeistesBlitz
    Then the deck should contain 60 cards
