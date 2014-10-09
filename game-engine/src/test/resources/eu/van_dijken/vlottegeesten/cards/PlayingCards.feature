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
      | Gray | Mouse  |
      | Blue | Ghost  |
    When the player chooses playing object:
      | color | type   |
      | Gray | Mouse  |
    Then that is the correct solution
    Given a playing card with objects displayed:
      | color | type   |
      | Blue | Mouse  |
      | Red | Chair  |
    When the player chooses playing object:
      | color | type   |
      | Red | Chair  |
    Then that is the correct solution

