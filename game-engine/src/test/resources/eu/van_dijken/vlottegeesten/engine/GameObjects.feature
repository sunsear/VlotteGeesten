Feature: Game Objects

  Scenario: Checking the playing objects
    Given A new game of Vlotte Geesten
    Then the following playing objects should be present:
      | color | type   |
      | White | Ghost  |
      | Red   | Chair  |
      | Blue  | Book   |
      | Green | Bottle |
      | Grey  | Mouse  |
    And the following playing objects should not be present:
      | color | type   |
      | White | Chair  |
      | Blue  | Bottle |
