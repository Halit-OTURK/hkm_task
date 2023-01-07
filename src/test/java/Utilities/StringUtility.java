package Utilities;

public class StringUtility {

    public static void verifyEquals(String actual,String expected){
        if (actual.equals(expected)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
    }
}
