package github.com.yadavsudhir405.experiments.coreJavaPractise.collections.maps;

import java.util.*;

/**
 * @author sudhir
 *         Date:7/4/17
 *         Time:10:56 AM
 *         Project:core-java-practise
 */
public class TreeMapRunner {

    public static void main(String[] args) {
        //testMapExperiments();
        equalsAndCompareMethodConsistency();
    }





    private static void equalsAndCompareMethodConsistency(){
        Person p1=new Person("Sudhir",100);
        Person p2=new Person("Sudhir1",100);
        System.out.println("Equals Method results "+p1.equals(p2));
        boolean result=p1.compareTo(p2)==0?true:false;
        System.out.println("ComapreToMethod results "+result);
    }
    private static void testMapExperiments(){
        {
            Person p1=new Person("Sudhir",100);
            Person p2=new Person("Sudhir",200);
            Person p3=new Person("Sudhir",300);
            Person p4=new Person("Sudhir1",200);

            TreeMap<Person,String> map=new TreeMap<>();
            map.put(p2,"p2");
            map.put(p1,"p1");
            map.put(p3,"p3");
            map.put(p4,"p4");
            displayMap(map);

            Comparator<Person> personComparator=new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    return o2.compareTo(o1);
                }
            };

            TreeMap<Person,String> reversedMap=new TreeMap<>(personComparator);
            reversedMap.put(p2,"p2");
            reversedMap.put(p1,"p1");
            reversedMap.put(p3,"p3");
            reversedMap.put(p4,"p4");

            System.out.println("Reversed Map : ");
            displayMap(reversedMap);

            System.out.println("*****************************************\n\n");

            Map<String,Integer> stringIntegerHashMap=new HashMap<>();
            stringIntegerHashMap.put("e",900);
            stringIntegerHashMap.put("a",500);
            stringIntegerHashMap.put("c",100);
            stringIntegerHashMap.put("d",200);
            stringIntegerHashMap.put("b",400);

            System.out.println("General Map");
            displayMap(stringIntegerHashMap);

            TreeMap<String,Integer> treeMap=new TreeMap<>();
            treeMap.putAll(stringIntegerHashMap);
            System.out.println("Sorted map based on keys");
            displayMap(treeMap);

            System.out.println("Displaying Map based on sorted values");
            Set<Map.Entry<String,Integer>> entries=stringIntegerHashMap.entrySet();
            List<Map.Entry<String,Integer>> entriesList=new ArrayList<>(entries);
            entriesList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
            displayListContaingMapEntries(entriesList);

        }
    }
    private static <E>  void displayListContaingMapEntries(List<E> list){
        for(E e:list){
            if(e instanceof Map.Entry<?,?>){
                Map.Entry<?,?> entry=(Map.Entry<?,?>)e;
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
        }
    }
    private  static <K,V> void displayMap(Map<K,V> map){
        for(Map.Entry<K,V> entry:map.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
    private static class Person implements Comparable<Person>{
        private final String name;
        private final int age;

        private Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            int result=1;
            result=result*31+ Objects.hashCode(name);
            result=result*31+Objects.hashCode(age);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            return name != null ? name.equals(person.name) : person.name == null;

        }

        @Override
        public int compareTo(Person o) {
           /* if(age>o.age){
                return 1;
            }else if(age<o.age){
                return -1;
            }else{
                return 0;
            }*/

            if(name.equals(o.name)){
                if(age>o.age) return 1;
                else if(age<o.age) return -1;
                else return 0;
            }else{
                return name.compareTo(o.name);
            }
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
