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
import java.util.Objects;

/**
 * @author JamesZBL
 * @date 2018-05-01
 */
@ApiModel
@Entity
@Table(name = "app_question", schema = "diulala", catalog = "")
public class AppQuestion {

  private Integer id;
  @ApiModelProperty(value = "题目")
  private String question;
  @ApiModelProperty(value = "答案")
  private String answer;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Basic
  @Column(name = "question")
  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  @Basic
  @Column(name = "answer")
  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AppQuestion that = (AppQuestion) o;
    return Objects.equals(id, that.id) &&
            Objects.equals(question, that.question) &&
            Objects.equals(answer, that.answer);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, question, answer);
  }
}
