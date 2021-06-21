package StreamAPI;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class words {



    public static List<List<String>> test(List<String> strs) {


        /*Map<String, ArrayList<String>> map = new HashMap<>();

        Set<String> collect = words.stream()
                .map(word -> {
                    char[] chars = word.toLowerCase().toCharArray();
                    Arrays.sort(chars);
                    String str = new String(chars);
                    return str;
                })
                .collect(Collectors.toSet())
                .forEach(val -> map.putIfAbsent(val, new ArrayList<String>()));

        words.stream()
                .forEach(word -> {
                    char[] chars = word.toLowerCase().toCharArray();
                    Arrays.sort(chars);
                    String k2 = new String(chars);
                    map.get(k2).add(word);
                });

    }*/

        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] array = str.toLowerCase().toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
     }


    public static void main(String[] args) {
        List<String> words=new ArrayList<String>();

        words.add("Rat");
        words.add("Car");
        words.add("Below");
        words.add("Tast");
        words.add("Cried");
        words.add("Study");
        words.add("Thing");
        words.add("Chin");
        words.add("Grab");
        words.add("Act");
        words.add("Robed");
        words.add("Vase");
        words.add("Glean");
        words.add("Desserts");
        words.add("Tar");
        words.add("Arc");
        words.add("Elbow");
        words.add("State");
        words.add("Cider");
        words.add("Dusty");
        words.add("Night");
        words.add("Inch");
        words.add("Brag");
        words.add("Cat");
        words.add("Bored");
        words.add("Save");
        words.add("Angel");
        words.add("Streseed");
        System.out.println(words);
        //String[] newWord = (String[]) words.toArray();

        List<List<String>> res = test(words);
        System.out.println(res);
    }
}
