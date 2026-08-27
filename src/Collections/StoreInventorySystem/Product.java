package Collections.StoreInventorySystem;

import java.util.Objects;

public class Product {

  public enum Category {FOOD, DRINK, ELECTRONIC, CASUAL}

  private final int sku;
  private String name;
  private String manufacturer;
  private Category category;

  public Product(int sku, String name, String manufacturer, Category category) {
    this.sku = sku;
    this.name = name;
    this.manufacturer = manufacturer;
    this.category = category;
  }


  public int getSku() {return sku;}
  public String getName() {return name;}
  public String getManufacturer() {return manufacturer;}
  public Category getCategory() {return category;}

    
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return sku == product.sku;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sku);
  }

    
  @Override
  public String toString() {
    return name + " (" + manufacturer + ") [#" + sku + "]";
  }
  
}
