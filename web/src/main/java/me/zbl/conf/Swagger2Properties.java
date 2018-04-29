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

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Swagger2 配置属性
 *
 * @author JamesZBL
 * @date 2018-04-29
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "swagger2")
public class Swagger2Properties {

  @NonNull
  private String title;

  private String basePackage;
  private String description;
  private String version;
  private String termsOfServiceUrl;
}
