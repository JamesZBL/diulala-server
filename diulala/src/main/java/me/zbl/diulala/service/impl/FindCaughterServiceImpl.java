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
package me.zbl.diulala.service.impl;

import me.zbl.diulala.entity.persistence.AppFindCaughter;
import me.zbl.diulala.service.FindCaughterService;
import me.zbl.exception.FailOperationException;

import java.util.Collection;

/**
 * 找捡到的物品相关业务
 *
 * @author JamesZBL
 * @date 2018-05-01
 */
public class FindCaughterServiceImpl implements FindCaughterService {

  @Override
  public Collection<AppFindCaughter> findFindLoserByIdentification(String identification) {
    return null;
  }

  @Override
  public Collection<AppFindCaughter> findFindLoserByUser(String userId) {
    return null;
  }

  @Override
  public AppFindCaughter submitCaughtInfo(String userid, AppFindCaughter lost) throws FailOperationException {
    return null;
  }

  @Override
  public AppFindCaughter hasReturned(String userid, Integer lostId) throws FailOperationException {
    return null;
  }
}
