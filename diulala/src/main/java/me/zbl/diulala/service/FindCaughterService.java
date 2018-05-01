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

import me.zbl.diulala.entity.persistence.AppFindCaughter;
import me.zbl.exception.FailOperationException;

import java.util.Collection;

/**
 * 丢失物品相关业务
 *
 * @author JamesZBL
 * @date 2018-05-01
 */
public interface FindCaughterService {

  /**
   * 根据唯一标识查找物品
   */
  Collection<AppFindCaughter> findFindCaughterByIdentification(String identification);

  /**
   * 根据用户查找物品
   *
   * @param userId 用户 openId
   */
  Collection<AppFindCaughter> findFindCaughterByUser(String userId);

  /**
   * @param userid 用户 openId
   * @param lost   丢失物品的信息
   */
  AppFindCaughter submitLoseInfo(String userid, AppFindCaughter lost) throws FailOperationException;

  /**
   * 已经找到物品，更新物品信息，更新后不会再被匹配到
   *
   * @param userid 用户 openId
   * @param lostId 丢失物品 id
   */
  AppFindCaughter hasGot(String userid, Integer lostId) throws FailOperationException;
}
