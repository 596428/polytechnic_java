import java.util.*;

public class Dice {
	 String name;
	 int value;
	 private Map<String, Integer> properties;

	 public Dice(String name) {
		 this.properties = new HashMap<String, Integer>();
		 this.name = name;
		 value = (int) (Math.random() * 20) + 1; // random 넣으면 길어져서 바꿈
		 properties.put("diceNumber", value);
		 properties.put("price", 10000);
		 
		 
		 //문자열 속성인 name과 숫자열 속성인 diceNumber는 하나의 해시맵으로 묶는게 불가능한가?
	 }
	 
	 public String getName() {
		 return name;
	 }
	 
	 public int getValue() {
		 return value;
	 }
	 
	 public void addProperty(String key, Integer value) {
	        properties.put(key, value);
	    }
	 
	 public Integer getProperty(String key) {
		 return properties.get(key);
	 }
	

}
