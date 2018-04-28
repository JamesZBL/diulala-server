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
package me.zbl.urpsearchengine.entity.persistence;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author JamesZBL
 * @date 2018-04-17
 */
@Entity
@Table(name = "sys_user", schema = "urp_search_engine", catalog = "")
public class SysUser {

  private int id;
  private String username;
  private String password;

  @Id
  @Column(name = "ID")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "USERNAME")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Basic
  @Column(name = "PASSWORD")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SysUser sysUser = (SysUser) o;
    return id == sysUser.id &&
            Objects.equals(username, sysUser.username) &&
            Objects.equals(password, sysUser.password);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, username, password);
  }
}
