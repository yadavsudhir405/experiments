package github.com.yadavsudhir405.experiments.coreJavaPractise.collections.maps;

import java.util.*;

/**
 * @author sudhir
 *         Date:7/4/17
 *         Time:3:35 PM
 *         Project:core-java-practise
 */
public class SortedMapTraversalTest {

    public static void main(String[] args) {
        NavigableMap<Integer,String> map=new TreeMap<>();
        map.put(500,"d");
        map.put(100,"b");
        map.put(900,"a");
        map.put(300,"s");
        map.put(600,"e");
        map.put(100,"f");
        map.put(200,"c");
        testTraversal(map);
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
       /* System.out.println("Map in reverse Order\n\n\n");
        NavigableMap<Integer,String> reversedMap=new TreeMap<>(comparator);
        reversedMap.putAll(map);
        testTraversal(reversedMap);*/
    }
    private static  void testTraversal(SortedMap<Integer,String> map){
        displayMap(map);
        System.out.println("First  Key of map "+map.firstKey());
        System.out.println("Last  Key of map "+map.lastKey());
        //System.out.println("First Entry of Map "+map.firstEntry().getKey()+" : "+map.firstEntry().getValue());
        //System.out.println("Last Entry of Map "+map.lastEntry().getKey()+" : "+map.lastEntry().getValue());

        SortedMap<Integer,String> mapLesserThanFiveHundred=map.headMap(500);
        System.out.println("Sub Map head To 500");
        displayMap(mapLesserThanFiveHundred);

        System.out.println("Sub Map tail from 500");
        Map<Integer,String> mapgreaterThanFiveHundred=map.tailMap(500);
        displayMap(mapgreaterThanFiveHundred);
        System.out.println("Modifying Tail Map: Adding elemets within the range");
        mapgreaterThanFiveHundred.put(700,"M");

        System.out.println("Displaying Original Map");
        displayMap(map);
        System.out.println("Displaying Modified backed  Map");
        displayMap(mapgreaterThanFiveHundred);

        System.out.println("Adding elemets out of the range,Should throw Illegal ArgumentException");
        try{
            mapgreaterThanFiveHundred.put(499,"I");
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Printing Map from from 300 to 600");
        SortedMap<Integer,String> map1=map.subMap(300,600+1);
        displayMap(map1);

        System.out.println("Printing Map greater than 300 and lesser than equal to 600");
        SortedMap<Integer,String> map2=map.subMap(300+1,600+1);
        displayMap(map2);

        System.out.println("Printing Map greater than equal to 300 and lesser than 600");
        SortedMap<Integer,String> map3=map.subMap(300,600);
        displayMap(map3);

    }
    private static void displayMap(Map<Integer,String> map){
        for(Map.Entry<Integer,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
