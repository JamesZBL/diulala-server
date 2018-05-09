package me.zbl.diulala;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import me.zbl.diulala.client.WXApi;
import me.zbl.diulala.entity.response.ApiLoginResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author JamesZBL
 * @email 1146556298@qq.com
 * @date 2018-05-09
 */
public class WXLoginTestTest {

  private WXApi wxApi;

  @Before
  public void setUp(){
    wxApi = Feign.builder()
            .decoder(new GsonDecoder())
            .encoder(new GsonEncoder())
            .target(WXApi.class, "https://api.weixin.qq.com");
  }

  /**
   * 测试小程序登录
   */
  @Test
  public void testWXLogin() {
    ApiLoginResponse response = wxApi.login(
            "wx698220e7667a01e3",
            "882d28c93d94c8b7a5450fd0d45a052f",
            "123456",
            "authorization_code"
    );
    Assert.assertNotNull(response.getOpenid());
    System.out.println(response);
  }
}