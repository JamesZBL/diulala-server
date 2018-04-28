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
package me.zbl.urpsearchengine.controller.base;

import me.zbl.urpsearchengine.entity.response.MessageEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 错误消息返回
 *
 * @author JamesZBL
 * @date 2018-04-19
 */
@RestController
public class ErrorMsgController {

  private static final String MSG_INTERNAL_ERROR = "服务器错误";

  @GetMapping("/error")
  public MessageEntity error() {
    return new MessageEntity(MSG_INTERNAL_ERROR);
  }
}
