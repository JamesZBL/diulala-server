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
package me.zbl.controller.base;

import me.zbl.entity.response.MessageEntity;
import me.zbl.exception.EmptyResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = EmptyResultException.class)
  public MessageEntity handleResultEmptyException() {
    return new MessageEntity(MSG_EMPTY_RESULT);
  }
}
