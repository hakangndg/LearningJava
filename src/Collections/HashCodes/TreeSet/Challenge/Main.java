package Collections.HashCodes.TreeSet.Challenge;

import Collections.HashCodes.TreeSet.Challenge.Theatre.Seat;

public class Main {

  public static void main(String[] args) {
    
    Theatre theatre = new Theatre("Paribu", 3);
    theatre.printSeatMap();
    theatre.reserveSeat('A',2);
    theatre.printSeatMap();
    
  }
  
}
