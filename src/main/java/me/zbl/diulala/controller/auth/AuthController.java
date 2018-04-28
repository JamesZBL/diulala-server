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
package me.zbl.diulala.controller.auth;

import me.zbl.diulala.auth.TokenManager;
import me.zbl.diulala.auth.entity.TokenEntity;
import me.zbl.diulala.controller.base.BaseController;
import me.zbl.diulala.entity.response.MessageEntity;
import me.zbl.diulala.service.SysAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JamesZBL
 * @date 2018-04-19
 */
@Controller
public class AuthController extends BaseController {

  private static final String MSG_LOGIN_FAIL = "用户名或密码错误";
  private final TokenManager tokenManager;
  private final SysAdminUserService adminService;

  @Autowired
  public AuthController(TokenManager tokenManager, SysAdminUserService adminService) {
    this.tokenManager = tokenManager;
    this.adminService = adminService;
  }

  @GetMapping("/adminlogin")
  public ResponseEntity login(String username, String password) {
    Map<String, String> result = new HashMap<>();
    if (adminService.validateAdminUser(username, password)) {
      TokenEntity token = tokenManager.createToken(1);
      result.put("token", token.toString());
      return wrapData(result);
    }

    return new ResponseEntity<>(
            new MessageEntity(MSG_LOGIN_FAIL),
            HttpStatus.UNAUTHORIZED);
  }
}
