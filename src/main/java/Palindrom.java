import java.util.Scanner;

public class Palindrom {
static void pal()
{
	try{
		Scanner sc= new Scanner(System.in);
	
			long num=sc.nextLong();
			long digit;
			long rev=0;
			while(num!=0)
			{
				digit=num%10;
				rev=rev*10+digit;
				num=num/10;
				
			}
			System.out.println(rev);
	}
	catch(Exception e)
	{
		System.out.println("Invalid Number Entered");
		
	}
		
}
	public static void main(String[] args) {
		
 pal();
 int j=0;
 String str= "bjh sdf jsbfjbfjwe jfwej";
 for(int i=0;i<=str.length()-1;i++)
 {
	 if((str.charAt(i)== ' ') && (str.charAt(i+1)!=' '))
	 {
		 j++;
		 
	 }
 }
 System.out.println(j+1);
 
	}

}
