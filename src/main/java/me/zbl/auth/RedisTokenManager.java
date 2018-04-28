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

import me.zbl.auth.entity.TokenEntity;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 使用 Redis 管理 Token
 *
 * @author JamesZBL
 * @date 2018-04-18
 */
@Component
public class RedisTokenManager extends AbstractTokenManager {

  @Resource(name = "tokenRedisTemplate")
  private RedisTemplate<Integer, TokenEntity> redisTemplate;

  /**
   * 生成 Token
   * 每个 Token 都和一个用户绑定
   *
   * @param userId 用户 ID
   *
   * @return 新生成的 Token
   */
  @Override
  public TokenEntity createToken(Integer userId) {
    TokenEntity token = new TokenEntity(userId, UUID.randomUUID().toString().replace("-", ""));
    redisTemplate.boundValueOps(userId).set(token, 1, TimeUnit.HOURS);
    return token;
  }

  /**
   * 校验 Token 的有效性
   *
   * @param token 待校验 Token
   *
   * @return 是否有效
   */
  @Override
  public boolean authentication(TokenEntity token) {
    if (null == token) {
      return false;
    }

    TokenEntity stored = redisTemplate.boundValueOps(token.getUserId()).get();
    if (!(stored.getToken().equals(token.getToken()))) {
      return false;
    }

    redisTemplate.boundValueOps(stored.getUserId()).expire(1, TimeUnit.HOURS);
    return true;
  }

  /**
   * 校验 Token 的有效性
   *
   * @param token 待校验 Token
   *
   * @return 是否有效
   */
  @Override
  public boolean authentication(String token) {
    TokenEntity entity = deserialize(token);
    return authentication(entity);
  }

  /**
   * 使用户的当前 Token 失效
   * 用于登出
   *
   * @param userId 用户 ID
   */
  @Override
  public void removeToken(Integer userId) {
    redisTemplate.delete(userId);
  }
}
