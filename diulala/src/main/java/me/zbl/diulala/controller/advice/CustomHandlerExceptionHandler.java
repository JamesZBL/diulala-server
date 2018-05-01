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

import me.zbl.controller.base.R;
import me.zbl.diulala.exception.AuthFailedException;
import me.zbl.entity.response.MessageEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(value = AuthFailedException.class)
  public MessageEntity handleAuthException() {
    return R.fail("登录失败");
  }
}
