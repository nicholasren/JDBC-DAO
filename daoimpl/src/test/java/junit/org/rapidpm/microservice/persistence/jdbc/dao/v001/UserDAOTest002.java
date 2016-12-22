/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package junit.org.rapidpm.microservice.persistence.jdbc.dao.v001;

import junit.org.rapidpm.microservice.persistence.jdbc.dao.v001.dao.UserDAOHSQL;
import junit.org.rapidpm.microservice.persistence.jdbc.dao.v001.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.rapidpm.microservice.persistence.jdbc.JDBCConnectionPool;

import java.util.Optional;

public class UserDAOTest002 extends UserDAOBaseTest {

  @Test
  public void test001() throws Exception {
    final Optional<JDBCConnectionPool> connectionPoolOptional = pools.getPool(poolname());
    final JDBCConnectionPool connectionPool = connectionPoolOptional.get();

    final UserDAOHSQL userDAO = new UserDAOHSQL()
        .workOnPool(connectionPool);

    final Optional<User> user = userDAO.readUser(1001);

    Assert.assertNotNull(user);
    Assert.assertTrue(user.isPresent());
    Assert.assertEquals("Marge", user.get().getFirstname());
  }
}
