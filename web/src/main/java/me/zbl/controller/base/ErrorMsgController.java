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
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 错误消息返回
 *
 * @author JamesZBL
 * @date 2018-04-19
 */
@ApiIgnore
@RestController
public class ErrorMsgController implements ErrorController {

  private static final String MSG_INTERNAL_ERROR = "访问的地址无效";

  @GetMapping("/error")
  public MessageEntity error() {
    return new MessageEntity(MSG_INTERNAL_ERROR);
  }

  @Override
  public String getErrorPath() {
    return "/error";
  }
}
