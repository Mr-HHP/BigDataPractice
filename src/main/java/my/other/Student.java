package my.other;

/**
 * @author Mr.黄
 * @date 2021/10/08
 **/
public class Student {
  private String name;
  private int id;
  private int age;
  
  public void test() {
    System.out.println(this.name + this.id + this.age);
  }
  
  public Student() {
  }
  
  public Student(String name, int id, int age) {
    this.name = name;
    this.id = id;
    this.age = age;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public int getAge() {
    return age;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
}