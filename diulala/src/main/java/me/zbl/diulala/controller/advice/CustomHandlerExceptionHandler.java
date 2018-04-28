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
package me.zbl.diulala.controller.advice;

import me.zbl.entity.response.MessageEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.FailedLoginException;

/**
 * 异常处理
 *
 * @author JamesZBL
 * @date 2018-04-28
 */
@RestControllerAdvice
public class CustomHandlerExceptionHandler {

  private final String ERROR_MSG = "登录失败";

  /**
   * 小程序登录异常
   */
  @ExceptionHandler(value = FailedLoginException.class)
  public ResponseEntity<MessageEntity> handleAuthException() {
    return new ResponseEntity<>(new MessageEntity(ERROR_MSG), HttpStatus.UNAUTHORIZED);
  }
}
