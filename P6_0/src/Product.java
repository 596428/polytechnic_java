import java.util.HashMap;
import java.util.Map;

public class Product {
	private Map<String, String> product;
	
	Product(){
		product = new HashMap<String, String>();
		product.put("1", "양말");
		product.put("2", "모자");
		product.put("3", "신발");
	}
	
	public String checkName(String name) {
		for(String key : product.keySet()) {
			//return name.equals(key) ? product.get(key) : "";
			if(name.equals(key)) {
				return product.get(key);
			}
		}
		return "";
	}
	
	public void printProductList() {
		for (String key : product.keySet()) {
            System.out.println(key + ": " + product.get(key));
        }
	}
	

}
