package Collections.Maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFunctions2 {

  public static void main(String[] args) {
    
    Map<String,String> map = new HashMap<>();

    /*map.put("admin", "192.168.1.1 - ACTIVE");
    printMap(map);
    map.putIfAbsent("admin", "10.0.0.1 - SUSPICIOUS");
    printMap(map);
    map.putIfAbsent("analyst", "192.168.1.20 - ACTIVE");
    printMap(map);
    map.computeIfAbsent("guest", v ->"192.168.1.50 - GUEST_ROLE");
    printMap(map);
    map.computeIfPresent("admin", (k,v) -> v = "192.168.1.1 - VIP_SESSION");
    printMap(map);
    map.compute("operator", (k,v) -> v == null ? "192.168.1.30 - INITIAL" : v + " UPDATED");
    printMap(map);
    map.replace("analyst","192.168.1.20 - SENIOR_ANALYST");
    printMap(map);
    map.replace("analyst", "192.168.1.20 - SENIOR_ANALYST", "192.168.1.20 - LEAD");
    printMap(map);
    map.remove("guest", "192.168.1.50 - GUEST_ROLE");
    printMap(map);
    map.remove("operator");
    printMap(map);
    map.clear();
    printMap(map);*/


    Map<String, Integer> trustPoints = new HashMap<>();
    trustPoints.put("hakan", 95);
    trustPoints.put("alan", 40);
    trustPoints.put("henry", 85);
    trustPoints.put("nelson", 30);
    trustPoints.put("matt", 70);
    printMap(trustPoints);
    List<String> confirmedUsers = List.of("hakan", "alan", "henry");
    trustPoints.keySet().retainAll(confirmedUsers);
    printMap(trustPoints);

    int sum = 0;
    int counter = 0;
    for (var score : trustPoints.values()) {
      sum += score;
      counter++;
    }
    double average = (double) sum / counter;
    System.out.println("The average trust score: " + average);

    for (var entry : trustPoints.entrySet()) {
      String name = entry.getKey();
      int point = entry.getValue();
      if (point >= 90) {
        System.out.println(name +" has high trust factor : " + point);
      }
      else{
        System.out.println(name + " has mid or low trust factor: " + point);
      }
    }
    
  }

  public static void printMap(Map<?,?> map) {
    map.forEach((k,v) -> System.out.println("key: " + k + " Value: " + v));
    System.out.println("------------------------------------");
  }
  
}
