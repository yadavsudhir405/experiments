package github.com.yadavsudhir405.experiments.coreJavaPractise.collections.maps;

import java.util.Map;

/**
 * @author sudhir
 *         Date:30/3/17
 *         Time:9:29 PM
 *         Project:core-java-practise
 */
public class MapRunner {
    public static void main(String[] args) {
        String hello="hello";
        String hel="hel";
        String lo="lo";
        String result=hel.concat(lo);
        System.out.println(result.equals(hello));
        System.out.println(result==hello);
    }
    private static void displayMap(Map<String,Integer> map){
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }

}
