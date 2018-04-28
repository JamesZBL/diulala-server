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
package me.zbl.entity.response.argument;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * REST API 响应格式
 *
 * @author JamesZBL
 * @date 2018-04-02
 */
@Getter
@Setter
@AllArgsConstructor
public class ResponseEntity<T> implements Serializable {

  //  是否发生错误（包括用户输入错误和服务端错误）
  private boolean hasError;
  //  提示信息
  private String message;
  //  状态代码（非 HTTP 响应码）
  private String code;
  //  查询数据
  private T data;
}
