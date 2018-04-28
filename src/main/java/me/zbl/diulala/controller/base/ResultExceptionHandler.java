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
package me.zbl.diulala.controller.base;

import me.zbl.diulala.entity.response.MessageEntity;
import me.zbl.diulala.exception.EmptyResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 数据异常处理
 *
 * @author JamesZBL
 * @date 2018-04-19
 */
@RestControllerAdvice
public class ResultExceptionHandler {

  private static final String MSG_EMPTY_RESULT = "未找到结果";

  /**
   * 查询结果为空异常处理
   */
  @ExceptionHandler(value = EmptyResultException.class)
  public ResponseEntity<MessageEntity> handleResultEmptyException() {
    return new ResponseEntity<>(new MessageEntity(MSG_EMPTY_RESULT), HttpStatus.NOT_FOUND);
  }
}
