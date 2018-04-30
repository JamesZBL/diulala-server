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

import java.util.Iterator;
import java.util.Optional;

/**
 * 控制器公共操作类
 *
 * @author JamesZBL
 * @date 2018-04-02
 */
public class BaseController {

  /**
   * 对数据实体进行包装
   *
   * @param data 数据实体
   * @param <T>  数据类型
   *
   * @return 响应实体
   */
  protected <T> T wrapData(T data) {
    // 结果为 null
    if (null == data) {
      throw new EmptyResultException();
    }
    //    结果为 Optional 类型但结果不存在
    if (data instanceof Optional && !((Optional) data).isPresent()) {
      throw new EmptyResultException();
    }
    //    结果为 Iterable 类型但不包含任何元素
    if (data instanceof Iterable) {
      Iterator it = ((Iterable) data).iterator();
      if (!it.hasNext()) {
        throw new EmptyResultException();
      }
    }
    return data;
  }

  /**
   * 对数据实体进行包装
   *
   * @param data 数据实体
   * @param <T>  数据类型
   *
   * @return 响应实体
   */
  protected <T> T wrapData(Optional<T> data) {
    if (!data.isPresent()) {
      throw new EmptyResultException();
    }
    return data.get();
  }
}
