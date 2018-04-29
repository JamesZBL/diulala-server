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
package me.zbl.diulala.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * 将 text/plain 作为 json 进行解析
 *
 * @author JamesZBL
 * @date 2018-04-29
 */
public class TextPlainAsJsonHttpMessageConverter extends MappingJackson2HttpMessageConverter {

  public TextPlainAsJsonHttpMessageConverter() {
    List<MediaType> mediaTypes = new ArrayList<>();
    mediaTypes.add(MediaType.TEXT_PLAIN);
    setSupportedMediaTypes(mediaTypes);
  }
}
