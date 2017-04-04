package github.com.yadavsudhir405.experiments.coreJavaPractise.serialization;

import github.com.yadavsudhir405.experiments.coreJavaPractise.generals.Point;

import java.io.Serializable;

/**
 * @author sudhir
 *         Date:20/3/17
 *         Time:10:58 AM
 *         Project:core-java-practise
 */
public class Person implements Serializable{
    private String name;
    private int age;
    private transient Address address;
    public Person(String name,int age,Address address){
        this.name=name;
        this.age=age;
        this.address=address;
    }
    public void show(){
        Point p=new Point(10,20);

    }
    @Override
    public String toString(){
        return "name:"+name+",age:"+age+","+address.toString();
    }
}
