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
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

/**
 * 七牛云配置
 *
 * @author JamesZBL
 * @date 2018-04-08
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "qiniu")
public class QiNiuProperties {

  @NonNull
  private String accessKey;
  @NonNull
  private String secretKey;
  @NonNull
  private String domain;
  @NonNull
  private Integer timeout;
}
