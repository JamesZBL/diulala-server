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

import org.springframework.stereotype.Component;

/**
 * 用于 Token 维护操作的接口
 *
 * @author JamesZBL
 * @date 2018-04-18
 */
@Component
public interface TokenManager<ID, T> {

  /**
   * 生成 Token
   * 每个 Token 都和一个用户绑定
   *
   * @param id 用户唯一表示
   *
   * @return 新生成的 Token
   */
  T createToken(ID id);

  /**
   * 校验 Token 的有效性
   *
   * @param token 待校验 Token
   *
   * @return 是否有效
   */
  boolean authentication(T token);

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
   * @param id 用户 ID
   */
  void removeToken(ID id);

  /**
   * 将 token 反序列化为 token 对象
   *
   * @return token 对象
   */
  T deserialize(String token);

  /**
   * 将 token 序列化为 token 字符串
   *
   * @return token 字符串
   */
  String serialize(T token);
}
