package eu.van_dijken.geistesblitz.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeistesBlitz {

    private final List<Item> items;
    private final List<PlayingCard> playingCards;
    private final List<Player> players = new ArrayList<Player>();
    private GameRound round;
    private Player winner;

    public GeistesBlitz() {
        items = new ArrayList<Item>();
        items.add(new Item(ItemColor.White, ItemType.Ghost));
        items.add(new Item(ItemColor.Red, ItemType.Chair));
        items.add(new Item(ItemColor.Blue, ItemType.Book));
        items.add(new Item(ItemColor.Green, ItemType.Bottle));
        items.add(new Item(ItemColor.Gray, ItemType.Mouse));
        playingCards = generateCards();
    }

    private List<PlayingCard> generateCards() {
        List<CardImage> allImages = getAllPossibleCardImages();
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

    private ArrayList<PlayingCard> generateAllPotentialPlayingCards(List<CardImage> allImages) {
        ArrayList<PlayingCard> cards = new ArrayList<PlayingCard>();
        for (CardImage image : allImages) {
            for (CardImage image2 : allImages) {
                PlayingCard playingCard = new PlayingCard();
                playingCard.addImages(image, image2);
                cards.add(playingCard);
            }
        }
        return cards;
    }

    private List<CardImage> getAllPossibleCardImages() {
        List<CardImage> allImages = new ArrayList<CardImage>();
        for (ItemType type : ItemType.values()) {
            for (ItemColor color : ItemColor.values()) {
                allImages.add(new CardImage(color, type));
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
        for (Item item : items) {
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
        for (Item item : items) {
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

    public boolean contains(Item item) {
        return items.contains(item);
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
        round = new GameRound(playingCards.remove(0));
    }

    public PlayingCard shownCard() {return round.getShownCard();}

    public void provideSolution(int playerIndex, Item item) {
        round.provideSolution(players.get(playerIndex), item);
    }

    public void finishRound() {
        Player winner = round.getWinner();
        if (winner != null) {
            List<Player> losers = round.getLosers();
            winner.addToWonCards(round.getShownCard());
            for (Player loser : losers) {
                loser.giveCardTo(winner);
            }
        }
    }

    public void finish() {
        winner = findWinner();
    }

    private Player findWinner() {
        int highestNumberOfCards = findHighestNumberOfWonCards();
        List<Player> winners = findPlayersWithHighestNumber(highestNumberOfCards);
        if (winners.size()==1){
            return winners.get(0);
        }
        return null;
    }

    private List<Player> findPlayersWithHighestNumber(int highestNumberOfCards) {
        List<Player> winners = new ArrayList<Player>();
        for (Player player : players) {
            if (player.getWonCards().size() == highestNumberOfCards) {
                    winners.add(player);
            }
        }
        return winners;
    }

    private int findHighestNumberOfWonCards() {
        int highestNumberOfCards = 0;
        for (Player player : players) {
            if (player.getWonCards().size() > highestNumberOfCards) {
                highestNumberOfCards = player.getWonCards().size();
            }
        }
        return highestNumberOfCards;
    }

    public Player getWinner() {
        return winner;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Player> getPlayers() {
        return players;
    }


}