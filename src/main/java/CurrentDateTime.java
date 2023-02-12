import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDateTime {
public static void main(String[] args) {
DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
LocalDateTime now = LocalDateTime.now();
System.out.println(df.format(now));
}
}
