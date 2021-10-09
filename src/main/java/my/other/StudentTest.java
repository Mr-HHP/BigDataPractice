package my.other;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Mr.黄
 * @date 2021/10/08
 **/
public class StudentTest {
  public static void main(String[] args) throws JsonProcessingException {
    Student student = new Student("李明", 1, 18);
    ObjectMapper objectMapper = new ObjectMapper();
    String writeValueAsString = objectMapper.writeValueAsString(student);
    String toJSONString = JSON.toJSONString(student);
    System.out.println(writeValueAsString);
    System.out.println(toJSONString);
  }
}