//package my.useragent;
//
//import com.blueconic.browscap.*;
//import eu.bitwalker.useragentutils.OperatingSystem;
//import nl.basjes.parse.useragent.UserAgent;
//import nl.basjes.parse.useragent.UserAgentAnalyzer;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * yauaa userAgent解析工具包测试
// *
// * @author Mr.黄
// * @date 2022/05/09
// **/
//public class UserAgentTest {
//    public static void main(String[] args) throws IOException, ParseException {
//        System.out.println("aaa");
//        UserAgentAnalyzer userAgentAnalyzer = UserAgentAnalyzer
//            .newBuilder()
//            .hideMatcherLoadStats()
//            .withCache(0)
//            .build();
//        UserAgentParser userAgentParser = new UserAgentService().loadParser();
//
//        String u1 = "Mozilla/5.0 (Windows NT 6.3; ARM; Trident/7.0; Touch; rv:11.0) like Gecko";
//        String u2 = "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_3; en-us; Silk/1.0.22.79_10013310) AppleWebKit/533.16 (KHTML, like Gecko) Version/5.0 Safari/533.16 Silk-Accelerated=true";
//        String u3 = "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.11) Gecko/20071127 Firefox/2.0.0.11";
//        UserAgent userAgent = userAgentAnalyzer.parse(u2);
//        System.out.println(userAgent.toJson());
//
//        System.out.println("+++++++++++++++++");
//        System.out.println();
//
//        eu.bitwalker.useragentutils.UserAgent userAgent1 = eu.bitwalker.useragentutils.UserAgent.parseUserAgentString(u2);
//        OperatingSystem operatingSystem = userAgent1.getOperatingSystem();
//        System.out.println("platform and deviceType:\t" + operatingSystem.getDeviceType().name());
//        System.out.println("Manufacturer:\t" + operatingSystem.getManufacturer().name());
//        System.out.println("system:\t" + operatingSystem.getGroup().name());
//        System.out.println("systemVersion:\t" + operatingSystem.getName());
//        System.out.println("======================");
//        Capabilities parse = userAgentParser.parse(u2);
////        System.out.println("platform:\t" + parse.getPlatform());
////        System.out.println("deviceType:\t" + parse.getDeviceType());
////        System.out.println("manufacturer：\t" + parse.getValue(BrowsCapField.BROWSER_MAKER));
//        Map<BrowsCapField, String> values = parse.getValues();
//        for (Map.Entry<BrowsCapField, String> entry : values.entrySet()) {
//            System.out.println(entry.getKey() + "\t" + entry.getValue());
//        }
//        System.out.println(parse.getValue(BrowsCapField.DEVICE_NAME));
//    }
//}