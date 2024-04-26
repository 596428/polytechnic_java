import java.util.HashMap;
import java.util.Map;

public class BuyList {
	private Map<String, Object> buyList;
	//Product product = new Product(1,1,1,1);
		
	//상품명, 구매자이름, 연락처, 주소
	BuyList(String productName, String name, String phoneNum, String address){
		this.buyList = new HashMap<String, Object>();
		this.buyList.put("productName", productName);
		this.buyList.put("name", name);
		this.buyList.put("phoneNum", phoneNum);
		this.buyList.put("address", address);
	}
	
	public void addProperty(String key, String value) {
		this.buyList.put(key, value);
	}
		

	public Object getProperty(String key) {
		return this.buyList.get(key);
	}
		
	public void setPhoneNum(String phoneNum) {
		buyList.put("phoneNum", phoneNum);
	}
		
	public void setAddress(String address) {
		buyList.put("address", address);
	}
	
	

}
