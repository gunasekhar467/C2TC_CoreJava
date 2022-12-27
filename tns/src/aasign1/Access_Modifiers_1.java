package aasign1;

 class Example_class {
	static int default_data=10;
	public static int public_data=20;
	protected static int protected_data=30;
	private int private_data=40;
}
public class Access_Modifiers_1 extends Example_class {
public static void main(String args[]) {
	System.out.println(default_data);
	System.out.println(public_data);
	System.out.println(protected_data);
	//System.out.println(private_data);
	
}
}
