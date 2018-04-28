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
 * URP Info
 *
 * @author JamesZBL
 * @date 2018-04-01
 */
@Entity
@Table(name = "urp_info_hebust", schema = "urp_roll_info", catalog = "")
public class UrpInfoHebust implements Cloneable {

  private String stuid;
  private String name;
  private String namePy;
  private String nameEn;
  private String nameOld;
  private String icid;
  private String gender;
  private String stuCategory;
  private String specialCategory;
  private String schoolRollStatus;
  private String feeCategory;
  private String nation;
  private String birthPlace;
  private String birthDate;
  private String politicsStatus;
  private String examRegion;
  private String graduateSchool;
  private String gkScore;
  private String matriculateId;
  private String gkId;
  private String gkLanguage;
  private String contactAddress;
  private String postcode;
  private String patriarchInfo;
  private String enrollmentDate;
  private String department;
  private String major;
  private String majorDirection;
  private String grade;
  private String clazz;
  private String hasRoll;
  private String hasNationalRoll;
  private String schoolPart;
  private String transaction;
  private String foreignLanguage;
  private String dormAddress;
  private String ycsj;
  private String trainLevel;
  private String trainPattern;
  private String shuntDirection;
  private String leaveSchool;
  private String comment;
  private String comment1;
  private String comment2;
  private String comment3;
  @Transient
  private String imgUrl;

  @Id
  @Column(name = "STUID")
  public String getStuid() {
    return stuid;
  }

  public void setStuid(String stuid) {
    this.stuid = stuid;
  }

