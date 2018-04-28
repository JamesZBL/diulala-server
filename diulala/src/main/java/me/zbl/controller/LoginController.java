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
package me.zbl.controller;

import me.zbl.conf.WXProperties;
import me.zbl.entity.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
  public LoginResponse login(String code) {
    return new LoginResponse("11111111111");
  }
}
