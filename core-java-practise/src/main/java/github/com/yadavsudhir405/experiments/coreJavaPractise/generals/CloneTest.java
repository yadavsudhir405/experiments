package github.com.yadavsudhir405.experiments.coreJavaPractise.generals;

/**
 * @author sudhir
 *         Date:1/4/17
 *         Time:3:21 PM
 *         Project:core-java-practise
 */
public class CloneTest {
    public static void main(String[] args) {
        Person person=new Person("Sudhir");
        Person cloned=(Person)person.clone();
        System.out.println(cloned);
    }
    private static class Person{
        private final String name;

        private Person(String name) {
            this.name = name;
        }
        public Object clone(){
            return new Person(name);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
