Feature: Playing Cards should have a solution
  A card depicts 2 images of an item. A card always leads to one desired item.

  Scenario: 3. Number of images on card
    Given A random Playing Card
    Then it should contain 2 images

  Scenario: Solution is the item that is shown in the right colour
    Given a playing card with items displayed:
      | color | item  |
      | Grey  | Mouse |
      | Blue  | Ghost |
    Then the correct solution should be the "Grey Mouse"

  Scenario: 
    Given a playing card with items displayed:
      | color | item  |
      | Blue  | Mouse |
      | Red   | Chair |
    Then the correct solution should be the "Red Chair"

  Scenario: 5. Solution is the item that is not shown and of which the colour was not shown
    Given a playing card with items displayed:
      | color | item  |
      | Blue  | Mouse |
      | Red   | Ghost |
    Then the correct solution should be the "Green Bottle"

  Scenario: 
    Given a playing card with items displayed:
      | color | item   |
      | Blue  | Bottle |
      | Grey  | Chair  |
    Then the correct solution should be the "White Ghost"

  Scenario: 6. Wrong item chosen
    Given a playing card with items displayed:
      | color | item   |
      | Blue  | Bottle |
      | Grey  | Chair  |
    Then "Red Chair" should not be a correct solution

  Scenario: 
    Given a playing card with items displayed:
      | color | item   |
      | Blue  | Bottle |
      | Grey  | Chair  |
    Then "Grey Mouse" should not be a correct solution
