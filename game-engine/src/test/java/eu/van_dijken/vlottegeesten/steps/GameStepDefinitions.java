package eu.van_dijken.vlottegeesten.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import eu.van_dijken.vlottegeesten.engine.*;

import java.util.List;

import static org.junit.Assert.*;

public class GameStepDefinitions {
    private final VlotteGeestenTestContext context = VlotteGeestenTestContext.getInstance();
    VlotteGeestenGame anotherGame;
    private PlayingCard shownCard;

    @Given("^a new game of Vlotte Geesten$")
    public void a_new_game_of_Vlotte_Geesten() {
        context.setGame(new VlotteGeestenGame());
    }

    @Then("^the following game tokens should be present:$")
    public void the_following_game_tokens_should_be_present(List<GameToken> entries) throws Throwable {
        for (GameToken gameToken : entries) {
            assertTrue(context.getGame().contains(gameToken));
        }
    }

    @Then("^the following game tokens should not be present:$")
    public void the_following_game_tokens_should_not_be_present(List<GameToken> entries) throws Throwable {
        for (GameToken gameToken : entries) {
            assertFalse(context.getGame().contains(gameToken));
        }
    }

    @Then("^the deck should contain (\\d+) cards$")
    public void the_deck_should_contain_cards(int numCards) throws Throwable {
        assertEquals(numCards, context.getGame().availableCards().size());
    }

    @Then("^that card is not valid according to game rules$")
    public void that_card_is_not_valid_according_to_game_rules() throws Throwable {
        assertFalse(context.getGame().isValid(context.getCard()));
    }

    @Then("^that card is valid according to game rules$")
    public void that_card_is_valid_according_to_game_rules() throws Throwable {
        assertTrue(context.getGame().isValid(context.getCard()));
    }

    @Then("^the deck should contain (\\d+) valid cards$")
    public void the_deck_should_contain_valid_cards(int arg1) throws Throwable {
        for (PlayingCard card : context.getGame().availableCards()) {
            assertTrue("Playing Card " + card + " is not valid.", context.getGame().isValid(card));
        }
    }

    @Then("^the deck should contain (\\d+) unique cards$")
    public void the_deck_should_contain_unique_cards(int arg1) throws Throwable {
        for (PlayingCard card : context.getGame().availableCards()) {
            assertTrue(card + " is present in the deck more than once.", context.getGame().isPresentOnce(card));
        }
    }

    @Given("^another new game$")
    public void another_new_game() throws Throwable {
        anotherGame = new VlotteGeestenGame();
    }

    @Then("^the decks of the two games should contain cards in a different order$")
    public void the_decks_of_the_two_games_should_contain_cards_in_a_different_order() throws Throwable {
        assertNotEquals(context.getGame().availableCards(), anotherGame.availableCards());
    }

    @Then("^the minimum number of players is (\\d+)$")
    public void the_minimum_number_of_players_is(int minNumberOfPlayers) throws Throwable {
        for (int i = 1; i < minNumberOfPlayers; i++) {
            context.getGame().addPlayer("Name " + i);
            try {
                context.getGame().start();
            } catch (NotEnoughPlayersException nepe) {
                continue;
            }
            fail("Number of players should be too few as it is less than minNumberOfPlayers " + minNumberOfPlayers);
        }
        context.getGame().addPlayer("Name " + minNumberOfPlayers);
        try {
            context.getGame().start();
        } catch (NotEnoughPlayersException nepe) {
            fail("Number of players should not be too few as it is equal to minNumberOfPlayers: " + minNumberOfPlayers);
        }
    }

    @Then("^the maximum number of players is (\\d+).$")
    public void the_maximum_number_of_players_is_(int maxNumberOfPlayers) throws Throwable {
        for (int i = 1; i <= maxNumberOfPlayers; i++) {
            context.getGame().addPlayer("Name " + i);
            try {
                context.getGame().start();
            } catch (TooManyPlayersException nepe) {
                fail("Number of players should not be too many as it is less than or equal to maxNumberOfPlayers " +
                        maxNumberOfPlayers);
            } catch (NotEnoughPlayersException nepe) {
                //Not necessary
            }
        }
        context.getGame().addPlayer("Name " + maxNumberOfPlayers);
        try {
            context.getGame().start();
        } catch (TooManyPlayersException nepe) {
            return;
        }
        fail("Number of players should not be too many as it is 1 more than maxNumberOfPlayers: " + maxNumberOfPlayers);
    }

