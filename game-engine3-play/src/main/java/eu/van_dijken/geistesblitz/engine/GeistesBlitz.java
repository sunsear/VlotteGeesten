package eu.van_dijken.geistesblitz.engine;

import eu.van_dijken.geistesblitz.material.Color;
import eu.van_dijken.geistesblitz.material.Image;
import eu.van_dijken.geistesblitz.material.Item;
import eu.van_dijken.geistesblitz.material.PlayingCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeistesBlitz {

    private final List<PlayingCard> playingCards;
    private final List<Player> players = new ArrayList<Player>();

    public GeistesBlitz() {
        playingCards = generateCards();
    }

    private List<PlayingCard> generateCards() {
        List<Image> allImages = getAllPossibleImages();
        List<PlayingCard> cards = generateAllPotentialPlayingCards(allImages);
        cards = pruneAllNonValidCards(cards);
        shuffleAllCards(cards);
        return limitTo60Cards(cards);
    }

    private void shuffleAllCards(List<PlayingCard> cards) {
        Collections.shuffle(cards);
    }

    private List<PlayingCard> limitTo60Cards(List<PlayingCard> validCards) {
        List<PlayingCard> limitedTo60 = new ArrayList<PlayingCard>();
        for (int i = 0; i < 60; i++) {
            limitedTo60.add(validCards.get(i));
        }
        return limitedTo60;
    }

    private ArrayList<PlayingCard> pruneAllNonValidCards(List<PlayingCard> cards) {
        ArrayList<PlayingCard> validCards = new ArrayList<PlayingCard>();
        for (PlayingCard card : cards) {
            if (isValid(card) && !validCards.contains(card)) {
                validCards.add(card);
            }
        }
        return validCards;
    }

    private ArrayList<PlayingCard> generateAllPotentialPlayingCards(List<Image> allImages) {
        ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();
        for (Image image : allImages) {
            for (Image image2 : allImages) {
                PlayingCard playingCard = new PlayingCard();
                playingCard.addImages(image, image2);
                cards.add(playingCard);
            }
        }
        return cards;
    }

    private List<Image> getAllPossibleImages() {
        List<Image> allImages = new ArrayList<Image>();
        for (Item item : Item.values()) {
            for (Color color : Color.values()) {
                allImages.add(new Image(item, color));
            }
        }
        return allImages;
    }

    public boolean isValid(PlayingCard cardToCheck) {
        if (!cardToCheck.colorAndTypeOnlyPresentOnce()) {
            return false;
        }
        if (exactlyOneItemOnCard(cardToCheck)) {
            return true;
        }
        return !moreThanOneItemMatchesBecauseNotShownOnCard(cardToCheck);
    }

    private boolean exactlyOneItemOnCard(PlayingCard cardToCheck) {
        boolean solutionFound = false;
        for (Item item : Item.values()) {
            boolean found = cardToCheck.imageIsExactly(item);
            if (found) {
                if (solutionFound) {
                    return false;
                }
                solutionFound = true;
            }
        }
        return solutionFound;
    }

    private boolean moreThanOneItemMatchesBecauseNotShownOnCard(PlayingCard cardToCheck) {
        boolean solutionFound = false;
        for (Item item : Item.values()) {
            boolean found = !cardToCheck.itemTypeOrColorOnAnImage(item);
            if (found) {
                if (solutionFound) {
                    return true;
                }
                solutionFound = true;
            }
        }
        return false;
    }

    public List<PlayingCard> availableCards() {
        return playingCards;
    }

    public boolean isPresentOnce(PlayingCard cardToCheck) {
        int foundTimes = 0;
        for (PlayingCard card : playingCards) {
            if (card.equals(cardToCheck)) {
                foundTimes++;
            }
        }
        return foundTimes == 1;
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public Player getPlayer(int playerIndex) {
        return players.get(playerIndex);
    }

    public void start() throws NotEnoughPlayersException, TooManyPlayersException {
        if (players.size() < 2) {
            throw new NotEnoughPlayersException();
        }
        if (players.size() > 8) {
            throw new TooManyPlayersException();
        }
    }

    public void round() {

    }

    public void provideAnswer(int playerIndex, Item item) {

    }

    public void finishRound() {
    }

    public void finish() {
    }

    public Player getWinner() {
        return null;
    }
}
