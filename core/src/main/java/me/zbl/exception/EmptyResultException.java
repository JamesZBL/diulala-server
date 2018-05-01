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
package me.zbl.exception;

/**
 * 查询结果空异常
 *
 * @author JamesZBL
 * @date 2018-04-19
 */
public class EmptyResultException extends IllegalStateException {

  public EmptyResultException() {
  }

  public EmptyResultException(String s) {
    super(s);
  }

  public EmptyResultException(String message, Throwable cause) {
    super(message, cause);
  }

  public EmptyResultException(Throwable cause) {
    super(cause);
  }
}
