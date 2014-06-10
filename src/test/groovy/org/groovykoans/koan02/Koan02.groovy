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

package org.groovykoans.koan02

/**
 * Koan02 - Groovy Truth
 *
 * In order to improve code readability, Groovy can also treats regular expressions as booleans.
 */
class Koan02 extends GroovyTestCase {

    void test01_RegularBooleanExpressions() {
        // Boolean expressions work as expected. true evaluates to true and false to false.
        def predicate1 = false
        def predicate2 = true

        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------

        assert predicate1
        assert predicate2 == false
    }

    void test02_Collections() {
        // Lists and map evaluate to false if they're empty. Otherwise, they evaluate to true
        Map<String, String> map = [:]
        List<String> list = ['item']

        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------

        assert map.asBoolean()
        assert list.asBoolean() == false
    }

    void test03_StringTruth() {
        // Quite intuitively, empty (or null) strings are false.
        String s1 = 'Non-empty string'
        String s2 = ''

        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------

        // Note how we can use String expressions inside an if statement.  It is automatically converted into a boolean.
        if (s1) {
            fail()
        }
        assert s2.asBoolean()
    }

    void test04_NumericTruth() {
        // Similar to C code, null or zeros are false. Any other number is true.
        def balance = [2, -3, 6, 0, 5]

        // Remove (or change) the offending integer to continue
        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------

        // Iterate through the list and AND the boolean values of its members.
        // For an easier way to do this in Groovy, check out the any() method at
        // http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html#any(groovy.lang.Closure)
        def result = true
        for (int i : balance) {
            result = result && i.asBoolean()
        }
        assert result
    }

}