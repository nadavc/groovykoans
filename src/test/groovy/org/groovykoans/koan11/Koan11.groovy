/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan11

import groovy.sql.Sql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
/**
 * Koans11 - Groovy and SQL
 *
 * Reading list:
 *   * http://groovy-lang.org/databases.html
 *   * http://docs.groovy-lang.org/latest/html/api/groovy/sql/DataSet.html
 *
 */
class Koan11 extends GroovyTestCase {
    final String CREATE_STMT = '''|create table PERSON (
                                  |    ID INT PRIMARY KEY AUTO_INCREMENT,
                                  |    FIRSTNAME VARCHAR(64), LASTNAME VARCHAR(64)
                                  |)'''.stripMargin()

    void test01_CreateDb() {

        // Groovy makes it very easy to access databases.
        // You can find some info here: http://groovy-lang.org/databases.html
        // Suppose we wanted to create an in-memory H2 database in Java and execute some commands:
        Connection javaConnection = null;
        try {
            DriverManager.registerDriver(new org.h2.Driver())
            javaConnection = DriverManager.getConnection("jdbc:h2:mem:javaDb", "sa", "");
            PreparedStatement javaStatement = javaConnection.prepareStatement(CREATE_STMT);
            javaStatement.execute();
            javaStatement.close();
        } catch (Exception ignored) {
            // do some stuff here... or not
        } finally {
            if (javaConnection != null)
                javaConnection.close();
        }

        // Messy, no? Now let's do it the Groovy way:
        Sql.withInstance('jdbc:h2:mem:groovyDb', 'sa', '', 'org.h2.Driver') { db ->
            db.execute(CREATE_STMT) // Note how there's no need for db.close()! Groovy's withInstance does it for you.
        }

        // Using what you just learned add a Person named Jack Dawson to the table
        Sql.withInstance('jdbc:h2:mem:groovyDb2', 'sa', '', 'org.h2.Driver') { db ->
            db.execute(CREATE_STMT)
            // ------------ START EDITING HERE ----------------------
            db.execute('insert into PERSON (FIRSTNAME, LASTNAME) values (?, ?)', ['Jack', 'Dawson'])
            // ------------ STOP EDITING HERE  ----------------------
            assert db.firstRow('select count(*) c from Person').c == 1
            assert db.firstRow('select LASTNAME from Person where FIRSTNAME = ?', ['Jack']).lastname == 'Dawson'
        }
    }

    void test02_MoreOnInsertingData() {
        // Let's use what we've learned from Koan10 and import data into db tables
        Sql.withInstance('jdbc:h2:mem:groovyDb2', 'sa', '', 'org.h2.Driver') { db ->
            db.execute(CREATE_STMT)

            // Add all the people from cast.txt into the table we just created.
            // ------------ START EDITING HERE ----------------------
            new File('src/test/groovy/org/groovykoans/koan11/cast.txt').eachLine { line ->
                db.execute('insert into PERSON (FIRSTNAME, LASTNAME) values (?, ?)', line.split())
            }
            // ------------ STOP EDITING HERE  ----------------------
            assert db.firstRow('select count(*) c from Person').c == 23

            // Now do the same with an xml source from cast2.xml (add the actor names):
            // ------------ START EDITING HERE ----------------------
            def xml = new XmlSlurper().parse('src/test/groovy/org/groovykoans/koan11/cast2.xml')
            xml.character.@actor.each { attr ->
                db.execute('insert into PERSON (FIRSTNAME, LASTNAME) values (?, ?)', attr.text().split())
            }
            // ------------ STOP EDITING HERE  ----------------------
            assert db.firstRow('select count(*) c from Person').c == 39

            // Groovy also allows a syntax that doesn't involve SQL at all. Add one more person (anyone) using the
            // db.dataSet('PERSON') method. See http://docs.groovy-lang.org/latest/html/api/groovy/sql/DataSet.html
            def person = db.dataSet('PERSON')
            // ------------ START EDITING HERE ----------------------
            person.add(firstname: 'William', lastname: 'Shatner')
            // ------------ STOP EDITING HERE  ----------------------
            assert db.firstRow('select count(*) c from Person').c == 40
        }

    }


    void test03_IteratingResults() {
        Sql.withInstance('jdbc:h2:mem:groovyDb3', 'sa', '', 'org.h2.Driver') { db ->
            // Populates the db with some people names. Check out the sql files
            // to understand the table structure.
            initDb(db)

            // Using what you've learned in the link from test01, run an SQL query to find Rose's last name:
            def lastNameRose
            // ------------ START EDITING HERE ----------------------
            def rose = db.firstRow('select LASTNAME from Person where FIRSTNAME = :firstName', [firstName:'Rose'])
            lastNameRose = rose.lastname
            // ------------ STOP EDITING HERE  ----------------------
            assert lastNameRose == 'DeWitt'

            // Now, using an SQL select and the eachRow() method, count the number of 'e' (case sensitive) in the
            // last names of the people in Person
            def eCount = 0
            // ------------ START EDITING HERE ----------------------
            db.eachRow('select LASTNAME from PERSON') { row ->
                eCount += row.lastname.count('e')
            }
            // ------------ STOP EDITING HERE  ----------------------
            assert eCount == 2
        }
    }

    void test04_UpdatingTables() {
        Sql.withInstance('jdbc:h2:mem:groovyDb4', 'sa', '', 'org.h2.Driver') { db ->
            initDb(db)

            // allow resultSets to be able to be changed
            db.resultSetConcurrency = java.sql.ResultSet.CONCUR_UPDATABLE

            // Use eachRow() to change all the first names that contain the letter 'a' (lowercase) into 'Alf'.
            // ------------ START EDITING HERE ----------------------
            db.eachRow("select * from PERSON p where p.firstname like '%a%'") { row ->
                row.firstname = 'Alf'
            }
            // ------------ STOP EDITING HERE  ----------------------
            assert db.firstRow("select count(*) c from PERSON where FIRSTNAME = 'Alf'").c == 2
        }
    }

    void initDb(Sql db) {
        def baseDir = 'src/test/groovy/org/groovykoans/koan11'
        db.execute(new File("${baseDir}/create-schema.sql").text)
        db.execute(new File("${baseDir}/data.sql").text)
    }

}
