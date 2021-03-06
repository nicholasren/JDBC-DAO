package junit.org.rapidpm.microservice.persistence.jdbc.dao.v001.dao;

import junit.org.rapidpm.microservice.persistence.jdbc.dao.v001.model.User;
import org.rapidpm.microservice.persistence.jdbc.dao.QueryOneValue;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Copyright (C) 2010 RapidPM
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created by RapidPM - Team on 16.11.16.
 */
public interface QueryUser extends QueryOneValue<User> {

  @Override
  default User getFirstElement(final ResultSet resultSet) throws SQLException {
    return new User(
        resultSet.getInt("CUSTOMER_ID"),
        resultSet.getString("FIRSTNAME"),
        resultSet.getString("LASTNAME"),
        resultSet.getString("EMAIL")
    );
  }
}
