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
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author JamesZBL
 * @date 2018-05-01
 */
@Entity
@Table(name = "app_find_caughter", schema = "diulala", catalog = "")
public class AppFindCaughter {

  private Integer id;
  private String category;
  private String name;
  private String identification;
  private BigDecimal longitude;
  private BigDecimal latitude;
  private String poi;
  private String description;
  private Byte finished;
  private BigDecimal money;
  private Timestamp gmtCreated;
  private Timestamp gmtModified;
  private AppUser appUserByLoseUser;

  @Id
  @Column(name = "id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "category")
  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "identification")
  public String getIdentification() {
    return identification;
  }

  public void setIdentification(String identification) {
    this.identification = identification;
  }

  @Basic
  @Column(name = "longitude")
  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  @Basic
  @Column(name = "latitude")
  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  @Basic
  @Column(name = "poi")
  public String getPoi() {
    return poi;
  }

  public void setPoi(String poi) {
    this.poi = poi;
  }

  @Basic
  @Column(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Basic
  @Column(name = "finished", insertable = false)
  public Byte getFinished() {
    return finished;
  }

  public void setFinished(Byte finished) {
    this.finished = finished;
  }

  @Basic
  @Column(name = "money")
  public BigDecimal getMoney() {
    return money;
  }

  public void setMoney(BigDecimal money) {
    this.money = money;
  }

  @Basic
  @Column(name = "gmt_created", insertable = false, updatable = false)
  public Timestamp getGmtCreated() {
    return gmtCreated;
  }

  public void setGmtCreated(Timestamp gmtCreated) {
    this.gmtCreated = gmtCreated;
  }

  @Basic
  @Column(name = "gmt_modified", insertable = false, updatable = false)
  public Timestamp getGmtModified() {
    return gmtModified;
  }

  public void setGmtModified(Timestamp gmtModified) {
    this.gmtModified = gmtModified;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AppFindCaughter that = (AppFindCaughter) o;
    return Objects.equals(id, that.id) &&
            Objects.equals(category, that.category) &&
            Objects.equals(name, that.name) &&
            Objects.equals(identification, that.identification) &&
            Objects.equals(longitude, that.longitude) &&
            Objects.equals(latitude, that.latitude) &&
            Objects.equals(poi, that.poi) &&
            Objects.equals(description, that.description) &&
            Objects.equals(finished, that.finished) &&
            Objects.equals(money, that.money) &&
            Objects.equals(gmtCreated, that.gmtCreated) &&
            Objects.equals(gmtModified, that.gmtModified);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, category, name, identification, longitude, latitude, poi, description, finished, money, gmtCreated, gmtModified);
  }

  @ManyToOne
  @JoinColumn(name = "lose_user", referencedColumnName = "open_id", nullable = false)
  public AppUser getAppUserByLoseUser() {
    return appUserByLoseUser;
  }

  public void setAppUserByLoseUser(AppUser appUserByLoseUser) {
    this.appUserByLoseUser = appUserByLoseUser;
  }
}
