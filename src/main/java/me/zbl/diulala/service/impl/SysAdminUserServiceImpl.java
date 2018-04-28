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

import me.zbl.diulala.entity.persistence.SysAdminUser;
import me.zbl.diulala.repository.SysAdminUserRepository;
import me.zbl.diulala.service.SysAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 管理员用户认证
 *
 * @author JamesZBL
 * @date 2018-04-17
 */
@Service
public class SysAdminUserServiceImpl implements SysAdminUserService {

  private SysAdminUserRepository adminRepo;

  @Autowired
  public SysAdminUserServiceImpl(SysAdminUserRepository adminRepo) {
    this.adminRepo = adminRepo;
  }

  @Override
  public boolean validateAdminUser(String username, String pwd) {
    Optional<SysAdminUser> adminUsers = adminRepo.findFirstByUsernameAndPassword(username, pwd);
    return adminUsers.isPresent();
  }
}