    @Given("^a new round of play showing a card with a \"([^\" ]*) ([^\"]*)\"$")
    public void a_new_round_of_play_showing_a_card_with_a(TokenColor colour, TokenType type) {
        shownCard = new PlayingCard();
        shownCard.addImages(new CardImage(colour, type));
        putCardFirstInDeck();
        context.getGame().round();
    }

    private void putCardFirstInDeck() {
        context.getGame().availableCards().remove(shownCard);
        context.getGame().availableCards().add(0, shownCard);
    }

    @Given("^a new round of play showing a card with a \"([^\" ]*) ([^\"]*)\" and a \"([^\" ]*) ([^\"]*)\"$")
    public void a_new_round_of_play_showing_a_card_with_a_and_a(TokenColor colour, TokenType type, TokenColor colour2,
                                                                TokenType type2) {
        shownCard = new PlayingCard();
        shownCard.addImages(new CardImage(colour, type));
        shownCard.addImages(new CardImage(colour2, type2));
        putCardFirstInDeck();
        context.getGame().round();
    }

    @When("^player (\\d+) chooses the \"([^\" ]*) ([^\"]*)\"$")
    public void player_chooses_the(int playerNumber, TokenColor colour, TokenType type) throws Throwable {
        context.getGame().provideSolution(playerNumber - 1, new GameToken(colour, type));
    }

    @Then("^player (\\d+) has won the shown card$")
    public void player_wins_the_shown_card(int playerNumber) throws Throwable {
        assertTrue("Expected player " + playerNumber + " to now have " + shownCard,
                context.getGame().getPlayer(playerNumber - 1).getWonCards().contains(shownCard));
    }

    @And("^(\\d+) players in the game$")
    public void players_in_the_game(int numOfPlayers) throws Throwable {
        for (int i = 1; i <= numOfPlayers; i++) {
            context.getGame().addPlayer("Player " + i);
        }
    }

    @And("^the shown card is no longer in the deck$")
    public void the_shown_card_is_no_longer_in_the_deck() throws Throwable {
        assertFalse(context.getGame().availableCards().contains(shownCard));
    }

    @Then("^player (\\d+) has won (\\d+) cards$")
    public void player_has_won_card(int playerNumber, int numberOfCardsWon) throws Throwable {
        for (int i = 0; i < numberOfCardsWon; i++) {
            context.getGame().getPlayer(playerNumber - 1).addToWonCards(context.getGame().availableCards().remove(0));
        }
    }

    @And("^player (\\d+) has to give a card away, reducing his total of won cards to (\\d+)$")
    public void player_has_to_give_a_card_away_reducing_his_total_of_won_cards_to(int playerNumber, int totalCards)
            throws Throwable {
        assertPlayerHasWonNumberOfCards(playerNumber, totalCards);
    }

    @And("^player (\\d+) has received an extra card, making his total of won cards (\\d+)$")
    public void player_has_received_an_extra_card_making_his_total_of_won_cards(int playerNumber, int totalCards)
            throws Throwable {
        assertPlayerHasWonNumberOfCards(playerNumber, totalCards);
    }

    private void assertPlayerHasWonNumberOfCards(int playerNumber, int totalCards) {
        assertEquals("Expected a different total number of won cards for player " + playerNumber, totalCards,
                context.getGame().getPlayer(playerNumber - 1).getWonCards().size());
    }

    @When("^the round finishes$")
    public void the_round_finishes() throws Throwable {
        context.getGame().finishRound();
    }

    @When("^the game finishes$")
    public void the_game_finishes() throws Throwable {
        context.getGame().finish();
    }

    @Then("^player (\\d+) has won the game$")
    public void player_has_won_the_game(int playerNumber) throws Throwable {
        assertEquals(context.getGame().getPlayer(playerNumber - 1), context.getGame().getWinner());
    }

    @Then("^there is no winner$")
    public void there_is_no_winner() throws Throwable {
        assertNull(context.getGame().getWinner());
    }
}
