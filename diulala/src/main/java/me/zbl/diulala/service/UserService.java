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
package me.zbl.diulala.service;

import me.zbl.diulala.entity.persistence.AppUser;
import me.zbl.exception.FailOperationException;

import java.util.Optional;

/**
 * 用户服务
 *
 * @author JamesZBL
 * @date 2018-04-29
 */
public interface UserService {

  /**
   * 查询用户是否存在
   *
   * @param userid 微信平台 openId
   */
  boolean existUser(String userid);

  /**
   * 根据 openId 查询用户
   *
   * @param userid openId
   *
   * @return AppUser
   */
  Optional<AppUser> findUser(String userid);

  /**
   * 完善用户信息
   *
   * @param appUser app 用户
   */
  AppUser fullFillUserInfo(AppUser appUser) throws FailOperationException;

  /**
   * 修改用户信息
   *
   * @param appUser app 用户
   */
  AppUser updateUserInfo(AppUser appUser) throws FailOperationException;
}
