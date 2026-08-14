package Collections.CustomCardGame;

import java.util.ArrayList;
import java.util.List;

import Collections.CustomCardGame.Card.Characters;

public class Deck {

  private List<Card> cards;

  public Deck() {
    this.cards = new ArrayList<>();
    for(Characters character : Characters.values()) {
      for (int i = 1 ; i <= 2 ; i++) {
        cards.add(new Card(character));
      }
    }
  }

  public void printDeck() {
    for (Card card : cards) {
      System.out.println(card.toString());
    }
  }

  public List<Card> getCards() {
    return cards;
  }
}
