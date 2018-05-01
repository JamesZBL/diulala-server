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
import me.zbl.diulala.entity.persistence.AppFindCaughter;
import me.zbl.diulala.service.FindCaughterService;
import me.zbl.exception.FailOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Collection;

/**
 * 丢失的物品相关接口
 *
 * @author JamesZBL
 * @date 2018-04-30
 */
@Api(value = "丢失物品", tags = {"寻物启事"})
@RestController
public class LoseAndFindController extends BaseController {

  @Autowired
  private FindCaughterService findCaughterService;

  @ApiOperation(value = "捡到者通过唯一标识匹配由丢失者发布的信息")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "identification", value = "唯一标识的内容，比如银行卡号", required = true)
  )
  @GetMapping("/lose/match")
  public Collection<AppFindCaughter> matchFindCaughter(String identification) {
    return wrapData(findCaughterService.findFindCaughterByIdentification(identification));
  }

  @ApiOperation(value = "查询本用户提交的丢失的物品信息")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "userid", value = "用户 openId", required = true)
  )
  @GetMapping("/lose/mysubmits")
  public Collection<AppFindCaughter> mySubmits(String userid) {
    return wrapData(findCaughterService.findFindCaughterByUser(userid));
  }

  @ApiOperation(value = "提交丢失物品的信息")
  @ApiImplicitParams(value = {
          @ApiImplicitParam(name = "userid", value = "丢失者 openId", required = true),
          @ApiImplicitParam(name = "category", value = "物品分类", required = true),
          @ApiImplicitParam(name = "name", value = "物品名称", required = true),
          @ApiImplicitParam(name = "identification", value = "唯一标识", required = true),
          @ApiImplicitParam(name = "longitude", value = "经度"),
          @ApiImplicitParam(name = "latitude", value = "纬度"),
          @ApiImplicitParam(name = "poi", value = "POI"),
          @ApiImplicitParam(name = "description", value = "物品描述", required = true),
          @ApiImplicitParam(name = "money", value = "赏金")
  })
  @PostMapping("/lose/submit")
  public AppFindCaughter loseThing(String userid, @ApiIgnore AppFindCaughter lost) throws FailOperationException {
    return findCaughterService.submitLoseInfo(userid, lost);
  }

  @ApiOperation(value = "更新物品的状态为 “已收到” ")
  @ApiImplicitParams(value = {
          @ApiImplicitParam(name = "userid", value = "小程序平台用户的 openid", required = true),
          @ApiImplicitParam(name = "lostid", value = "丢失物品 id", required = true)
  })
  @PutMapping("/lose/got")
  public AppFindCaughter hasReturned(String userid, Integer lostid) throws FailOperationException {
    return findCaughterService.hasGot(userid, lostid);
  }
}
