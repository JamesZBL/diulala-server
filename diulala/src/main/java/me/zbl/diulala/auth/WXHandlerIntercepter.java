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
package me.zbl.diulala.auth;

import me.zbl.auth.annotation.CurrentUser;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 小程序鉴权拦截器
 * 拦截 Controller 中带有 @CurrentUser 注解的 Handler Method，校验 Token 有效性
 *
 * @author JamesZBL
 * @email 1146556298@qq.com
 * @date 2018-05-04
 */
public class WXHandlerIntercepter implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    //    防止静态资源请求被拦截，产生类型转换异常
    if (!(handler instanceof HandlerMethod)) {
      return true;
    }
    //    获取 handler 方法
    HandlerMethod method = (HandlerMethod) handler;
    //    是否需要用户用户认证
    boolean onlyCurrentUser = method.hasMethodAnnotation(CurrentUser.class);
    if (onlyCurrentUser) {

    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

  }
}
