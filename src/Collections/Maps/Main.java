package Collections.Maps;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public enum Strength { WEAK, MID, STRONG }

  public static void main(String[] args) {

    Map<String,Strength> map = new HashMap<>();
    map.put("Hakan", Strength.STRONG);
    map.put("Henry", Strength.MID);
    map.put("Roscoe", Strength.WEAK);
    printMap(map);

    map.putIfAbsent("Alan", Strength.STRONG);
    map.putIfAbsent("Roscoe", Strength.STRONG);
    map.put("Henry", Strength.STRONG);
    printMap(map);

    System.out.println(map.get("Alan"));;
    System.out.println(map.getOrDefault("Henry", null));
    System.out.println(map.getOrDefault("Finlay", null));

    Map<String,Integer> fruits = new HashMap<>();

    fruits.put("Apple", 20);
    fruits.put("Banana", 50);
    fruits.merge("Banana", 30, (old,current) -> old + current);
    fruits.merge("Strawberry", 30, (old,current) -> old + current);
    fruits.merge("Melon", 23, Integer::sum);
    printMap(fruits);

    fruits.compute("Apple", (k,v) -> v = v+50);
    fruits.compute("Watermelon", (k,v) -> v == null ? 30 : v+30);
    printMap(fruits);
  }

  public static void printMap(Map<?,?> map) {
    map.forEach((k,v) -> System.out.println(k + " " + v));
  }
  
}
