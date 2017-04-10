package github.com.yadavsudhir405.experiments.coreJavaPractise.collections.maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author sudhir
 *         Date:7/4/17
 *         Time:9:22 PM
 *         Project:core-java-practise
 */
public class LinkedHashMapRunner {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> integerStringLinkedHashMap=new LinkedHashMap<>();
        integerStringLinkedHashMap.put(500,"a");
        integerStringLinkedHashMap.put(300,"d");
        integerStringLinkedHashMap.put(200,"b");
        integerStringLinkedHashMap.put(400,"c");
    }
    private static void display(LinkedHashMap<Integer,String> map){
        Set<Map.Entry<Integer,String>> entrySet=map.entrySet();
    }

}
