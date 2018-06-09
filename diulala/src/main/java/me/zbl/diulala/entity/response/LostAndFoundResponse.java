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
package me.zbl.diulala.entity.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户丢失寻找数量统计
 *
 * @author JamesZBL
 * @email 1146556298@qq.com
 * @date 2018-06-09
 */
@ApiModel
@Getter
@Setter
@AllArgsConstructor
public class LostAndFoundResponse {

  @ApiModelProperty(value = "归还给他人的物品数量")
  private int returnCount;
  @ApiModelProperty(value = "找回的物品的数量")
  private int gotBackCount;
}
