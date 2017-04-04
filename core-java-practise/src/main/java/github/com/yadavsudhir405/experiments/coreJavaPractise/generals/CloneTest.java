package github.com.yadavsudhir405.experiments.coreJavaPractise.generals;

/**
 * @author sudhir
 *         Date:1/4/17
 *         Time:3:21 PM
 *         Project:core-java-practise
 */
public class CloneTest {
    public static void main(String[] args) {
        PointChild pointChild=new PointChild(10,20,30);
        PointChild pointChild1=pointChild.clone();
        System.out.println("******");
        System.out.println(pointChild1);


       /* Person person=new Person("Sudhir");
        String str=String.valueOf(person);
        System.out.println(str);*/
        /*ArrayList<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        ArrayList arrayList=(ArrayList) list.clone();
        arrayList.add(8);
        arrayList.remove(Integer.valueOf(8));
        System.out.println(list);
        System.out.println(arrayList);*/
       /* Person person=new Person("Sudhir");
        Person cloned=(Person)person.clone();
        System.out.println(cloned);*/
    }

    private static class Person{
        private final String name;

        private Person(String name) {
            this.name = name;
        }
        public Object clone(){
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new Person(name);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
