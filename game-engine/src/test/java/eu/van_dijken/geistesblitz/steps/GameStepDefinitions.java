package eu.van_dijken.geistesblitz.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import eu.van_dijken.geistesblitz.engine.GeistesBlitz;
import eu.van_dijken.geistesblitz.engine.NotEnoughPlayersException;
import eu.van_dijken.geistesblitz.engine.Player;
import eu.van_dijken.geistesblitz.engine.TooManyPlayersException;
import eu.van_dijken.geistesblitz.material.Color;
import eu.van_dijken.geistesblitz.material.Image;
import eu.van_dijken.geistesblitz.material.Item;
import eu.van_dijken.geistesblitz.material.PlayingCard;

public class GameStepDefinitions {
	private final GeistesBlitzTestContext context = GeistesBlitzTestContext
			.getInstance();
	GeistesBlitz anotherGame;
	private PlayingCard shownCard;

	@Given("^a new game of GeistesBlitz$")
	public void a_new_game_of_GeistesBlitz() {
		context.setGame(new GeistesBlitz());
	}

	@Then("^there should be (\\d+) items present$")
	public void there_should_be_items_present(int number) {
		assertThat(Item.values().length, is(number));
	}

	@Then("^the following items should be present:$")
	public void the_following_game_items_should_be_present(
			List<ItemDescription> entries) {
		for (ItemDescription itemDescription : entries) {
			assertThat(Item.valueOf(itemDescription.getType()).color(),
					is(itemDescription.getColor()));
		}
	}

	@Then("^the deck should contain (\\d+) cards$")
	public void the_deck_should_contain_cards(int numCards) throws Throwable {
		assertEquals(numCards, context.getGame().availableCards().size());
	}

	@Then("^that card is not valid according to game rules$")
	public void that_card_is_not_valid_according_to_game_rules()
			throws Throwable {
		assertFalse(context.getGame().isValid(context.getCard()));
	}

	@Then("^that card is valid according to game rules$")
	public void that_card_is_valid_according_to_game_rules() throws Throwable {
		assertTrue(context.getGame().isValid(context.getCard()));
	}

	@Then("^the deck should contain (\\d+) valid cards$")
	public void the_deck_should_contain_valid_cards(int arg1) throws Throwable {
		for (PlayingCard card : context.getGame().availableCards()) {
			assertTrue("Playing Card " + card + " is not valid.", context
					.getGame().isValid(card));
		}
	}

	@Then("^the deck should contain (\\d+) unique cards$")
	public void the_deck_should_contain_unique_cards(int arg1) throws Throwable {
		for (PlayingCard card : context.getGame().availableCards()) {
			assertTrue(card + " is present in the deck more than once.",
					context.getGame().isPresentOnce(card));
		}
	}

	@Given("^another new game$")
	public void another_new_game() throws Throwable {
		anotherGame = new GeistesBlitz();
	}

	@Then("^the decks of the two games should contain cards in a different order$")
	public void the_decks_of_the_two_games_should_contain_cards_in_a_different_order()
			throws Throwable {
		assertNotEquals(context.getGame().availableCards(),
				anotherGame.availableCards());
	}

	@Then("^the minimum number of players is (\\d+)$")
	public void the_minimum_number_of_players_is(int minNumberOfPlayers)
			throws Throwable {
		for (int i = 1; i < minNumberOfPlayers; i++) {
			context.getGame().addPlayer("Name " + i);
			try {
				context.getGame().start();
			} catch (NotEnoughPlayersException nepe) {
				continue;
			}
			fail("Number of players should be too few as it is less than minNumberOfPlayers "
					+ minNumberOfPlayers);
		}
		context.getGame().addPlayer("Name " + minNumberOfPlayers);
		try {
			context.getGame().start();
		} catch (NotEnoughPlayersException nepe) {
			fail("Number of players should not be too few as it is equal to minNumberOfPlayers: "
					+ minNumberOfPlayers);
		}
	}

	@Then("^the maximum number of players is (\\d+).$")
	public void the_maximum_number_of_players_is_(int maxNumberOfPlayers)
			throws Throwable {
		for (int i = 1; i <= maxNumberOfPlayers; i++) {
			context.getGame().addPlayer("Name " + i);
			try {
				context.getGame().start();
			} catch (TooManyPlayersException nepe) {
				fail("Number of players should not be too many as it is less than or equal to maxNumberOfPlayers "
						+ maxNumberOfPlayers);
			} catch (NotEnoughPlayersException nepe) {
				// Not necessary
			}
		}
		context.getGame().addPlayer("Name " + maxNumberOfPlayers);
		try {
			context.getGame().start();
		} catch (TooManyPlayersException nepe) {
			return;
		}
		fail("Number of players should not be too many as it is 1 more than maxNumberOfPlayers: "
				+ maxNumberOfPlayers);
	}

