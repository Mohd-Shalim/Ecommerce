import java.util.Arrays;

public class SortNumbers
{
public static void main(String[] args)
{
int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
Arrays.sort(arr);
//%s means interpret as string,
//%d is for digit, %x is digit in hexadecimal, %f is for float
System.out.printf("Modified arr[] : %s", Arrays.toString(arr));
//System.out.printf("Msodified arr[] : "+ arr[1]);
}
}