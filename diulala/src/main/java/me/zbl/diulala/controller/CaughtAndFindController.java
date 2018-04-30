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
import me.zbl.diulala.entity.persistence.AppFindLoser;
import me.zbl.diulala.service.FindLoserService;
import me.zbl.exception.FailOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Collection;

/**
 * 待认领的物品查询
 *
 * @author JamesZBL
 * @date 2018-04-30
 */
@Api(value = "待认领", tags = {"失物招领"})
@RestController
public class CaughtAndFindController extends BaseController {

  @Autowired
  private FindLoserService findLoserService;

  @ApiOperation(value = "丢失者通过唯一标识匹配由捡到者发布的信息")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "identification", value = "唯一标识的内容，比如银行卡号", required = true)
  )
  @GetMapping("/caught/match")
  public Collection<AppFindLoser> matchFindLoser(String identification) {
    return wrapData(findLoserService.findFindLoserByIdentification(identification));
  }


  @ApiOperation(value = "提交捡到物品的信息")
  @ApiImplicitParams(value = {
          @ApiImplicitParam(name = "userid", value = "捡到者 openId", required = true),
          @ApiImplicitParam(name = "category", value = "物品分类", required = true),
          @ApiImplicitParam(name = "name", value = "物品名称", required = true),
          @ApiImplicitParam(name = "identification", value = "唯一标识", required = true),
          @ApiImplicitParam(name = "longitude", value = "经度", required = true),
          @ApiImplicitParam(name = "latitude", value = "纬度", required = true),
          @ApiImplicitParam(name = "poi", value = "POI"),
          @ApiImplicitParam(name = "description", value = "物品描述", required = true)
  })
  @PostMapping("/caught/submit")
  public AppFindLoser findThing(String userid, @ApiIgnore AppFindLoser lost) throws FailOperationException {
    return findLoserService.submitCaughtInfo(userid, lost);
  }
}
