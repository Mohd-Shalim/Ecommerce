import java.util.Random;

public class GenerateRandomNumber {
public static void main(String[] args){
Random rand = new Random();
int r1 = rand.nextInt(100); //max limit
System.out.println("Random numbers: "+ r1);
}
}