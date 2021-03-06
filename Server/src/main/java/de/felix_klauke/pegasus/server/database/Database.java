/*
 * Copyright 2016 Felix Klauke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.felix_klauke.pegasus.server.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Collections;

/**
 * Created by Felix Klauke for project Pegasus on 13.02.2016.
 */
public class Database {

    /* ----------------------------------- [ Fields ] ----------------------------------- */

    private MongoCollection collection;
    private MongoDatabase database;

    /* ----------------------------------- [ Constructors ] ----------------------------------- */

    public Database(MongoCredential credential, String database, String collection) {
        final MongoClient mongoClient = new MongoClient(new ServerAddress("5.1.82.58", 27017), Collections.singletonList(credential));
        this.database = mongoClient.getDatabase(database);
        this.collection = this.database.getCollection(collection);
    }

    /* ----------------------------------- [ Methods ] ----------------------------------- */

    public MongoCollection getCollection() {
        return collection;
    }

    public void setCollection(String name) {
        this.collection = this.database.getCollection(name);
    }

}
