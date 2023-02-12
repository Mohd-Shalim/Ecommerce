import java.util.Scanner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP
{
    @DataProvider (name = "data-provider")
     public Object[][] dpMethod(){
	 return new Object[][] {{"First-Value","val1"}, {"Second-Value", "val2"}};
     }
	
    @Test (dataProvider = "data-provider", priority=3)
    public void myTest (String x,String y) {
        System.out.println("First Passed Parameter Is : " + x+",   Second Passed Parameter Is : "+y);
    }
    @Test(priority=4)
    public void keyScanner()
    {
    	try (Scanner sc = new Scanner(System.in)) {
			String s=sc.next();
			System.out.println(s);
		}
    }
}