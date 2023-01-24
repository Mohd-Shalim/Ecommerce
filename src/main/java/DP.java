import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DP
{
    @DataProvider (name = "data-provider")
     public Object[][] dpMethod(){
	 return new Object[][] {{"First-Value","val1"}, {"Second-Value", "val2"}};
     }
	
    @Test (dataProvider = "data-provider")
    public void myTest (String x,String y) {
        System.out.println("First Passed Parameter Is : " + x+",   Second Passed Parameter Is : "+y);
    }
}