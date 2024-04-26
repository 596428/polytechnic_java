import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MoneyBox {
	private Map<String, Object> MoneyBox;
	
	MoneyBox(String name, int value){
		this.MoneyBox = new HashMap<String, Object>();
		this.MoneyBox.put("name", name);
		this.MoneyBox.put("value", value);
	}
	
	public Object getProperty(String key) {
		if(key.equals("name")) {
			return (String) this.MoneyBox.get("name");
		}else if(key.equals("value")){
			Object value = this.MoneyBox.get("value");
	        return (int) value;
		}else {
			return this.MoneyBox.get(key);
		}
	}
	
	@Override
	public boolean equals(Object object) {
		//자기 자신이라면 true
	    if (this == object) return true;
	    //null이거나, 클래스가 다르다면 비교하지않고 바로 false
	    if (object == null || getClass() != object.getClass()) return false;
	    
	    //object 객체를 MoneyBox 타입으로 캐스팅하여 변수화
	    MoneyBox other = (MoneyBox)object; 
	    return getProperty("name").equals(other.getProperty("name"));
	}

	@Override
	public int hashCode() {
	    return Objects.hash(getProperty("name"));
	}
	
	@Override
	public String toString() {
		return this.getProperty("name") + "(" + this.getProperty("value") + ")";
	}
	

	


}
