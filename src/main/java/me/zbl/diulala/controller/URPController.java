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
package me.zbl.diulala.controller;

import me.zbl.diulala.controller.base.BaseController;
import me.zbl.diulala.service.UrpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * URP Info controller
 * <p>
 * <p>
 * 关于 分页和排序的请求参数格式：
 * 1.分页：page=0（默认为 0，即首页）,size=20（默认每页 20 条数据）
 * 2.排序：sort=gkScore,XXX,XXX,ASC|DESC（默认为 ASC）
 * <p>
 * 注意：Repository 中参数不能同时出现 Pageable 和 Sort，Pageable 包含了排序功能
 *
 * @author JamesZBL
 * @date 2018-04-01
 */
@RestController
@CrossOrigin
public class URPController extends BaseController {

  private final UrpInfoService mService;

  @Autowired
  public URPController(UrpInfoService mService) {
    this.mService = mService;
  }

  /**
   * 根据学号模糊匹配
   * 只匹配以 studId 开头的学号
   *
   * @param stuId 学号
   */
  @GetMapping("/id/{keywords}")
  public ResponseEntity getInfoByStuId(Pageable pageable, @PathVariable("keywords") String stuId) {
    return wrapData(mService.getInfoByStuId(pageable, stuId));
  }

  /**
   * 根据姓名模糊匹配
   *
   * @param name 姓名
   */
  @GetMapping("/name/{keywords}")
  public ResponseEntity getInfoByName(Pageable pageable, @PathVariable("keywords") String name) {
    return wrapData(mService.getInfoByName(pageable, name));
  }

  /**
   * 根据家乡模糊匹配
   *
   * @param home 家乡
   */
  @GetMapping("/hometown/{keywords}")
  public ResponseEntity getInfoByHometown(Pageable pageable, @PathVariable("keywords") String home) {
    return wrapData(mService.getInfoByAddress(pageable, home));
  }

  /**
   * 根据区划和校名模糊匹配
   *
   * @param school 校名
   */
  @GetMapping("/school/{keywords}")
  public ResponseEntity getInfoBySchool(Pageable pageable, @PathVariable(value = "keywords") String school) {
    return wrapData(mService.getInfoBySchool(pageable, school));
  }
}
