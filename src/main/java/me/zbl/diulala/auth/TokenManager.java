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
package me.zbl.diulala.auth;

import me.zbl.diulala.auth.entity.TokenEntity;

/**
 * 用于 Token 维护操作的接口
 *
 * @author JamesZBL
 * @date 2018-04-18
 */
public interface TokenManager {

  /**
   * 生成 Token
   * 每个 Token 都和一个用户绑定
   *
   * @param userId 用户 ID
   *
   * @return 新生成的 Token
   */
  TokenEntity createToken(Integer userId);

  /**
   * 校验 Token 的有效性
   *
   * @param token 待校验 Token
   *
   * @return 是否有效
   */
  boolean authentication(TokenEntity token);

  /**
   * 校验 Token 的有效性
   *
   * @param token 待校验 Token
   *
   * @return 是否有效
   */
  boolean authentication(String token);

  /**
   * 使用户的当前 Token 失效
   * 用于登出
   *
   * @param userId 用户 ID
   */
  void removeToken(Integer userId);

  /**
   * 将 token 反序列化为 token 对象
   *
   * @param token token 字符串
   *
   * @return token 对象
   */
  TokenEntity deserialize(String token);
}
