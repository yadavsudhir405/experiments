package github.com.yadavsudhir405.experiments.coreJavaPractise.serialization;

import java.io.*;

/**
 * @author sudhir
 *         Date:20/3/17
 *         Time:11:03 AM
 *         Project:core-java-practise
 */
public class PersonTestRunner {
    private static final String FILE_NAME="person.ser";
    private static final String PERSON_SERIALIZATION_DIRECTORY="serialization";
    private static   String FILE_DIRECTORY;

    private static void createPersonDirectoryInTarget() {
        createDirectoryInTarget(PERSON_SERIALIZATION_DIRECTORY);
    }
    private static void createDirectoryInTarget(String directoryPath){
        File file=new File(directoryPath);
        if(file.exists()){
            System.out.println("Directory is already present");
        }else{
            file.mkdir();
            System.out.println("Directory created in path "+directoryPath);
        }
    }
    public static void main(String... args){
        createPersonDirectoryInTarget();
        createAndSerializePerson();
    }


    private static void createAndSerializePerson(){
        Address address=new Address("Bangalore",560046);
        Person person=new Person("Sudhir",27,address);
        serializePerson(person);
    }
    private static void serializePerson(Person person){

        try{
            String personSerializationPath= PERSON_SERIALIZATION_DIRECTORY+File.pathSeparator+FILE_NAME;
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(new File(personSerializationPath)));
            objectOutputStream.writeObject(person);
            System.out.println("Object got serialized");
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
