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
package me.zbl.diulala.repository;

import me.zbl.diulala.entity.persistence.AppUser;
import me.zbl.diulala.entity.response.Object;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author JamesZBL
 * @date 2018-04-29
 */
@Repository
public interface UserRepository extends CrudRepository<AppUser, String> {

  AppUser findAppUserByOpenId(String userid);
}

// SELECT
//	lose.gotBackCount,
//	caught.returnCount
//FROM
//	( SELECT count( * ) AS `gotBackCount` FROM app_find_caughter WHERE lose_user = 'obW4u5YJQVLrGXhm2G3QCSjUQLEM' ) AS lose,
//	( SELECT count( * ) AS `returnCount` FROM app_find_loser WHERE caught_user = 'obW4u5YJQVLrGXhm2G3QCSjUQLEM' ) AS caught;