/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan12
/**
 * Koans12 - Built-in testing support in Groovy
 *
 * Reading list:
 *   * http://docs.groovy-lang.org/latest/html/api/groovy/util/GroovyTestCase.html
 *   * http://jetlet.blogspot.com/2010/06/shouldfail-in-groovy-testing.html
 *   * http://docs.groovy-lang.org/docs/latest/html/documentation/core-testing-guide.html
 *   * http://docs.groovy-lang.org/latest/html/documentation/index.html#testing_guide_emc
 *   * http://docs.groovy-lang.org/latest/html/documentation/index.html#_mocking_and_stubbing
 *
 */
class Koan12 extends GroovyTestCase {


    void test01_ShouldFail() {
        // GroovyTestCase is an extension of JUnit's TestCase. It adds various assertions and convenience methods.
        // Each of our Koans is actually implemented as a unit test.

        // Use shouldFail() to make this unit test pass. Try to be specific about the exception type.

        // ------------ START EDITING HERE ----------------------
        shouldFail(MissingMethodException) {
            // ------------ STOP EDITING HERE  ----------------------
            Integer.nonExistentMethod()
            // ------------ START EDITING HERE ----------------------
        }
        // ------------ STOP EDITING HERE  ----------------------

    }


    void test02_Stubbing() {
        // Unit tests should run quickly and without external dependencies. For that reason we normally create stubs
        // to fake real implementations of external dependencies.

        // Use the Expando class (remember Koan09?) to stub the hard worker with a quick one by
        // adding a work() method to it
        Factory factory = new Factory()
        long startTime = System.currentTimeMillis()
        // ------------ START EDITING HERE ----------------------
        def stub = new Expando();
        stub.work = { number -> number + 10 }
        factory.worker = stub
        // ------------ STOP EDITING HERE  ----------------------
        factory.work()
        long endTime = System.currentTimeMillis()
        assert endTime - startTime < 2000

        // Great! Now let's assume you cannot alter the worker member because
        // the class being tested uses a static call to create the worker.
        // How does Groovy address this? - Try http://docs.groovy-lang.org/latest/html/documentation/index.html#testing_guide_emc
        // Try to experiment with Map Coercion too - http://docs.groovy-lang.org/latest/html/documentation/index.html#_mocking_and_stubbing
        startTime = System.currentTimeMillis()
        // ------------ START EDITING HERE ----------------------
        Worker worker = { number -> number + 10 } as Worker
        StaticFactory.metaClass.static.getWorker = { worker }
        // ------------ STOP EDITING HERE  ----------------------
       new StaticFactory(numbers: 1..10).work()
        endTime = System.currentTimeMillis()
        assert endTime - startTime < 3000

    }

}
