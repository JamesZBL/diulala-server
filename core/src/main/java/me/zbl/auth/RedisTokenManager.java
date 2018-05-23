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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Redis token 管理器
 *
 * @author JamesZBL
 * @email 1146556298@qq.com
 * @date 2018-05-04
 */
public abstract class RedisTokenManager<TK, U> implements TokenManager<TK, U> {

  private final RedisTemplate<TK, U> redisTemplate;

  @Autowired
  private TokenProperties tokenProperties;

  public RedisTokenManager(RedisTemplate<TK, U> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @Override
  public TK createToken(U info) {
    //    生成 token 字符串
    TK key = produceToken();
    //    将 token 和用户信息绑定
    redisTemplate.boundValueOps(key).set(info,tokenProperties.getTokenTimeout(),TimeUnit.SECONDS);
    return key;
  }

  @Override
  public boolean hasToken(TK token) {
    return redisTemplate.hasKey(token);
  }

  @Override
  public Optional<U> getTokenInfo(TK token) {
    return Optional.of(redisTemplate.boundValueOps(token).get());
  }

  @Override
  public void flushToken(TK token) {
    redisTemplate.boundValueOps(token).expire(tokenProperties.getTokenTimeout(), TimeUnit.SECONDS);
  }

  @Override
  public void destroyToken(TK token) {
    redisTemplate.delete(token);
  }
}
