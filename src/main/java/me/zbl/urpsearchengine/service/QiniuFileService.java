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
package me.zbl.urpsearchengine.service;

import me.zbl.urpsearchengine.entity.persistence.UrpInfoHebust;
import org.springframework.data.domain.Page;

/**
 * 七牛云文件存储和下载
 *
 * @author JamesZBL
 * @date 2018-04-08
 */
public interface QiniuFileService {

  Page<UrpInfoHebust> buildImageUrl(Page<UrpInfoHebust> u);
}
