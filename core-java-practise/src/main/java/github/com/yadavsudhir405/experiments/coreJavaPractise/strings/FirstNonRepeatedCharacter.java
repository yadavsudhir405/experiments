package github.com.yadavsudhir405.experiments.coreJavaPractise.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sudhir
 *         Date:31/3/17
 *         Time:10:11 AM
 *         Project:core-java-practise
 */
public class FirstNonRepeatedCharacter {

    public static void main(String[] args) {
        /*String str="aaaaa";
        String str1="a";
        String str2="abcd";
        String str3="aaacd";
        Character c=getFirstNonRepetativeCharacter(str3);
        if(c==null){
            System.out.println("Not Found");
        }else{
            System.out.println(c);
        }*/
        //String str="Hello hari!!";
        //System.out.println(getFirstNonRepetativeCharacter1(str));
        /*StringBuilder stringBuilder=new StringBuilder("madam");
        StringBuilder reversedString= stringBuilder.reverse();
        System.out.println(stringBuilder.equals(reversedString));*/
        String str="I stay in bangalore";
        String expectedString="bangalore in stay I";
        String reversedString=reverseSentence(str);
        System.out.println(reversedString);
    }
    private static String reverseSentence(String str){
        String[] strs=str.split(" ");
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=strs.length-1;i>=0;i--){
            stringBuilder.append(strs[i]).append(" ");
        }
        int lastIndexOfSpace=stringBuilder.lastIndexOf(" ");
        return stringBuilder.substring(0,lastIndexOfSpace);
    }
    private static Character getFirstNonRepetativeCharacter(String str){
        if(str.length()==1){
            return str.charAt(0);
        }
        char[] chars=str.toCharArray();
        for(int i=0;i<chars.length-1;i++){
            char currentChar=chars[i];
            char nextChar=chars[i+1];
            if(currentChar!=nextChar&&i!=0){
                return nextChar;
            }else if(currentChar!=nextChar){
                return currentChar;
            }else {
                //Do nothing
            }
        }
        return null;
    }
    private static  boolean/*Character*/ getFirstNonRepetativeCharacter1(String str){
        String regex="([a-zA-z!]+)";
        Pattern pattern=Pattern.compile(regex);
        str=str.trim();
        Matcher matcher=pattern.matcher(str);
        if(matcher.matches()){
            int numberOfMatches=matcher.groupCount();
            System.out.println(numberOfMatches);
            return true;
        }else{
            return false;
        }
    }
    private static String reversedString(String str){
        if(str.length()==1){
            return str;
        }
        char[] chars=str.toCharArray();
        int startIndex=0;
        int endIndex=str.length()-1;
        while(startIndex<=endIndex){
            char temp=chars[startIndex];
            chars[startIndex]=chars[endIndex];
            chars[endIndex]=temp;
            startIndex++;endIndex--;
        }
        return new String(chars);
    }
}

