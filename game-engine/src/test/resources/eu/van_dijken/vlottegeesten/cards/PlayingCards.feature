Feature: Playing Cards
  In order to have a correctly working set of cards
  Gamemaster
  wants to check the validity of each card

  Scenario: 3. Number of images on card
    Given A random Playing Card
    Then it should contain 2 images

  Scenario: 4. Solution is the object that is shown in the right colour
    Given a playing card with objects displayed:
      | color | type   |
      | White | Ghost  |
      | White | Chair  |
    When the player chooses playing object:
      | color | type   |
      | White | Ghost  |
    Then that is the correct solution
