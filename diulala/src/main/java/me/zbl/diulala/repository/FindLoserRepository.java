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
package me.zbl.diulala.repository;

import me.zbl.diulala.entity.persistence.AppFindLoser;
import me.zbl.diulala.entity.persistence.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author JamesZBL
 * @date 2018-04-30
 */
@Repository
public interface FindLoserRepository extends CrudRepository<AppFindLoser, Integer> {

  /**
   * 根据唯一标识找物品
   *
   * @param identification 唯一标识
   */
  Collection<AppFindLoser> findAppFindLosersByIdentificationAndFinished(String identification, Byte finished);


  /**
   * 根据用户查询物品
   *
   * @param appUser 用户
   */
  Collection<AppFindLoser> findAppFindLosersByAppUserByCaughtUser(AppUser appUser);

  /**
   * 根据物品分类和唯一标识查找物品
   *
   * @param category       物品分类
   * @param identification 唯一标识
   */
  Collection<AppFindLoser> findAppFindLosersByCategoryAndIdentificationAndFinished(String category, String identification, Byte finished);
}
