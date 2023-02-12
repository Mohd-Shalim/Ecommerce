import java.util.HashMap;
import java.util.Map;

public class HashMapImple{
public static void frequencyWords(String strInput){
Map<String, Integer> map = new HashMap<String, Integer>();
String[] words = strInput.split("\\s+");
for(String word: words){
if(map.containsKey(word)){
int count = map.get(word);
map.put(word,count+1);
} else {
map.put(word,1);
}
}for(Map.Entry<String,Integer> entry: map.entrySet()){
System.out.println(entry.getKey() + ":" + entry.getValue());
}
}
public static void main(String[] args)
{
	frequencyWords("xhjfsgfjgsjfgsj");
}
}
