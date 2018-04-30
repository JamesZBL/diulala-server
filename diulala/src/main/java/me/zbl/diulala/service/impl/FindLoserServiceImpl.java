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

import me.zbl.diulala.entity.persistence.AppFindLoser;
import me.zbl.diulala.entity.persistence.AppUser;
import me.zbl.diulala.repository.FindLoserRepository;
import me.zbl.diulala.service.FindLoserService;
import me.zbl.diulala.service.UserService;
import me.zbl.exception.FailOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

/**
 * 找失主业务实现
 *
 * @author JamesZBL
 * @date 2018-04-30
 */
@Service
public class FindLoserServiceImpl implements FindLoserService {

  @Autowired
  private FindLoserRepository findLoserRepository;

  @Autowired
  private UserService userService;

  @Override
  public Collection<AppFindLoser> findFindLoserByIdentification(String identification) {
    return findLoserRepository.findAppFindLosersByIdentification(identification);
  }

  @Override
  @Transactional
  public AppFindLoser submitCaughtInfo(String userid, AppFindLoser lost) throws FailOperationException {
    Optional<AppUser> user = userService.findUser(userid);
    if (!user.isPresent()) {
      throw new IllegalArgumentException();
    }
    lost.setAppUserByCaughtUser(user.get());
    AppFindLoser result = null;
    try {
      result = findLoserRepository.save(lost);
    } catch (Exception e) {
      e.printStackTrace();
      throw new FailOperationException();
    }
    return result;
  }
}
