package github.com.yadavsudhir405.experiments.coreJavaPractise.serialization;

/**
 * @author sudhir
 *         Date:20/3/17
 *         Time:10:59 AM
 *         Project:core-java-practise
 */
public class Address {
    private String city;
    private int  pincode;
    public Address(String city,int pincode){
        this.city=city;
        this.pincode=pincode;
    }
    @Override
    public String toString(){
        return "city:"+city+", pincode:"+pincode;
    }
}
