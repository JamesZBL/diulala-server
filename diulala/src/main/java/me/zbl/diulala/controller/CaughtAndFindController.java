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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * 待认领的物品查询
 *
 * @author JamesZBL
 * @date 2018-04-30
 */
@Api(value = "待认领", tags = {"匹配由捡到者发布的信息"})
@RestController
public class CaughtAndFindController extends BaseController {

  @Autowired
  private FindLoserService findLoserService;

  @ApiOperation(value = "丢失者通过唯一标识匹配由捡到者发布的信息")
  @ApiImplicitParams(
          @ApiImplicitParam(name = "identification", value = "唯一标识的内容，比如银行卡号", required = true)
  )
  @GetMapping("/matchlose")
  public Collection<AppFindLoser> matchFindLoser(String identification) {
    return wrapData(findLoserService.findFindLoserByIdentification(identification));
  }
}