  @Basic
  @Column(name = "NAME")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "NAME_PY")
  public String getNamePy() {
    return namePy;
  }

  public void setNamePy(String namePy) {
    this.namePy = namePy;
  }

  @Basic
  @Column(name = "NAME_EN")
  public String getNameEn() {
    return nameEn;
  }

  public void setNameEn(String nameEn) {
    this.nameEn = nameEn;
  }

  @Basic
  @Column(name = "NAME_OLD")
  public String getNameOld() {
    return nameOld;
  }

  public void setNameOld(String nameOld) {
    this.nameOld = nameOld;
  }

  @Basic
  @Column(name = "ICID")
  public String getIcid() {
    return icid;
  }

  public void setIcid(String icid) {
    this.icid = icid;
  }

  @Basic
  @Column(name = "GENDER")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Basic
  @Column(name = "STU_CATEGORY")
  public String getStuCategory() {
    return stuCategory;
  }

  public void setStuCategory(String stuCategory) {
    this.stuCategory = stuCategory;
  }

  @Basic
  @Column(name = "SPECIAL_CATEGORY")
  public String getSpecialCategory() {
    return specialCategory;
  }

  public void setSpecialCategory(String specialCategory) {
    this.specialCategory = specialCategory;
  }

  @Basic
  @Column(name = "SCHOOL_ROLL_STATUS")
  public String getSchoolRollStatus() {
    return schoolRollStatus;
  }

  public void setSchoolRollStatus(String schoolRollStatus) {
    this.schoolRollStatus = schoolRollStatus;
  }

  @Basic
  @Column(name = "FEE_CATEGORY")
  public String getFeeCategory() {
    return feeCategory;
  }

  public void setFeeCategory(String feeCategory) {
    this.feeCategory = feeCategory;
  }

  @Basic
  @Column(name = "NATION")
  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  @Basic
  @Column(name = "BIRTH_PLACE")
  public String getBirthPlace() {
    return birthPlace;
  }

  public void setBirthPlace(String birthPlace) {
    this.birthPlace = birthPlace;
  }

  @Basic
  @Column(name = "BIRTH_DATE")
  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  @Basic
  @Column(name = "POLITICS_STATUS")
  public String getPoliticsStatus() {
    return politicsStatus;
  }

  public void setPoliticsStatus(String politicsStatus) {
    this.politicsStatus = politicsStatus;
  }

  @Basic
  @Column(name = "EXAM_REGION")
  public String getExamRegion() {
    return examRegion;
  }

  public void setExamRegion(String examRegion) {
    this.examRegion = examRegion;
  }

  @Basic
  @Column(name = "GRADUATE_SCHOOL")
  public String getGraduateSchool() {
    return graduateSchool;
  }

  public void setGraduateSchool(String graduateSchool) {
    this.graduateSchool = graduateSchool;
  }

  @Basic
  @Column(name = "GK_SCORE")
  public String getGkScore() {
    return gkScore;
  }

  public void setGkScore(String gkScore) {
    this.gkScore = gkScore;
  }

  @Basic
  @Column(name = "MATRICULATE_ID")
  public String getMatriculateId() {
    return matriculateId;
  }

  public void setMatriculateId(String matriculateId) {
    this.matriculateId = matriculateId;
  }

  @Basic
  @Column(name = "GK_ID")
  public String getGkId() {
    return gkId;
  }

  public void setGkId(String gkId) {
    this.gkId = gkId;
  }

  @Basic
  @Column(name = "GK_LANGUAGE")
  public String getGkLanguage() {
    return gkLanguage;
  }

  public void setGkLanguage(String gkLanguage) {
    this.gkLanguage = gkLanguage;
  }

  @Basic
  @Column(name = "CONTACT_ADDRESS")
  public String getContactAddress() {
    return contactAddress;
  }

  public void setContactAddress(String contactAddress) {
    this.contactAddress = contactAddress;
  }

  @Basic
  @Column(name = "POSTCODE")
  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  @Basic
  @Column(name = "PATRIARCH_INFO")
  public String getPatriarchInfo() {
    return patriarchInfo;
  }

  public void setPatriarchInfo(String patriarchInfo) {
    this.patriarchInfo = patriarchInfo;
  }

  @Basic
  @Column(name = "ENROLLMENT_DATE")
  public String getEnrollmentDate() {
    return enrollmentDate;
  }

  public void setEnrollmentDate(String enrollmentDate) {
    this.enrollmentDate = enrollmentDate;
  }

  @Basic
  @Column(name = "DEPARTMENT")
  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  @Basic
  @Column(name = "MAJOR")
  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  @Basic
  @Column(name = "MAJOR_DIRECTION")
  public String getMajorDirection() {
    return majorDirection;
  }

  public void setMajorDirection(String majorDirection) {
    this.majorDirection = majorDirection;
  }

  @Basic
  @Column(name = "GRADE")
  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  @Basic
  @Column(name = "CLASS")
  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  @Basic
  @Column(name = "HAS_ROLL")
  public String getHasRoll() {
    return hasRoll;
  }

  public void setHasRoll(String hasRoll) {
    this.hasRoll = hasRoll;
  }

  @Basic
  @Column(name = "HAS_NATIONAL_ROLL")
  public String getHasNationalRoll() {
    return hasNationalRoll;
  }

  public void setHasNationalRoll(String hasNationalRoll) {
    this.hasNationalRoll = hasNationalRoll;
  }

  @Basic
  @Column(name = "SCHOOL_PART")
  public String getSchoolPart() {
    return schoolPart;
  }

  public void setSchoolPart(String schoolPart) {
    this.schoolPart = schoolPart;
  }

  @Basic
  @Column(name = "TRANSACTION")
  public String getTransaction() {
    return transaction;
  }

  public void setTransaction(String transaction) {
    this.transaction = transaction;
  }

  @Basic
  @Column(name = "FOREIGN_LANGUAGE")
  public String getForeignLanguage() {
    return foreignLanguage;
  }

  public void setForeignLanguage(String foreignLanguage) {
    this.foreignLanguage = foreignLanguage;
  }

  @Basic
  @Column(name = "DORM_ADDRESS")
  public String getDormAddress() {
    return dormAddress;
  }

  public void setDormAddress(String dormAddress) {
    this.dormAddress = dormAddress;
  }

  @Basic
  @Column(name = "YCSJ")
  public String getYcsj() {
    return ycsj;
  }

  public void setYcsj(String ycsj) {
    this.ycsj = ycsj;
  }

  @Basic
  @Column(name = "TRAIN_LEVEL")
  public String getTrainLevel() {
    return trainLevel;
  }

  public void setTrainLevel(String trainLevel) {
    this.trainLevel = trainLevel;
  }

  @Basic
  @Column(name = "TRAIN_PATTERN")
  public String getTrainPattern() {
    return trainPattern;
  }

  public void setTrainPattern(String trainPattern) {
    this.trainPattern = trainPattern;
  }

  @Basic
  @Column(name = "SHUNT_DIRECTION")
  public String getShuntDirection() {
    return shuntDirection;
  }

  public void setShuntDirection(String shuntDirection) {
    this.shuntDirection = shuntDirection;
  }

  @Basic
  @Column(name = "LEAVE_SCHOOL")
  public String getLeaveSchool() {
    return leaveSchool;
  }

  public void setLeaveSchool(String leaveSchool) {
    this.leaveSchool = leaveSchool;
  }

  @Basic
  @Column(name = "COMMENT")
  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  @Basic
  @Column(name = "COMMENT1")
  public String getComment1() {
    return comment1;
  }

  public void setComment1(String comment1) {
    this.comment1 = comment1;
  }

  @Basic
  @Column(name = "COMMENT2")
  public String getComment2() {
    return comment2;
  }

  public void setComment2(String comment2) {
    this.comment2 = comment2;
  }

  @Basic
  @Column(name = "COMMENT3")
  public String getComment3() {
    return comment3;
  }

  public void setComment3(String comment3) {
    this.comment3 = comment3;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UrpInfoHebust that = (UrpInfoHebust) o;
    return Objects.equals(stuid, that.stuid) &&
            Objects.equals(name, that.name) &&
            Objects.equals(namePy, that.namePy) &&
            Objects.equals(nameEn, that.nameEn) &&
            Objects.equals(nameOld, that.nameOld) &&
            Objects.equals(icid, that.icid) &&
            Objects.equals(gender, that.gender) &&
            Objects.equals(stuCategory, that.stuCategory) &&
            Objects.equals(specialCategory, that.specialCategory) &&
            Objects.equals(schoolRollStatus, that.schoolRollStatus) &&
            Objects.equals(feeCategory, that.feeCategory) &&
            Objects.equals(nation, that.nation) &&
            Objects.equals(birthPlace, that.birthPlace) &&
            Objects.equals(birthDate, that.birthDate) &&
            Objects.equals(politicsStatus, that.politicsStatus) &&
            Objects.equals(examRegion, that.examRegion) &&
            Objects.equals(graduateSchool, that.graduateSchool) &&
            Objects.equals(gkScore, that.gkScore) &&
            Objects.equals(matriculateId, that.matriculateId) &&
            Objects.equals(gkId, that.gkId) &&
            Objects.equals(gkLanguage, that.gkLanguage) &&
            Objects.equals(contactAddress, that.contactAddress) &&
            Objects.equals(postcode, that.postcode) &&
            Objects.equals(patriarchInfo, that.patriarchInfo) &&
            Objects.equals(enrollmentDate, that.enrollmentDate) &&
            Objects.equals(department, that.department) &&
            Objects.equals(major, that.major) &&
            Objects.equals(majorDirection, that.majorDirection) &&
            Objects.equals(grade, that.grade) &&
            Objects.equals(clazz, that.clazz) &&
            Objects.equals(hasRoll, that.hasRoll) &&
            Objects.equals(hasNationalRoll, that.hasNationalRoll) &&
            Objects.equals(schoolPart, that.schoolPart) &&
            Objects.equals(transaction, that.transaction) &&
            Objects.equals(foreignLanguage, that.foreignLanguage) &&
            Objects.equals(dormAddress, that.dormAddress) &&
            Objects.equals(ycsj, that.ycsj) &&
            Objects.equals(trainLevel, that.trainLevel) &&
            Objects.equals(trainPattern, that.trainPattern) &&
            Objects.equals(shuntDirection, that.shuntDirection) &&
            Objects.equals(leaveSchool, that.leaveSchool) &&
            Objects.equals(comment, that.comment) &&
            Objects.equals(comment1, that.comment1) &&
            Objects.equals(comment2, that.comment2) &&
            Objects.equals(comment3, that.comment3);
  }

  @Override
  public int hashCode() {

    return Objects.hash(stuid, name, namePy, nameEn, nameOld, icid, gender, stuCategory, specialCategory, schoolRollStatus, feeCategory, nation, birthPlace, birthDate, politicsStatus, examRegion, graduateSchool, gkScore, matriculateId, gkId, gkLanguage, contactAddress, postcode, patriarchInfo, enrollmentDate, department, major, majorDirection, grade, clazz, hasRoll, hasNationalRoll, schoolPart, transaction, foreignLanguage, dormAddress, ycsj, trainLevel, trainPattern, shuntDirection, leaveSchool, comment, comment1, comment2, comment3);
  }

  @Transient
  public String getImgUrl() {
    return imgUrl;
  }

  @Transient
  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }
}
