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
package me.zbl.diulala.entity.persistence;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author JamesZBL
 * @date 2018-04-29
 */
@Entity
@Table(name = "app_user", schema = "diulala", catalog = "")
public class AppUser {

  private String openId;
  private String nickName;
  private String unionId;
  private String avatarUrl;
  private String realName;
  private Byte gender;
  private String contactMethod;
  private String contactString;
  private String city;
  private String province;
  private String country;

  @Id
  @Column(name = "openId", nullable = false, length = 64)
  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  @Basic
  @Column(name = "nickName", nullable = false, length = 64)
  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  @Basic
  @Column(name = "unionId", nullable = true, length = 64)
  public String getUnionId() {
    return unionId;
  }

  public void setUnionId(String unionId) {
    this.unionId = unionId;
  }

  @Basic
  @Column(name = "avatarUrl", nullable = false, length = 255)
  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  @Basic
  @Column(name = "realName", nullable = true, length = 64)
  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  @Basic
  @Column(name = "gender", nullable = false)
  public Byte getGender() {
    return gender;
  }

  public void setGender(Byte gender) {
    this.gender = gender;
  }

  @Basic
  @Column(name = "contactMethod", nullable = false, length = 64)
  public String getContactMethod() {
    return contactMethod;
  }

  public void setContactMethod(String contactMethod) {
    this.contactMethod = contactMethod;
  }

  @Basic
  @Column(name = "contactString", nullable = false, length = 128)
  public String getContactString() {
    return contactString;
  }

  public void setContactString(String contactString) {
    this.contactString = contactString;
  }

  @Basic
  @Column(name = "city", nullable = false, length = 64)
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Basic
  @Column(name = "province", nullable = false, length = 64)
  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  @Basic
  @Column(name = "country", nullable = false, length = 64)
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AppUser appUser = (AppUser) o;
    return Objects.equals(openId, appUser.openId) &&
            Objects.equals(nickName, appUser.nickName) &&
            Objects.equals(unionId, appUser.unionId) &&
            Objects.equals(avatarUrl, appUser.avatarUrl) &&
            Objects.equals(realName, appUser.realName) &&
            Objects.equals(gender, appUser.gender) &&
            Objects.equals(contactMethod, appUser.contactMethod) &&
            Objects.equals(contactString, appUser.contactString) &&
            Objects.equals(city, appUser.city) &&
            Objects.equals(province, appUser.province) &&
            Objects.equals(country, appUser.country);
  }

  @Override
  public int hashCode() {

    return Objects.hash(openId, nickName, unionId, avatarUrl, realName, gender, contactMethod, contactString, city, province, country);
  }
}
