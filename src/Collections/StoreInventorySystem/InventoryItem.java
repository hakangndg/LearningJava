package Collections.StoreInventorySystem;
import java.util.Scanner;
public class InventoryItem {

  private Product product;
  private int qtyTotal;
  private int qtyReserved;
  private int qtyReorder;
  private int qtyLow;
  private double salesPrice;

  public InventoryItem(Product product, int qtyTotal, int qtyReserved, int qtyReorder, int qtyLow, int salesPrice) {
    this.product = product; 
    this.qtyTotal = qtyTotal;
    this.qtyReserved = qtyReserved;
    this.qtyReorder = qtyReorder;
    this.qtyLow = qtyLow;
    this.salesPrice = salesPrice;
  }

  public void reserveItem(int amount) {
    int availableAmount = qtyTotal - qtyReserved;
    if (amount > availableAmount) {
      System.out.println("Sorry, there are no enough " + this.product.getName() + " in the inventory");
      return;
    }
    this.qtyReserved += amount; 
  }

  public void releaseItem(int amount) {
    if (amount <= qtyReserved) {
        qtyReserved -= amount;
        System.out.println(amount + " " + this.product.getName() + " successfully released back to shelf!");
    }
  }

  public void sellItem(InventoryItem item, int amount) {
    item.qtyReserved -= amount;
    item.qtyTotal -= amount;
    System.out.println(amount + " " + item.product.getName() +" was sold !");

    if (qtyTotal <= qtyLow) {
      placeInventoryOrder();
    }
  }

  public void placeInventoryOrder() {
    if (this.qtyTotal <= qtyLow) {
      this.qtyTotal += qtyReorder;
    }
    System.out.println(qtyReorder + " amount of " + this.product.getName() + " was ordered !");
  }

  public Product getProduct() { return product; }
  public int getQtyTotal() { return qtyTotal; }
  public int getQtyReserved() { return qtyReserved; }
  public double getSalesPrice() {return salesPrice;}
  
}
