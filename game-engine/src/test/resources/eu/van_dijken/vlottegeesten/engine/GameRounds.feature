Feature: Game Rounds
  Each round starts by the game providing a random card from the deck. Players can attempt to provide a solution
  for the card shown. The first player to select the correct solution is given the card that was shown. That player
  adds the card shown to his pile. A player providing an incorrect solution will lose a card from his pile. A
  player may only provide a single solution.

  Background: Setting up a 2 player game
    Given a new game of Vlotte Geesten
    And 2 players in the game

  Scenario: Player chooses the correct solution
    Given a new round of play showing a card with a "Gray Mouse"
    When a player chooses the "Gray Mouse"
    Then that player wins the shown card
    And the shown card is no longer in the deck

