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

import java.util.Optional;

/**
 * 用于 Token 维护操作的接口
 *
 * @param <TK> 生成的 Token 的类型
 * @param <U>  Token 中存储的信息的类型
 *
 * @author JamesZBL
 * @date 2018-04-18
 */
public interface TokenManager<TK, U> {

  /**
   * 生成一个 Token
   *
   * @param info 存储的实体
   *
   * @return token
   */
  TK createToken(U info);

  /**
   * 检查 token 是否存在
   *
   * @param token token
   */
  boolean hasToken(TK token);

  /**
   * 尝试获取 token 实体
   *
   * @param token token
   *
   * @return token 实体
   */
  Optional<U> getTokenInfo(TK token);

  /**
   * 对 token 进行刷新操作
   * 比如：刷新 token 的失效时间
   *
   * @param token
   */
  void flushToken(TK token);

  /**
   * 使当前 token 立即失效
   *
   * @param token token
   */
  void destroyToken(TK token);

  /**
   * 生成 特定类型的 token
   *
   * @return token
   */
  TK produceToken();
}
