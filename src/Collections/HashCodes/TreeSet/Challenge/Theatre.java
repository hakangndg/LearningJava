package Collections.HashCodes.TreeSet.Challenge;

import java.util.TreeSet;

public class Theatre {

  private String name;
  private int seatsInEachRow;
  TreeSet<Seat> seats;

  public Theatre(String name, int seatsInEachRow) {
    this.name = name;
    this.seatsInEachRow = seatsInEachRow;
    this.seats = new TreeSet<>();
    for (char i = 'A' ; i <= 'Z' ; i++) {
      for (int j = 1 ; j <= seatsInEachRow ; j++) {
        seats.add(new Seat(i, j,false));
      }
    }
  }

  public void printSeatMap() {
    
   int counter = 0; 
   for (var seat :  seats) {
    System.out.print(seat +"        ");
    counter++;
    if(counter % seatsInEachRow == 0){
      System.out.println();
    }
   }
  }


  class Seat implements Comparable<Seat>{

    private char row;   //A005 for instance
    private int  seatNumber;
    private boolean isReserved;

    public Seat(char row, int seatNumber,boolean isReserved) {
      this.row = row;
      this.seatNumber = seatNumber;
      this.isReserved = isReserved;
    }

    public char getRow() {
      return row;
    }
    public int getSeatNumber() {
      return seatNumber;
    }

    @Override
    public String toString() {
      String reserved = isReserved ? "R" : "";
      String formattedSeatNum =  String.format("%03d", seatNumber);
      return row + formattedSeatNum + (isReserved ? "("+reserved+")" : "");
    }

    @Override
    public int compareTo(Seat otherSeat) {
   
      int compare = Character.compare(this.row, otherSeat.row);
      if (compare == 0) {
        return Integer.compare(this.seatNumber, otherSeat.seatNumber);
      }
      return compare;
    }

   public void reserveSeat(char row, int seatNum) {
    Seat searched = new Seat(row, seatNum, false);
    Seat target = seats.ceiling(searched);

    if (target != null && target.compareTo(searched) == 0) {
        
       
        if (target.isReserved) {
            System.out.println("This seat is already booked!");
        } else {
            target.isReserved = true;
            System.out.println(target + " is successfully booked");
        }

    } else {
        System.out.println("The seat " + row + seatNum + " was not found.");
    }
}


  }

   public void reserveSeat(char row, int seatNum) {
    Seat searched = new Seat(row, seatNum, false);
    Seat target = seats.ceiling(searched);

    if (target != null && target.compareTo(searched) == 0) {
        
       
        if (target.isReserved) {
            System.out.println("This seat is already booked!");
        } else {
            target.isReserved = true;
            System.out.println(target + " is successfully booked");
        }

    } else {
        System.out.println("The seat " + row + seatNum + " was not found.");
    }
  
  }
}