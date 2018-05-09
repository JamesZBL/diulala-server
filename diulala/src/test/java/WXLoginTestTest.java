import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author JamesZBL
 * @email 1146556298@qq.com
 * @date 2018-05-09
 */
public class WXLoginTestTest {


  /**
   * 测试小程序登录
   */
  @Test
  public void testWXLogin() {
    WXApi wxApi = Feign.builder()
            .decoder(new GsonDecoder())
            .encoder(new GsonEncoder())
            .target(WXApi.class, "https://api.weixin.qq.com");

    Map<String, String> response = wxApi.loginPlain(
            "wx698220e7667a01e3",
            "882d28c93d94c8b7a5450fd0d45a052f",
            "123456",
            "authorization_code"
    );
    System.out.println(response);
    Assert.assertNotNull(response);
  }
}