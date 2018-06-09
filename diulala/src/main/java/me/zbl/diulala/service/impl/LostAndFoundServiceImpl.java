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

import me.zbl.diulala.entity.persistence.AppUser;
import me.zbl.diulala.entity.response.LostAndFoundResponse;
import me.zbl.diulala.repository.FindCaughterRepository;
import me.zbl.diulala.repository.FindLoserRepository;
import me.zbl.diulala.repository.UserRepository;
import me.zbl.diulala.service.LostAndFoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 丢失查找数量统计业务实现
 *
 * @author JamesZBL
 * @email 1146556298@qq.com
 * @date 2018-06-09
 */
@Service
public class LostAndFoundServiceImpl implements LostAndFoundService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private FindCaughterRepository findCaughterRepository;

  @Autowired
  private FindLoserRepository findLoserRepository;

  @Override
  public LostAndFoundResponse getLostAndFoundCount(String userid) {
    AppUser user = userRepository.findAppUserByOpenId(userid);
    Optional.ofNullable(user).orElseThrow(() -> new IllegalArgumentException("用户不存在"));
    Integer gotBackCount = findCaughterRepository.countAppFindCaughtersByAppUserByLoseUserAndFinished(user, (byte) 1);
    Integer returnCount = findLoserRepository.countAppFindLosersByAppUserByCaughtUserAndFinished(user, (byte) 1);
    return new LostAndFoundResponse(returnCount, gotBackCount);
  }
}
