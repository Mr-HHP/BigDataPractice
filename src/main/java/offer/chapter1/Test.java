package offer.chapter1;

import my.other.Student;

/**
 * @author Mr.黄
 * @date 2021/10/10
 **/
public class Test {
  public static void main(String[] args) {
    Student student1 = new Student("li",1, 12);
    Student student2 = new Student("huang",1, 23);
    Student student3 = new Student("huang",1, 23);
    System.out.println(student1 == student2);
    System.out.println(student2 == student3);
    System.out.println("student1 hashCode:\t" + student1.hashCode());
    System.out.println("student2 hashCode:\t" + student2.hashCode());
    System.out.println("student3 hashCode:\t" + student3.hashCode());
  }
}