import java.util.HashMap;
import java.util.Map;

public class Product {
	private Map<String, Object> product;
	
	//상품 : 상품명 가격 재고 할인율
	Product(String name, int price, int stock, double discountRate){
		this.product = new HashMap<String, Object>();
		this.product.put("name", name);
		this.product.put("price", price);
		this.product.put("stock", stock);
		this.product.put("discountRate", discountRate);
	}
	
	
	public void addProperty(String key, String value) {
		this.product.put(key, value);
    }
	
	public Object getProperty(String key) {
		 return this.product.get(key);
	}
	
	public int getStock() {
        Object value = this.product.get("stock");
        return (int) value;
    }
	
	public void setStock(int newStock) {
        product.put("stock", newStock);
    }
	
	public void decreaseStock(int amount) {
		Object value = this.product.get("stock");
		int newStock = (int) value - amount;
		product.put("stock", newStock);
	}
	

	public int getPrice() {
        Object value = this.product.get("price");
        return (int) value;
    }
	
	public double getDiscountRate() {
        Object value = this.product.get("discountRate");
        return (double) value;
    }

}
