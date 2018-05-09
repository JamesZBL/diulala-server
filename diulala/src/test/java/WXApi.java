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

import feign.Param;
import feign.RequestLine;
import me.zbl.diulala.entity.response.ApiLoginResponse;

import java.util.Map;

/**
 * 微信 API
 *
 * @author JamesZBL
 * @email 1146556298@qq.com
 * @date 2018-05-09
 */
public interface WXApi {

  @RequestLine("GET /sns/jscode2session?" +
                       "appid={appid}&" +
                       "secret={secret}&" +
                       "js_code={js_code}&" +
                       "grant_type={grant_type}"
  )
  ApiLoginResponse login(
          @Param("appid") String appid,
          @Param("secret") String secret,
          @Param("js_code") String code,
          @Param("grant_type") String grantType
  );

  @RequestLine("GET /sns/jscode2session?" +
                       "appid={appid}&" +
                       "secret={secret}&" +
                       "js_code={js_code}&" +
                       "grant_type={grant_type}"
  )
  Map<String, String> loginPlain(
          @Param("appid") String appid,
          @Param("secret") String secret,
          @Param("js_code") String code,
          @Param("grant_type") String grantType
  );
}
