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
package me.zbl.conf;

import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import me.zbl.diulala.auth.WXHandlerIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Web 配置
 *
 * @author JamesZBL
 * @date 2018-04-19
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private DebugProperties debugProperties;

  /**
   * 资源处理器配置
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //    registry.addResourceHandler("/swagger-ui.html");
  }

  @Autowired
  private WXHandlerIntercepter wxHandlerIntercepter;

  /**
   * 拦截器配置
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    if (!debugProperties.isDebug()) {
      registry.addInterceptor(wxHandlerIntercepter);
    }
  }

  /**
   * 格式转换器配置
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
            .indentOutput(true)
            .dateFormat(new SimpleDateFormat("MM月dd日 hh:mm"))
            .modulesToInstall(new ParameterNamesModule());
    converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
  }
}
