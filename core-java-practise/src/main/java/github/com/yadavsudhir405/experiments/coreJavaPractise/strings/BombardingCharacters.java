package github.com.yadavsudhir405.experiments.coreJavaPractise.strings;

/**
 * @author sudhir
 *         Date:14/4/17
 *         Time:10:59 PM
 *         Project:core-java-practise
 */
public class BombardingCharacters {
    public static void main(String[] args) {
        //String str="agfbcdeeedcbfg";
        String str="agg";
        String string=bomardString(str);
        System.out.println(string);
    }

    private static String bomardString(String str) {
        while (isConsecutiveStringPresent(str)){
            str=removeFirstConsecutiveCharacter(str);
        }
        return str;
    }

    private static String removeFirstConsecutiveCharacter(String str) {
        if(str.length()==2){
            if(str.charAt(0)==str.charAt(1)){
                return "";
            }else {
                return str;
            }
        }else if (str.length()>2){
            boolean consecutievFound=false;
            for(int i=0;i<str.length()-1;i++){
                int j=i+1;
                while(j<str.length()&&str.charAt(i)==str.charAt(j)){
                    j++;consecutievFound=true;
                }
                if(consecutievFound){
                    String leftPart=str.substring(0,i);
                    if(j>=str.length()){
                       return leftPart;
                    }else{
                        String rightPart=str.substring(j);
                        return leftPart+rightPart;
                    }

                }

            }
            return str;
        }else {
            return str;
        }
    }

    private static boolean isConsecutiveStringPresent(String  str){
        boolean consecutive=false;
        if(str.length()==1){
            consecutive=false;
        }else if(str.length()==2){
            consecutive=(str.charAt(0)==str.charAt(1));
        }else{
            for(int i=0;i<str.length()-1;i++){
                if(str.charAt(i)==str.charAt(i+1)){
                    consecutive=true;break;
                }
            }

        }
        return consecutive;
    }
}
