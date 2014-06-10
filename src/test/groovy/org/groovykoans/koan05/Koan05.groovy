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

package org.groovykoans.koan05

/**
 * Koan05 - Iterations in Groovy
 *
 * Resource list:
 *  http://groovy.codehaus.org/groovy-jdk/java/util/Map.html#each(groovy.lang.Closure)
 *  http://groovy.codehaus.org/Collections#Collections-Ranges
 *  http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html#eachWithIndex(groovy.lang.Closure)
 */
class Koan05 extends GroovyTestCase {

    void test01_IterateWithEach() {
        def products = ['GitHub', 'Confluence', 'Hipmunk', 'Outlook']

        // It's very common to iterate through lists. Can it get simpler than this?
        for (String s : products) {
            println s
        }
        // In Groovy, it can.
        products.each {
            println it
        }

        Map<String, String> idToNameMap = [333: 'Matthew', 233: 'Christopher', 133: 'Dominic']

        // Suppose we needed to extract a list of IDs+Names from this map. In Java:
        List<String> javaIdListResult = new LinkedList<String>();
        for (Map.Entry<String, String> entry : idToNameMap) {
            javaIdListResult.add(entry.getKey() + entry.getValue());
        }

        // How would you do this in Groovy?
        // http://groovy.codehaus.org/groovy-jdk/java/util/Map.html#each(groovy.lang.Closure)
        def idListResult = []
        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------
        assert idListResult == ['333Matthew', '233Christopher', '133Dominic']
    }

    void test02_Ranges() {
        // Groovy allows you to create quick lists for sequential values. For example 5..10 or 'a'..'d'
        // Read at http://groovy.codehaus.org/Collections#Collections-Ranges

        // A simple example:
        def range = 5..10

        // What will range equal?
        def expectedRange = []
        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------
        assert range == expectedRange
    }

    void test03_IterateOnRanges() {
        // Just as you can iterate over lists, you can iterate over ranges.

        // Create a list of all odd letters (a, c, e, ... etc) using ranges
        // http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html#eachWithIndex(groovy.lang.Closure)
        def rangeResult = []
        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------
        assert rangeResult == ['a', 'c', 'e', 'g', 'i', 'k', 'm', 'o', 'q', 's', 'u', 'w', 'y']
    }


}