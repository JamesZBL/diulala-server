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

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

/**
 * @author JamesZBL
 * @date 2018-04-30
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
  @JsonIgnore
  private Collection<AppFindLoser> appFindLosersByOpenId;

  @Id
  @Column(name = "open_id")
  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  @Basic
  @Column(name = "nick_name")
  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  @Basic
  @Column(name = "union_id")
  public String getUnionId() {
    return unionId;
  }

  public void setUnionId(String unionId) {
    this.unionId = unionId;
  }

  @Basic
  @Column(name = "avatar_url")
  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  @Basic
  @Column(name = "real_name")
  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  @Basic
  @Column(name = "gender")
  public Byte getGender() {
    return gender;
  }

  public void setGender(Byte gender) {
    this.gender = gender;
  }

  @Basic
  @Column(name = "contact_method")
  public String getContactMethod() {
    return contactMethod;
  }

  public void setContactMethod(String contactMethod) {
    this.contactMethod = contactMethod;
  }

  @Basic
  @Column(name = "contact_string")
  public String getContactString() {
    return contactString;
  }

  public void setContactString(String contactString) {
    this.contactString = contactString;
  }

  @Basic
  @Column(name = "city")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Basic
  @Column(name = "province")
  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  @Basic
  @Column(name = "country")
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

  @OneToMany(mappedBy = "appUserByCaughtUser")
  public Collection<AppFindLoser> getAppFindLosersByOpenId() {
    return appFindLosersByOpenId;
  }

  public void setAppFindLosersByOpenId(Collection<AppFindLoser> appFindLosersByOpenId) {
    this.appFindLosersByOpenId = appFindLosersByOpenId;
  }
}
