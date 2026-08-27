package Collections.StoreInventorySystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

  enum CartType {PHYSICAL, VIRTUAL}

  private final String id;
  private Map<InventoryItem,Integer> products;
  private String date;
  private CartType type;

  public Cart (String id, String date, CartType type) {
    this.id = id;
    this.products = new HashMap<>();
    this.date = date;
    this.type = type;
  }

  public Map<InventoryItem,Integer> getProducts() {return products;}
  public String getDate() {return date;}
  public CartType getType() {return type;}

  public void addItem(int amount, InventoryItem item) {
    item.reserveItem(amount);
    int startAmount = products.getOrDefault(item.getProduct().getName(),0);
    products.put(item, startAmount + amount);
  }

  public void removeItem(int amount, InventoryItem item) {
        int currentAmount = products.getOrDefault(item, 0);

        if (currentAmount >= amount) {
            item.releaseItem(amount);
            int newAmount = currentAmount - amount;

            if (newAmount == 0) {
                products.remove(item);
            } else {
                products.put(item, newAmount);
            }
        } else {
            System.out.println("There are not this much elements in the hand!");
        }
    }

 public void printSaleSlip() {
  System.out.println("--------------The Sale Slip-----------");
  double totalPrice = 0;
  for (var item : products.entrySet()) {
    var name = item.getKey();
    var price = item.getValue();
    String productName = name.getProduct().getName();
    System.out.println(productName + ": " + " TOTAL");
  } 
  System.out.println("Total Price: " + totalPrice);
 }

  
  
}
