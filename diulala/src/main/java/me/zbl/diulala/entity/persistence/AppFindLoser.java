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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * 失物招领信息
 *
 * @author JamesZBL
 * @date 2018-04-30
 */
@ApiModel
@Entity
@Table(name = "app_find_loser", schema = "diulala", catalog = "")
public class AppFindLoser {

  private Integer id;
  private AppUser appUserByCaughtUser;
  @ApiModelProperty(value = "物品分类")
  private String category;
  @ApiModelProperty(value = "物品名称")
  private String name;
  @ApiModelProperty(value = "唯一标识")
  private String identification;
  @ApiModelProperty(value = "经度")
  private BigDecimal longitude;
  @ApiModelProperty(value = "纬度")
  private BigDecimal latitude;
  @ApiModelProperty(value = "POI")
  private String poi;
  @ApiModelProperty(value = "描述")
  private String description;
  @ApiModelProperty(value = "是否归还")
  private Byte finished;
  @ApiModelProperty(value = "问题")
  private AppQuestion appQuestionByQuestion;
  @ApiModelProperty(value = "提交时间")
  private Timestamp gmtCreated;
  @ApiModelProperty(value = "最后修改时间")
  private Timestamp gmtModified;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AppFindLoser that = (AppFindLoser) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id);
  }

  @ManyToOne
  @JoinColumn(name = "caught_user", referencedColumnName = "open_id")
  public AppUser getAppUserByCaughtUser() {
    return appUserByCaughtUser;
  }

  public void setAppUserByCaughtUser(AppUser appUserByCaughtUser) {
    this.appUserByCaughtUser = appUserByCaughtUser;
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
  @Column(name = "finished", insertable = false)
  public Byte getFinished() {
    return finished;
  }

  public void setFinished(Byte finished) {
    this.finished = finished;
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

  @ManyToOne
  @JoinColumn(name = "question")
  public AppQuestion getAppQuestionByQuestion() {
    return appQuestionByQuestion;
  }

  public void setAppQuestionByQuestion(AppQuestion appQuestionByQuestion) {
    this.appQuestionByQuestion = appQuestionByQuestion;
  }
}
