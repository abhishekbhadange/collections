package enumeration;

enum Appl {
	Jonathan, GoldenDel, RedDel, Winesap, Cortland;
}

public class EnumDemo4 {

	public static void main(String[] args) {
		Appl ap, ap2, ap3;

		for(Appl a : Appl.values())
			System.out.println(a + " " + a.ordinal());
		
		System.out.println("");
		
		ap = Appl.RedDel;
		ap2 = Appl.GoldenDel;
		ap3 = Appl.RedDel;
		
		if(ap.compareTo(ap2) < 0)
			System.out.println(ap + " comes before " + ap2);
		
		if(ap.compareTo(ap2) > 0)
			System.out.println(ap2 + " comes before " + ap);
		
		if(ap.compareTo(ap3) == 0)
			System.out.println(ap + " equals " + ap3);
		
		System.out.println("");
		
		if(ap.equals(ap2))
			System.out.println("Error!");
		
		if(ap.equals(ap3))
			System.out.println(ap + " equals " + ap3);
		
		if(ap == ap3)
			System.out.println(ap + " == " + ap3);
	}
}
