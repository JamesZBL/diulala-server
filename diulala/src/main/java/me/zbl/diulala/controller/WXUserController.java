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
import me.zbl.controller.base.BaseController;
import me.zbl.diulala.auth.WXTokenManager;
import me.zbl.diulala.client.WXApi;
import me.zbl.diulala.conf.WXProperties;
import me.zbl.diulala.entity.persistence.AppUser;
import me.zbl.diulala.entity.response.ApiLoginResponse;
import me.zbl.diulala.entity.response.CheckUserResponse;
import me.zbl.diulala.entity.response.LoginResponse;
import me.zbl.diulala.exception.AuthFailedException;
import me.zbl.diulala.service.UserService;
import me.zbl.exception.FailOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

/**
 * 小程序登录
 *
 * @author JamesZBL
 * @date 2018-04-28
 */
@Api(value = "小程序登录及用户信息", tags = {"用户信息"})
@RestController
public class WXUserController extends BaseController {

  @Autowired
  WXApi wxApi;

  @Autowired
  WXTokenManager tokenManager;

  @Autowired
  private UserService userService;

  @Autowired
  private WXProperties wxProperties;

  @ApiOperation(value = "用户登录，以 js_code 换取用户的 openId")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "code", value = "wx.login 返回的临时凭证", required = true)
  )
  @GetMapping("/user/login")
  public LoginResponse login(String code) throws AuthFailedException {
    Map<String, String> response = wxApi.loginForMap(wxProperties.getAppId(),
            wxProperties.getAppSecret(), code, "authorization_code");
    //    获取 openId
    Optional<String> openId = Optional.ofNullable(response.get("openid"));
    Optional<String> sessionKey = Optional.ofNullable(response.get("session_key"));
    openId.orElseThrow(() -> new AuthFailedException(response.toString()));
    //    生成 token
    ApiLoginResponse responseObj = new ApiLoginResponse(openId.get(), sessionKey.get());
    String token = tokenManager.createToken(responseObj);
    return new LoginResponse(openId.get(), token);
  }

  @ApiOperation(value = "通过 openid 校验用户是否完善了个人信息")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "userid", value = "小程序平台用户的 openid", required = true)
  )
  @GetMapping("/user/hasuser")
  public CheckUserResponse checkUserExists(
          String userid,
          @ApiIgnore @ModelAttribute
                  CheckUserResponse checkUserResponse) {
    boolean exists = userService.existUser(userid);
    checkUserResponse.setExist(exists);
    return checkUserResponse;
  }

  @ApiOperation(value = "获取用户信息")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "userid", value = "小程序平台用户的 openid", required = true)
  )
  @GetMapping("/user/getuser")
  public AppUser findWXUser(String userid) {
    return wrapData(userService.findUser(userid));
  }


  @ApiOperation(value = "用户注册（完善用户个人信息）")
  @ApiImplicitParams(
          value = {
                  @ApiImplicitParam(name = "openId", value = "小程序平台用户的 openid", required = true),
                  @ApiImplicitParam(name = "nickName", value = "昵称", required = true),
                  @ApiImplicitParam(name = "unionId", value = "用户在本小程序平台的唯一标识"),
                  @ApiImplicitParam(name = "avatarUrl", value = "头像 URL", required = true),
                  @ApiImplicitParam(name = "realName", value = "真实姓名"),
                  @ApiImplicitParam(name = "gender", value = "性别", required = true),
                  @ApiImplicitParam(name = "contactMethod", value = "联系途径（电话，QQ，微信等）", required = true),
                  @ApiImplicitParam(name = "contactString", value = "联系方式（具体的号码）", required = true),
                  @ApiImplicitParam(name = "city", value = "城市", required = true),
                  @ApiImplicitParam(name = "province", value = "省份", required = true),
                  @ApiImplicitParam(name = "country", value = "国家", required = true)}
  )
  @PostMapping("/user/register")
  public AppUser fillUserInfo(@ApiIgnore @Valid AppUser appUser, BindingResult result) throws FailOperationException, BindException {
    if(result.hasErrors())
      throw new BindException(result);
    return userService.fullFillUserInfo(appUser);
  }

  @ApiOperation(value = "修改用户个人信息")
  @ApiImplicitParams(
          value = {
                  @ApiImplicitParam(name = "openId", value = "小程序平台用户的 openid", required = true),
                  @ApiImplicitParam(name = "nickName", value = "昵称", required = true),
                  @ApiImplicitParam(name = "unionId", value = "用户在本小程序平台的唯一标识"),
                  @ApiImplicitParam(name = "avatarUrl", value = "头像 URL", required = true),
                  @ApiImplicitParam(name = "realName", value = "真实姓名"),
                  @ApiImplicitParam(name = "gender", value = "性别", required = true),
                  @ApiImplicitParam(name = "contactMethod", value = "联系途径（电话，QQ，微信等）", required = true),
                  @ApiImplicitParam(name = "contactString", value = "联系方式（具体的号码）", required = true),
                  @ApiImplicitParam(name = "city", value = "城市", required = true),
                  @ApiImplicitParam(name = "province", value = "省份", required = true),
                  @ApiImplicitParam(name = "country", value = "国家", required = true)}
  )
  @PutMapping("/user/update")
  public AppUser updateUserInfo(@ApiIgnore @RequestBody AppUser appUser) throws FailOperationException {
    return userService.updateUserInfo(appUser);
  }
}
