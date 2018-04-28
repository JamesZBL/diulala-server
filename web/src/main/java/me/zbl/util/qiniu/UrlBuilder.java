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
package me.zbl.util.qiniu;

import com.qiniu.util.Auth;
import me.zbl.conf.QiNiuProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author JamesZBL
 * @date 2018-04-08
 */
@Component
public class UrlBuilder {

  @Autowired
  private QiNiuProperties conf;

  public String build(String filename) {
    String domainOfBucket = conf.getDomain();
    String encodedFileName = null;
    try {
      encodedFileName = URLEncoder.encode(filename, "utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
    String accessKey = conf.getAccessKey();
    String secretKey = conf.getSecretKey();
    Auth auth = Auth.create(accessKey, secretKey);
    //授权有效时间
    long expireInSeconds = conf.getTimeout();
    return auth.privateDownloadUrl(publicUrl, expireInSeconds);
  }
}
