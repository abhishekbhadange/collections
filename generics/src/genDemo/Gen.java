package genDemo;

public class Gen<T> {

	T obj;
	
	public Gen(T ob) {
		obj = ob;
	}
	public T getObject() {
		return obj;
	}
	public void showType() {
		System.out.println("Type of T: " + obj.getClass().getName());
	}
}
