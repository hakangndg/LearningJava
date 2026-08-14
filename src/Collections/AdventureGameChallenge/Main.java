package Collections.AdventureGameChallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  

   public static void main(String[] args) {

    Map<String,Location> gameMap = new HashMap<>();

    Map<String,String> forestMap = new HashMap<>();
    forestMap.put("E", "Lake");
    forestMap.put("S", "Road");

    Map<String,String> roadMap = new HashMap<>();
    roadMap.put("N", "Forest");
    roadMap.put("S", "Valley");
    roadMap.put("W", "Hill");
    roadMap.put("E", "Well House");

    Map<String,String> hillMap = new HashMap<>();
    hillMap.put("E", "Road");

    Map<String,String> valleyMap = new HashMap<>();
    valleyMap.put("N", "Road");
    valleyMap.put("E", "Stream");

    Map<String,String> streamMap = new HashMap<>();
    streamMap.put("W", "Valley");
    streamMap.put("N", "Well House");

    Map<String,String> wellHouseMap = new HashMap<>();
    wellHouseMap.put("W", "Road");
    wellHouseMap.put("N", "Lake");
    wellHouseMap.put("S", "Stream");

    Map<String,String> lakeMap = new HashMap<>();
    lakeMap.put("W", "Forest");
    lakeMap.put("S", "Well House");

    Location road = new Location("Welcome to the road...Where your journey begins.",roadMap);
    Location lake = new Location("This is the Lake, enjoy the calm water...", lakeMap);
    Location forest = new Location("This is the forest, listen to birds chirping....", forestMap);
    Location wellHouse = new Location("Welcome to the Well House, have a sit and take a break", wellHouseMap);
    Location stream = new Location("This is the Stream, enjoy a cup of coffe", streamMap);
    Location hill = new Location("This is the Hill, its beautiful isnt it ? :)", hillMap);
    Location valley = new Location("This is the valley, dont forget to take a photo", valleyMap);

    gameMap.put("Road", road);
    gameMap.put("Lake", lake);
    gameMap.put("Forest", forest);
    gameMap.put("Well House", wellHouse);
    gameMap.put("Stream", stream);
    gameMap.put("Hill", hill);
    gameMap.put("Valley", valley);

    System.out.println("------------------  Welcome to the our litle game :D -------------------");
    Location location = gameMap.get("Road");
    Scanner sc = new Scanner(System.in);
    boolean gameEnd = false;

    while(!gameEnd) {

      System.out.println(location.getDescription());
      System.out.println("Where do you want to go next?");

      if (isTherePath(location, "N")) {
        System.out.println("N : " + location.getDirectedLocation("N"));
      }
      if (isTherePath(location, "S")) {
        System.out.println("S : " + location.getDirectedLocation("S"));
      }
      if (isTherePath(location, "W")) {
        System.out.println("W : " + location.getDirectedLocation("W"));
      }
      if (isTherePath(location, "E")) {
        System.out.println("E : " + location.getDirectedLocation("E"));
      }
      

      String direction = sc.nextLine().toUpperCase();
      
      if (location.getDirectedLocation(direction) == null) {
        System.out.println("Sorry, there is no way to that location");
        continue;
      }

      location = gameMap.get(location.getDirectedLocation(direction));
      System.out.println("Current location: " +  location.getDescription());
      System.out.println("Do you want to quit? y/n ? ");
      String answer = sc.nextLine().toLowerCase();
      if (answer.equals("y")) {
        gameEnd = true;
        sc.close();
      }
    

    }
    

   
  }

  public static boolean isTherePath(Location location, String direction) {
    if (location.getDirectedLocation(direction) == null) {
      return false;
    }
    return true;
  }

  
}
