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
import me.zbl.diulala.entity.persistence.AppUser;
import me.zbl.diulala.repository.FindCaughterRepository;
import me.zbl.diulala.service.FindCaughterService;
import me.zbl.diulala.service.UserService;
import me.zbl.exception.EmptyResultException;
import me.zbl.exception.FailOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * 找捡到的物品相关业务
 *
 * @author JamesZBL
 * @date 2018-05-01
 */
@Service
public class FindCaughterServiceImpl implements FindCaughterService {

  @Autowired
  private UserService userService;

  @Autowired
  private FindCaughterRepository findCaughterRepository;

  @Override
  public Collection<AppFindCaughter> findFindCaughterByIdentification(String identification) {
    return findCaughterRepository.
            findAppFindCaughtersByIdentificationAndFinished(identification, (byte) 0);
  }

  @Override
  public Collection<AppFindCaughter> findFindCaughterByCategoryAndIdentification(
          String category, String identification) {
    return findCaughterRepository.findAppFindCaughtersByCategoryAndIdentificationAndFinished(
            category,
            identification, (byte) 0
    );
  }

  @Override
  public Collection<AppFindCaughter> findFindCaughterByUser(String userId) {
    Optional<AppUser> user = userService.findUser(userId);
    user.orElseThrow(() -> new IllegalArgumentException("用户不存在"));
    return findCaughterRepository.findAppFindCaughtersByAppUserByLoseUser(user.get());
  }

  @Override
  public AppFindCaughter submitLoseInfo(
          String userid, AppFindCaughter lost) throws FailOperationException {
    Optional<AppUser> user = userService.findUser(userid);
    user.orElseThrow(() -> new IllegalArgumentException("用户不存在"));
    lost.setAppUserByLoseUser(user.get());
    AppFindCaughter result = null;
    try {
      result = findCaughterRepository.save(lost);
    } catch (Exception e) {
      e.printStackTrace();
      throw new FailOperationException();
    }
    return result;
  }

  @Override
  public AppFindCaughter hasGot(String userid, Integer lostId) throws FailOperationException {
    Optional<AppFindCaughter> find = findCaughterRepository.findById(lostId);
    find.orElseThrow(EmptyResultException::new);
    AppFindCaughter ori = find.get();
    if (!ori.getAppUserByLoseUser().getOpenId().equals(userid)) {
      throw new IllegalArgumentException("该物品非本用户提交");
    }
    ori.setFinished((byte) 1);
    AppFindCaughter save = null;
    try {
      save = findCaughterRepository.save(ori);
    } catch (Exception e) {
      e.printStackTrace();
      throw new FailOperationException();
    }
    return save;
  }
}
