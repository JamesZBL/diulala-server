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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 请求映射异常处理
 *
 * @author JamesZBL
 * @date 2018-04-19
 */
@RestControllerAdvice
public class HandlerExceptionHandler {

  private static final String MSG_NOT_FOUNT = "访问的资源不存在";
  private static final String MSG_ILLEGAL_ARGUMENT = "参数有误";

  /**
   * 无匹配请求映射
   */
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = NoHandlerFoundException.class)
  public MessageEntity handleNoHandlerFoundException(NoHandlerFoundException ex) {
    return new MessageEntity(MSG_NOT_FOUNT);
  }

  /**
   * 参数参数异常
   */
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(value = IllegalArgumentException.class)
  public MessageEntity handleIllegalArugumentException(IllegalArgumentException ex) {
    return new MessageEntity(MSG_ILLEGAL_ARGUMENT);
  }
}
