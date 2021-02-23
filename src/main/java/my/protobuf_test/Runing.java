package my.protobuf_test;

/**
 * 主方法类
 *
 * @author Mr.黄
 * @date 2021/02/22
 **/
public class Runing {
  public static void main(String[] args) {
    PresonOuterClass.Preson john = PresonOuterClass
            .Preson
            .newBuilder()
            .setName("John Doe")
            .setId(1234)
            .setEmail("jode@example.com")
            .addPhone(PresonOuterClass.Preson.PhoneNumber.newBuilder()
            .setNumber("555-4321")
            .setType(PresonOuterClass.Preson.PhoneType.HOME)
            )
            .build();
  
    System.out.println(john);
  }
}