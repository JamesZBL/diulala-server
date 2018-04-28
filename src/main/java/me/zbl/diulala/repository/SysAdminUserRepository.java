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

import me.zbl.diulala.entity.persistence.SysAdminUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * 管理员用户 repo
 *
 * @author JamesZBL
 * @date 2018-04-17
 */
public interface SysAdminUserRepository extends CrudRepository<SysAdminUser, Integer> {

  @Query(value = "SELECT * FROM sys_admin_user WHERE USERNAME = ?1 AND PASSWORD=MD5(?2)", nativeQuery = true)
  Optional<SysAdminUser> findFirstByUsernameAndPassword(String username, String pwd);
}