	private void putCardFirstInDeck() {
		context.getGame().availableCards().remove(shownCard);
		context.getGame().availableCards().add(0, shownCard);
	}

	@Given("^a new round of play showing a card with a \"([^\" ]*) ([^\"]*)\" and a \"([^\" ]*) ([^\"]*)\"$")
	public void a_new_round_of_play_showing_a_card_with_a_and_a(Color colour,
			Item type, Color colour2, Item type2) {
		shownCard = new PlayingCard();
		shownCard.addImages(new Image(type, colour));
		shownCard.addImages(new Image(type2, colour2));
		putCardFirstInDeck();
		context.getGame().round();
	}

	@Given("^a new round of play showing a card$")
	public void a_new_round_of_play_showing_a_card() {
		shownCard = new PlayingCard();
		shownCard.addImages(new Image(Item.Mouse, Color.Gray));
		shownCard.addImages(new Image(Item.Book, Color.Green));
		putCardFirstInDeck();
		context.getGame().round();
	}

	@When("^player (\\d+) chooses the \"([^\" ]*) ([^\"]*)\"$")
	public void player_chooses_the(int playerNumber, Color colour, Item type)
			throws Throwable {
		context.getGame().provideSolution(playerNumber - 1,
				Item.valueOf(type.name()));
	}

	@When("^player (\\d+) provides the desired item$")
	public void player_provides_the_desired_item(int playerNumber) {
		context.getGame().provideSolution(playerNumber - 1, Item.Mouse);
	}

	@When("^player (\\d+) provides an incorrect item$")
	public void player_provides_an_incorrect_item(int playerNumber) {
		context.getGame().provideSolution(playerNumber - 1, Item.Book);
	}

	@Then("^player (\\d+) has won the shown card$")
	public void player_wins_the_shown_card(int playerNumber) throws Throwable {
		assertTrue("Expected player " + playerNumber + " to now have "
				+ shownCard, context.getGame().getPlayer(playerNumber - 1)
				.getWonCards().contains(shownCard));
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
	public void player_has_won_card(int playerNumber, int numberOfCardsWon)
			throws Throwable {
		Player player = context.getGame().getPlayer(playerNumber - 1);
		for (int i = 0; i < numberOfCardsWon; i++) {
			player.addToWonCards(context.getGame().availableCards().remove(0));
		}
	}

	@Then("^player (\\d+) now has a total of won cards of (\\d+)$")
	public void player_now_has_a_total_of_won_cards_of(int playerNumber,
			int numberOfCardsWon) {
		Player player = context.getGame().getPlayer(playerNumber - 1);
		assertThat(player.getWonCards().size(), is(numberOfCardsWon));
	}

	@And("^player (\\d+) has to give a card away, reducing his total of won cards to (\\d+)$")
	public void player_has_to_give_a_card_away_reducing_his_total_of_won_cards_to(
			int playerNumber, int totalCards) throws Throwable {
		assertPlayerHasWonNumberOfCards(playerNumber, totalCards);
	}

	@And("^player (\\d+) has received an extra card, making his total of won cards (\\d+)$")
	public void player_has_received_an_extra_card_making_his_total_of_won_cards(
			int playerNumber, int totalCards) throws Throwable {
		assertPlayerHasWonNumberOfCards(playerNumber, totalCards);
	}

	private void assertPlayerHasWonNumberOfCards(int playerNumber,
			int totalCards) {
		assertEquals(
				"Expected a different total number of won cards for player "
						+ playerNumber, totalCards, context.getGame()
						.getPlayer(playerNumber - 1).getWonCards().size());
	}

	@Then("^the round finishes$")
	public void the_round_finishes() throws Throwable {
		context.getGame().finishRound();
	}

	@When("^the game finishes$")
	public void the_game_finishes() throws Throwable {
		context.getGame().finish();
	}

	@Then("^player (\\d+) has won the game$")
	public void player_has_won_the_game(int playerNumber) throws Throwable {
		assertEquals(context.getGame().getPlayer(playerNumber - 1), context
				.getGame().getWinner());
	}

	@Then("^there is no winner$")
	public void there_is_no_winner() throws Throwable {
		assertNull(context.getGame().getWinner());
	}

	public class ItemDescription {
		Color color;
		String type;

		public ItemDescription(String type, Color color) {
			this.type = type;
			this.color = color;
		}

		public Color getColor() {
			return color;
		}

		public String getType() {
			return type;
		}
	}

}
