package Collections.CustomCardGame;

public class Card {

  public enum Characters {
    WOLF, WHALE, TIGER, EAGLE, PEREGRINE_FALCON
  }

  private Characters name;
  private int defence;
  private int damage;
  private int health;

  public Card(Characters name) {
    this.name = name;
    this.defence = switch(name){
      case WOLF -> 3;
      case WHALE -> 9;
      case TIGER -> 5;
      case EAGLE -> 6;
      case PEREGRINE_FALCON -> 4;
      default -> throw new IllegalArgumentException("Invalid character type");
    };
    this.damage = switch(name) {
      case WOLF -> 5;
      case WHALE -> 2;
      case TIGER -> 6;
      case EAGLE -> 4;
      case PEREGRINE_FALCON -> 9;
      default -> throw new IllegalArgumentException("Invalid character type");
    };
    this.health = switch(name){
      case WOLF -> 6;
      case WHALE -> 10;
      case TIGER -> 7;
      case EAGLE -> 4;
      case PEREGRINE_FALCON -> 5;
      default -> throw new IllegalArgumentException("Invalid character type");
    };
  }

  @Override
  public String toString() {
    return name +  "  DEF: " + defence + " "
    + "DMG: " + damage + " " + "HP: " + health;
  }

  public static void hitDamage(Card player, Card target) {
    int initial_health = target.health;
    target.health = target.health - (player.damage - (target.defence / 2));
    System.out.println(target.name + "'s heath " + initial_health + " -> " + target.health );
  }

  public int getHealth() {
    return health;
  }

  public Characters getName() {
    return name;
  }
}
