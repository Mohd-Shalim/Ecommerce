
public class TypeCasting {

	public static void main(String[] args){  
		byte a=10;  
		byte b=10;  
		//byte c=a+b;//Compile Time Error: because a+b=20 will be integer  
		//we can not assign integer to byte directly first type cast because 10+10 =20 which integer
		byte c=(byte)(a+b);  
		System.out.println(c);  
		}

}
