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

import me.zbl.diulala.entity.persistence.AppQuestion;
import me.zbl.diulala.repository.QuestionRepository;
import me.zbl.diulala.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 问题答案业务实现
 *
 * @author JamesZBL
 * @date 2018-05-01
 */
@Service
public class QuestionServiceImpl implements QuestionService {

  @Autowired
  private QuestionRepository questionRepository;

  @Override
  public boolean checkAnswer(Integer questionId, String answer) {
    Optional<AppQuestion> find = questionRepository.findById(questionId);
    find.orElseThrow(() -> new IllegalArgumentException("题目不存在"));
    String right = find.get().getAnswer();
    return right.equals(answer);
  }
}
