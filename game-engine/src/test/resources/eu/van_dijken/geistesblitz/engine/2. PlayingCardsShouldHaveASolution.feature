Feature: Playing Cards should have a solution
  A card depicts 2 images of an item. A card always leads to one desired item.

  Scenario: 3. Number of images on card
    Given A random Playing Card
    Then it should contain 2 images

  Scenario: 4. Solution is the item that is shown in the right colour
    Given a playing card with items displayed:
      | color | type  |
      | Gray  | Mouse |
      | Blue  | Ghost |
    When the player chooses game item:
      | color | type  |
      | Gray  | Mouse |
    Then that is the correct solution
    Given a playing card with items displayed:
      | color | type  |
      | Blue  | Mouse |
      | Red   | Chair |
    When the player chooses game item:
      | color | type  |
      | Red   | Chair |
    Then that is the correct solution

  Scenario: 5. Solution is the item that is not shown and of which the colour was not shown
    Given a playing card with items displayed:
      | color | type  |
      | Blue  | Mouse |
      | Red   | Ghost |
    When the player chooses game item:
      | color | type   |
      | Green | Bottle |
    Then that is the correct solution
    Given a playing card with items displayed:
      | color | type   |
      | Blue  | Bottle |
      | Gray  | Chair  |
    When the player chooses game item:
      | color | type  |
      | White | Ghost |
    Then that is the correct solution

  Scenario: 6. Wrong item chosen
    Given a playing card with items displayed:
      | color | type   |
      | Blue  | Bottle |
      | Gray  | Chair  |
    When the player chooses game item:
      | color | type  |
      | Red   | Chair |
    Then that is not the correct solution
    Given a playing card with items displayed:
      | color | type   |
      | Blue  | Bottle |
      | Gray  | Chair  |
    When the player chooses game item:
      | color | type  |
      | Gray  | Mouse |
    Then that is not the correct solution
