 import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Purchase {
	private Map<String, String> properties;
	Product product = new Product();
	
	Purchase(String name, String price, String shippingAddress){
		this.properties = new HashMap<String, String>();
		
		this.properties.put("name", product.checkName(name));
		this.properties.put("price", price);
		this.properties.put("shippingAddress", shippingAddress);
	}
	
	
	public void addProperty(String key, String value) {
		this.properties.put(key, value);
    }
	
	public String getProperty(String key) {
		 return this.properties.get(key);
	 }

}
