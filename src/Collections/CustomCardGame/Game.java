package Collections.CustomCardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Game {

  Scanner scanner = new Scanner(System.in);

  private List<Card> player1;
  private List<Card> player2;
  private Deck myDeck;

  public Game() {
    this.myDeck = new Deck();
    this.player1 = new ArrayList<>();
    this.player2 = new ArrayList<>();

    Collections.shuffle(myDeck.getCards());
    for (int i  = 0 ; i < 5 ; i++) {
      player1.add(myDeck.getCards().get(i));
    }
    for (int i = 5 ; i <= 9 ; i++) {
      player2.add(myDeck.getCards().get(i));
    }
  }

  public void getDistributedCards(List<Card> cardDeck) {
    for (Card card : cardDeck) {
      System.out.println(card);;
    }
  }

  
  public void hitDamagePlayer1() {
    System.out.println("Please enter a valid input to choose your card !");
    int source = scanner.nextInt();
    System.out.println(player1.get(source));
    System.out.println("Please enter valid input to choose the card you want to attack ! ");
    int target = scanner.nextInt();
    System.out.println(player2.get(target).getName() + " selected");
    Card.hitDamage(player1.get(source), player2.get(target));
    if(player2.get(target).getHealth() <= 0) {
      System.out.println(player2.get(target).getName() + " is dead");
      player2.remove(target);
    }
  }

  public void hitDamagePlayer2() {
    System.out.println("Please enter a valid input to choose your card !");
    int source = scanner.nextInt();
    System.out.println(player2.get(source));
    System.out.println("Please enter valid input to choose the card you want to attack ! ");
    int target = scanner.nextInt();
    System.out.println(player1.get(target).getName() + " selected");
    Card.hitDamage(player2.get(source), player1.get(target));
    if(player1.get(target).getHealth() <= 0) {
      System.out.println(player1.get(target).getName() + " is dead");
      player1.remove(target);
    }
  }


  public void printCards() {
    getDistributedCards(player1);
    for (int i = 0 ; i < 3 ; i ++) {
      System.out.println();
    }
    getDistributedCards(player2);
  }

  public  void play() {
    System.out.println("Cards: \n");
    System.out.println("For Player1: \n");
    getDistributedCards(player1);
    System.out.println();
    System.out.println("For Player2: \n");
    getDistributedCards(player2);

    while(!isGameOver(player1, player2)) {
      System.out.println("Player1's turn");
      hitDamagePlayer1();
      System.out.println("Player2's turn");
      hitDamagePlayer2();
      for (int i = 0 ; i < 10 ; i ++) {
        System.out.println();
      }
      printCards();
    }
  }

  public boolean isGameOver(List<Card> player1, List<Card> player2) {

    if(player1.isEmpty()){
      System.out.println("The player 2 wins");
      return true;
    }
    if(player2.isEmpty()){
      System.out.println("The player1 wins");
      return true;
    }
    return false;
    

  }
}
