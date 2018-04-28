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
package me.zbl.urpsearchengine.service.impl;

import me.zbl.urpsearchengine.entity.persistence.UrpInfoHebust;
import me.zbl.urpsearchengine.repository.URPInfoRepository;
import me.zbl.urpsearchengine.service.QiniuFileService;
import me.zbl.urpsearchengine.service.UrpInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * 学籍信息搜索
 * <p>
 * 1. 查学号
 * 2. 查姓名
 * 3. 查地址
 * 4. 查中学
 *
 * @author JamesZBL
 * @date 2018-04-09
 */
@Service
public class UrpInfoServiceImpl implements UrpInfoService {

  private final URPInfoRepository mRepo;
  private final QiniuFileService mQiniuService;

  @Autowired
  public UrpInfoServiceImpl(URPInfoRepository mRepo, QiniuFileService mQiniuService) {
    this.mRepo = mRepo;
    this.mQiniuService = mQiniuService;
  }

  @Override
  public Page<UrpInfoHebust> getInfoByStuId(Pageable pageable, String stuId) {
    Page<UrpInfoHebust> stus = mRepo.findByStuid(stuId, pageable);
    mQiniuService.buildImageUrl(stus);
    return stus;
  }

  @Override
  public Page<UrpInfoHebust> getInfoByName(Pageable pageable, String name) {
    Page<UrpInfoHebust> stus = mRepo.findByName(name, pageable);
    mQiniuService.buildImageUrl(stus);
    return stus;
  }

  @Override
  public Page<UrpInfoHebust> getInfoByAddress(Pageable pageable, String address) {
    Page<UrpInfoHebust> stus = mRepo.findByHometown(address, pageable);
    mQiniuService.buildImageUrl(stus);
    return stus;
  }

  @Override
  public Page<UrpInfoHebust> getInfoBySchool(Pageable pageable, String school) {
    String[] split = school.split("");
    String join = StringUtils.join(split, "%");
    Page<UrpInfoHebust> stus = mRepo.findBySchool(join, pageable);
    mQiniuService.buildImageUrl(stus);
    return stus;
  }
}
