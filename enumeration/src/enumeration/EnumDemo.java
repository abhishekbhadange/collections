package enumeration;

enum Apple {
	Winesap, RedDel, GoldenDel, Cortland, Jonathan
}
public class EnumDemo {

	public static void main(String args[]) {
		Apple ap;
		
		ap = Apple.RedDel;
		
		System.out.println("Value of ap: " + ap);
		
		ap = Apple.GoldenDel;
		
		if(ap == Apple.GoldenDel)
			System.out.println("Value of ap: " + ap);
		
		switch(ap) {
		case Jonathan:
			System.out.println("Jonathen is red");
			break;
		case GoldenDel:
			System.out.println("GoldenDel is yellow");
			break;
		case RedDel:
			System.out.println("RedDel is red");
			break;
		case Winesap:
			System.out.println("Winesap is red");
			break;
		case Cortland:
			System.out.println("Cortland is red");
			break;
		}
	}
}
