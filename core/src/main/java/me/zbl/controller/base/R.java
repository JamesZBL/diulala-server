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

/**
 * 返回操作结果
 *
 * @author JamesZBL
 * @date 2018-04-30
 */
public class R {

  private static final String MSG_SUCCESS = "操作成功";
  private static final String MSG_FAILED = "操作失败";

  /**
   * 操作成功
   */
  public static MessageEntity success() {
    return new MessageEntity(MSG_SUCCESS);
  }

  /**
   * 操作成功
   *
   * @param msg 自定义消息
   */
  public static MessageEntity success(String msg) {
    return new MessageEntity(msg);
  }

  /**
   * 操作失败
   */
  public static MessageEntity fail() {
    return new MessageEntity(MSG_FAILED);
  }

  /**
   * 操作失败
   */
  public static MessageEntity fail(Exception e) {
    String es = e.getMessage();
    return new MessageEntity(es != null ? es : MSG_FAILED);
  }

  /**
   * 操作失败
   *
   * @param msg 自定义消息
   */
  public static MessageEntity fail(String msg) {
    return new MessageEntity(msg);
  }
}
