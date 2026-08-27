package Collections.StoreInventorySystem;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Store {

  private Map<Product, InventoryItem> inventory;
  private List<Cart> carts;
  private Map<Product.Category, Set<InventoryItem>> aisleInventory;
  
  public Store() {
    this.inventory = new HashMap<>();
    this.carts = new ArrayList<>();
    this.aisleInventory = new TreeMap<>();
  }

  public void checkOutCart(Cart cart) {
    for (var entry : cart.getProducts().entrySet()) {
      InventoryItem item = entry.getKey();
      int qty = cart.getProducts().get(item);
      item.sellItem(item, qty);
    }
    cart.printSaleSlip();
    carts.remove(cart);
  }
}
