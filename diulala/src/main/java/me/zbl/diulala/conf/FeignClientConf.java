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
package me.zbl.diulala.conf;

import feign.Feign;
import feign.gson.GsonDecoder;
import me.zbl.diulala.client.WXApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign 客户端配置
 *
 * @author JamesZBL
 * @email 1146556298@qq.com
 * @date 2018-05-09
 */
@Configuration
public class FeignClientConf {

  @Autowired
  WXProperties wxProperties;

  @Bean(name = "wxApi")
  WXApi wxApi() {
    return Feign.builder().
            decoder(new GsonDecoder()).
            target(WXApi.class, wxProperties.getUrlBase());
  }
}
