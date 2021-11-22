package my.other;

import java.util.regex.Pattern;

/**
 * @author Mr.黄
 * @date 2021/11/18
 **/
public class Test {
  static Pattern pattern = Pattern.compile("^[0-9]*$");
  public static void main(String[] args) {
    System.out.println(pattern.matcher("1234").matches());
    System.out.println(pattern.matcher("1234.67").matches());
    System.out.println(pattern.matcher("aaa").matches());
    System.out.println(pattern.matcher("+234").matches());
    System.out.println(pattern.matcher("-234").matches());
  }
  
  
  public String test() {
    String string = "sss";
    try {
      throw new Exception();
//      string = "test";
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
    System.out.println("aaaa");
    return string;
  }
}