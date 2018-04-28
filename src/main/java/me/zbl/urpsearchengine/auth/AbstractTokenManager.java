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
package me.zbl.urpsearchengine.auth;

import me.zbl.urpsearchengine.auth.entity.TokenEntity;

/**
 * token 管理抽象类
 * <p>
 * 实现对 token 的公共操作
 *
 * @author JamesZBL
 * @date 2018-04-19
 */
public abstract class AbstractTokenManager implements TokenManager {

  /**
   * 将 token 反序列化为 token 对象
   *
   * @param token token 字符串
   *
   * @return token 对象
   */
  @Override
  public TokenEntity deserialize(String token) {
    String[] arr = token.split("-");
    return new TokenEntity(Integer.valueOf(arr[0]), arr[1]);
  }
}
