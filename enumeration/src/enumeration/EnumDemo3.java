package enumeration;

enum App {
	
	Cortland(10), RedDel(12), GoldenDel(15), Winesap(8), Jonathan(13);
	
	private int price;
	
	App(int p) {
		price = p;
	}
	
	int getPrice() {
		return price;
	}
}

public class EnumDemo3 {
	
	public static void main(String[] args) {
		
		App ap;
		
		System.out.println("Winesap costs " + App.Winesap.getPrice() + " cents.\n");
		
		System.out.println("All Apple prices:");
		for(App a : App.values())
			System.out.println(a + " costs " + a.getPrice() + " cents.");
	}
}
