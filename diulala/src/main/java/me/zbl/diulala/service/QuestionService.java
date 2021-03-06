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
package me.zbl.diulala.service;

/**
 * 问题答案相关业务
 *
 * @author JamesZBL
 * @date 2018-05-01
 */
public interface QuestionService {

  /**
   * 检查回答是否正确
   *
   * @param questionId 问题 id
   * @param answer     回答内容
   */
  boolean checkAnswer(Integer questionId, String answer);
}
