package github.com.yadavsudhir405.experiments.coreJavaPractise.generals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author sudhir
 *         Date:3/4/17
 *         Time:12:48 PM
 *         Project:core-java-practise
 */
public class Testasd {

    public static void main(String[] args) {
       test();
    }

    private static void test() {
        Map<String,Object> map=new LinkedHashMap<>();
        map.put("url","http://localhost");
        map.put("host","adfa");
        map.put("port",9090);
        try {
            System.out.println(new ObjectMapper().writeValueAsString(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
