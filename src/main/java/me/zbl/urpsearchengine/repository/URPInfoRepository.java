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
package me.zbl.urpsearchengine.repository;

import me.zbl.urpsearchengine.entity.persistence.UrpInfoHebust;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * URP Info repository
 *
 * @author JamesZBL
 * @date 2018-04-01
 */
public interface URPInfoRepository extends CrudRepository<UrpInfoHebust, String> {

  @Query("select u from UrpInfoHebust u where u.stuid like ?1%")
  Page<UrpInfoHebust> findByStuid(String stuId, Pageable pageable);

  @Query("select u from UrpInfoHebust u where u.name like %?1%")
  Page<UrpInfoHebust> findByName(String name, Pageable pageable);

  @Query("select u from UrpInfoHebust u where u.birthPlace like %?1% or u.contactAddress like %?1%")
  Page<UrpInfoHebust> findByHometown(String birthPlace, Pageable pageable);

  @Query("select u from UrpInfoHebust u where u.graduateSchool like %?1%")
  Page<UrpInfoHebust> findBySchool(String school, Pageable pageable);
}
