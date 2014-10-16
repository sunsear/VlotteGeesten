Feature: Playing Card generation
  In order to have a correctly working set of cards
  Gamemaster
  wants to generate a set of valid cards

  Background: Setting up a new game
    Given a new game of Vlotte Geesten

  Scenario: 7. Card is valid only if a color is present at most once
    Given a playing card with tokens displayed:
      | color | type   |
      | Blue  | Bottle |
      | Blue  | Chair  |
    Then that card is not valid according to game rules
    Given a playing card with tokens displayed:
      | color | type   |
      | Blue  | Bottle |
      | Gray  | Chair  |
    Then that card is valid according to game rules

  Scenario: 8. Card is valid only if a token is present at most once
    Given a playing card with tokens displayed:
      | color | type   |
      | Red   | Bottle |
      | Blue  | Bottle |
    Then that card is not valid according to game rules

  Scenario: 9. Card is valid only if at most one game token is shown
    Given a playing card with tokens displayed:
      | color | type  |
      | Blue  | Mouse |
      | Red   | Ghost |
    Then that card is valid according to game rules
    Given a playing card with tokens displayed:
      | color | type  |
      | Gray  | Mouse |
      | Red   | Ghost |
    Then that card is valid according to game rules
    Given a playing card with tokens displayed:
      | color | type  |
      | Gray  | Mouse |
      | Red   | Chair |
    Then that card is not valid according to game rules

  Scenario: 10. Card is valid only if there is exactly one solution
    Given a playing card with tokens displayed:
      | color | type   |
      | Green | Mouse  |
      | Gray  | Bottle |
    Then that card is not valid according to game rules
    Given a playing card with tokens displayed:
      | color | type   |
      | Gray  | Bottle |
      | Red   | Mouse  |
    Then that card is not valid according to game rules
    Given a playing card with tokens displayed:
      | color | type   |
      | Gray  | Bottle |
      | Red   | Book   |
    Then that card is valid according to game rules
    Given a playing card with tokens displayed:
      | color | type  |
      | Gray  | Mouse |
      | Red   | Book  |
    Then that card is valid according to game rules

  Scenario: 11. Checking the validity of the complete deck of cards
    Given a new game of Vlotte Geesten
    Then the deck should contain 60 valid cards

  Scenario: 11. Checking the uniqueness of the complete deck of cards
    Given a new game of Vlotte Geesten
    Then the deck should contain 60 unique cards
