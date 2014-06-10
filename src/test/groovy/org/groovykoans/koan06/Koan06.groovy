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

package org.groovykoans.koan06

/**
 * Koan06 - More closures
 *
 * Resource list:
 *   * http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html#with(groovy.lang.Closure)
 *   * http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html#collect(groovy.lang.Closure)
 *   * http://groovy.codehaus.org/groovy-jdk/java/util/Collection.html
 *   * http://groovy.codehaus.org/groovy-jdk/java/io/File.html#eachFileRecurse(groovy.lang.Closure)
 *   * http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html
 */
class Koan06 extends GroovyTestCase {

    void test01_WithMethod() {
        // The 'with()' method [ http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html#with(groovy.lang.Closure) ]
        // allows you to access an object within a closure without explicitly referring to it.

        // This is how Java StringBuilders are used:
        StringBuilder javaStringBuilder = new StringBuilder();
        javaStringBuilder.append("roses are #FF0000\\n");
        javaStringBuilder.append("violets are #0000FF\\n");
        javaStringBuilder.append("all my base\\n")
        javaStringBuilder.append("are belong to you\\n")
        String javaResult = javaStringBuilder.toString();

        // Groovy-fy the above code, using StringBuilder and with() to get the same result in Groovy
        String groovyResult
        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------
        assert groovyResult == javaResult
    }

    void test02_CollectMethodOnLists() {
        // We're often required to iterate through a whole list and and perform some sort of transformation on
        // some (or all) of the items, returning a new list. Groovy has a method just for that:
        // http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html#collect(groovy.lang.Closure)

        // Using collect() and a method from http://groovy.codehaus.org/groovy-jdk/java/util/Collection.html, create
        // a list of UNIQUE class types from the following list:
        def differentTypes = [1, 'String', "GString", 'a', 'Another string', 0]
        def uniqueTypes = []
        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------
        assert uniqueTypes == [Integer, String]
    }

    void test03_FileIteration() {
        // Groovy's File enhancements includes an iterator that walks through all files
        // http://groovy.codehaus.org/groovy-jdk/java/io/File.html#eachFileRecurse(groovy.lang.Closure)

        // Use the eachFileRecurse iterator to find the number of files that contain the string 'Lorem'
        // under the src directory
        int count = 0
        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------
        assert count == 3

    }

    void test04_ConcludingExercise() {
        // Using methods from Groovy object (http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html) and
        // range objects, store all the prime numbers between 200 and 250 in the target variable
        def primesBetween200And250 = []
        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------
        assert primesBetween200And250 == [211, 223, 227, 229, 233, 239, 241]

    }

}
