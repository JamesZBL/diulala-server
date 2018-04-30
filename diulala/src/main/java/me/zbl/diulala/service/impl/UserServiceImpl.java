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

import me.zbl.diulala.entity.persistence.AppUser;
import me.zbl.diulala.repository.UserRepository;
import me.zbl.diulala.service.UserService;
import me.zbl.exception.FailOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 用户服务实现
 *
 * @author JamesZBL
 * @date 2018-04-29
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepo;

  @Override
  public boolean existUser(String userid) {
    Optional<AppUser> user = userRepo.findById(userid);
    return user.isPresent();
  }

  @Override
  public Optional<AppUser> findUser(String userid) {
    return userRepo.findById(userid);
  }

  @Override
  public AppUser fullFillUserInfo(AppUser appUser) throws FailOperationException {
    AppUser result = null;
    try {
      result = userRepo.save(appUser);
    } catch (Exception e) {
      throw new FailOperationException();
    }
    return result;
  }

  @Override
  public AppUser updateUserInfo(AppUser appUser) throws FailOperationException {
    try {
      return userRepo.save(appUser);
    } catch (Exception e) {
      e.printStackTrace();
      throw new FailOperationException();
    }
  }
}
