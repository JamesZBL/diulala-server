/*
 * Copyright 2018 JamesZBL
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package me.zbl.diulala.controller;

import me.zbl.diulala.conf.WXProperties;
import me.zbl.diulala.entity.response.ApiLoginResponse;
import me.zbl.diulala.entity.response.LoginResponse;
import me.zbl.diulala.exception.AuthFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 小程序登录
 *
 * @author JamesZBL
 * @date 2018-04-28
 */
@RestController
public class LoginController {

  @Autowired
  private WXProperties wxProperties;

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/w_login")
  public LoginResponse login(String code) throws AuthFailedException {
    Map<String, String> params = new HashMap<>();
    params.put("appid", wxProperties.getAppId());
    params.put("secret", wxProperties.getAppSecret());
    // todo 改成 code
    params.put("js_code", "22222");
    params.put("grant_type", "authorization_code");
    ResponseEntity<ApiLoginResponse> response=  restTemplate.getForEntity(wxProperties.getUrlCode2Session(), ApiLoginResponse.class, params);

    //    todo delete this line
    String openid = response.getBody().getErrmsg();
    return new LoginResponse(openid);
  }
}
