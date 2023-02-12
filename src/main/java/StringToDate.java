import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
public static void main(String[] args)throws Exception {
String sDate="01/01/2020";
Date date=new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
System.out.println(sDate+"\t"+date);
}
}