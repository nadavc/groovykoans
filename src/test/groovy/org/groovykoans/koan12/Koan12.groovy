/**
 * Copyright 2012-2013 The original author or authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


package org.groovykoans.koan12
/**
 * Koans12 - Built-in testing support in Groovy
 *
 * Reading list:
 *   * http://groovy.codehaus.org/api/groovy/util/GroovyTestCase.html
 *   * http://jetlet.blogspot.com/2010/06/shouldfail-in-groovy-testing.html
 *   * http://groovy.codehaus.org/Unit+Testing
 *   * http://groovy.codehaus.org/Mocking+Static+Methods+using+Groovy
 *   * http://groovy.codehaus.org/Groovy+Mocks
 *
 *
 */
class Koan12 extends GroovyTestCase {


    void test01_ShouldFail() {
        // GroovyTestCase is an extension of JUnit's TestCase. It adds various assertions and convenience methods.
        // Each of our Koans is actually implemented as a unit test.

        // Use shouldFail() to make this unit test pass. Try to be specific about the exception type.

        // ------------ START EDITING HERE ----------------------


            // ------------ STOP EDITING HERE  ----------------------
            Integer.nonExistentMethod()
            // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------

    }


    void test02_Stubbing() {
        // Unit tests should run quickly and without external dependencies. For that reason we normally create stubs
        // to fake real implementations of external dependencies.

        // Use the Expando class (remember Koan09?) to stub the hard worker with a quick one by
        // adding a work() method to it
        Factory factory = new Factory([1, 2])
        long startTime = System.currentTimeMillis()
        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------
        factory.work()
        long endTime = System.currentTimeMillis()
        assert endTime - startTime < 2000

        // Great! Now let's assume you cannot alter the worker member because
        // the class being tested uses a static call to create the worker.
        // How does Groovy address this? - Try http://groovy.codehaus.org/Mocking+Static+Methods+using+Groovy
        // Try to experiment with Map Coercion too - http://groovy.codehaus.org/Groovy+Mocks
        def staticFactory = new StaticFactory(numbers: [2, 3])
        startTime = System.currentTimeMillis()
        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------
        staticFactory.work()
        endTime = System.currentTimeMillis()
        assert endTime - startTime < 2000

    }

}
