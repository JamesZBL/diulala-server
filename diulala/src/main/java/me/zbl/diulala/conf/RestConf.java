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

import me.zbl.diulala.converter.TextPlainAsJsonHttpMessageConverter;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

/**
 * RestTemplate 配置
 *
 * @author JamesZBL
 * @date 2018-04-28
 */
@Configuration
public class RestConf {

  @Autowired
  WXProperties wxProperties;

  @Bean
  RestTemplate restTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
    //    配置 SSL
    TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
    SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
            .loadTrustMaterial(null, acceptingTrustStrategy)
            .build();
    SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
    CloseableHttpClient httpClient = HttpClients.custom()
            .setSSLSocketFactory(csf)
            .build();
    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
    requestFactory.setHttpClient(httpClient);
    //    微信 API baseURL
    String baseUrl = wxProperties.getUrlBase();
    DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
    RestTemplate restTemplate = new RestTemplate(requestFactory);
    restTemplate.setUriTemplateHandler(factory);
    //    添加自定义的转换器，将 text/plain 的响应作为 json 来解析
    restTemplate.getMessageConverters().add(new TextPlainAsJsonHttpMessageConverter());
    return restTemplate;
  }
}
