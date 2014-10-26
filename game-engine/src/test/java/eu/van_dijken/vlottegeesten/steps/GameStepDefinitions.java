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
        context.getGame().availableCards().clear();
        shownCard = new PlayingCard();
        shownCard.addImages(new CardImage(colour, type));
        context.getGame().availableCards().add(shownCard);
        context.getGame().round();
    }

    @When("^a player chooses the \"([^\" ]*) ([^\"]*)\"$")
    public void a_player_chooses_the(TokenColor colour, TokenType type) throws Throwable {
        context.getGame().provideSolution(0, new GameToken(colour,type));
    }

    @Then("^that player wins the shown card$")
    public void that_player_wins_the_shown_card() throws Throwable {
        assertEquals(shownCard, context.getGame().getPlayer(0).getWonCards().iterator().next());
    }

    @And("^(\\d+) players in the game$")
    public void players_in_the_game(int numOfPlayers) throws Throwable {
        for(int i=1;i<=numOfPlayers;i++){
            context.getGame().addPlayer("Player "+i);
        }
    }

    @And("^the shown card is no longer in the deck$")
    public void the_shown_card_is_no_longer_in_the_deck() throws Throwable {
        assertFalse(context.getGame().availableCards().contains(shownCard));
    }
}
