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
package me.zbl.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 用于用户认证的 Token 实体
 *
 * @author JamesZBL
 * @date 2018-04-18
 */
@Data
@Getter
@Setter
@AllArgsConstructor
public class TokenEntity implements Serializable {

  //  用户 ID
  private Integer userId;
  //  UUID 字符串
  private String token;

  @Override
  public String toString() {
    return userId + "-" + token;
  }
}
