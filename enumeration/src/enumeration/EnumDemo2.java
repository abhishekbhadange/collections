package enumeration;

enum Orange {
	Cortland, Winesap, RedDel, GoldenDel, Jonathan;
}

public class EnumDemo2 {

	public static void main(String args[]) {
		
		Orange allOrange[] = Orange.values();
		for(Orange a : allOrange)
			System.out.println(a);
		
		Orange or = Orange.valueOf("Cortland");
		System.out.println("Value of or: " + or);
	}
}
