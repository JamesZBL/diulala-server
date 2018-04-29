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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import me.zbl.diulala.conf.WXProperties;
import me.zbl.diulala.entity.response.ApiLoginResponse;
import me.zbl.diulala.entity.response.CheckUserResponse;
import me.zbl.diulala.entity.response.LoginResponse;
import me.zbl.diulala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

/**
 * 小程序登录
 *
 * @author JamesZBL
 * @date 2018-04-28
 */
@Api(value = "小程序登录", tags = {"用户信息"})
@RestController
public class LoginController {

  @Autowired
  private UserService userService;

  @Autowired
  private WXProperties wxProperties;

  @Autowired
  private RestTemplate restTemplate;

  @ApiOperation(value = "通过 js_code 换取 openid 及 session_key")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "code", value = "wx.login 返回的临时凭证", required = true)
  )
  @GetMapping("/w_login")
  public LoginResponse login(String code) {
    Map<String, String> params = new HashMap<>();
    params.put("appid", wxProperties.getAppId());
    params.put("secret", wxProperties.getAppSecret());
    params.put("js_code", code);
    params.put("grant_type", "authorization_code");
    ResponseEntity<ApiLoginResponse> response = restTemplate.getForEntity(
            wxProperties.getUrlCode2Session(), ApiLoginResponse.class, params);
    String openid = response.getBody().getOpenid();
    return new LoginResponse(openid);
  }

  @ApiOperation(value = "通过 openid 校验用户是否完善了个人信息")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "userid", value = "小程序平台用户的 openid", required = true)
  )
  @GetMapping("/w_hasuser")
  public CheckUserResponse checkUserExists(
          String userid,
          @ApiIgnore @ModelAttribute
                  CheckUserResponse checkUserResponse) {
    boolean exists = userService.existUser(userid);
    checkUserResponse.setExist(exists);
    return checkUserResponse;
  }
}
