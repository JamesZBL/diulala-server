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
import me.zbl.exception.FailOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;


/**
 * 数据异常处理
 *
 * @author JamesZBL
 * @date 2018-04-19
 */
@RestControllerAdvice
public class ResultExceptionHandler {

  private static final String MSG_EMPTY_RESULT = "未找到结果";
  private static final String MSG_BIND_ERROR = "参数不合法";

  /**
   * 查询结果为空异常处理
   */
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = EmptyResultException.class)
  public MessageEntity handleResultEmptyException(Exception ex) {
    Optional<String> em = Optional.ofNullable(ex.getMessage());
    return R.fail(em.orElse(MSG_EMPTY_RESULT));
  }

  /**
   * 参数绑定异常
   */
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = BindException.class)
  public MessageEntity handleBindException(Exception ex) {
    Optional<String> em = Optional.ofNullable(ex.getMessage());
    return R.fail(em.orElse(MSG_BIND_ERROR));
  }

  /**
   * 操作失败异常
   */
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = FailOperationException.class)
  public MessageEntity handleFailOperationException(Exception ex) {
    return R.fail(ex);
  }
}
