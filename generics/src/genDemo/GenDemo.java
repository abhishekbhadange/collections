package genDemo;

public class GenDemo {

	public static void main(String[] args) {
		
		Gen<Integer> iObj = new Gen<Integer>(100);
		
		iObj.showType();
		
		int value = iObj.getObject();
		System.out.println("Value: " + value);
		
		System.out.println("");
		
		Gen<String> strObj = new Gen<String>("Generics test");
		
		strObj.showType();
		
		String str = strObj.getObject();
		System.out.println("Value: " + str);
	}
}
