/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan05

/**
 * Koan05 - Iterations in Groovy
 *
 * Resource list:
 *  http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/Map.html#each(groovy.lang.Closure)
 *  http://groovy-lang.org/groovy-dev-kit.html#_working_with_collections
 *  http://docs.groovy-lang.org/latest/html/groovy-jdk/java/lang/Object.html#eachWithIndex(groovy.lang.Closure)
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
        // http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/Map.html#each(groovy.lang.Closure)
        def idListResult = []
        // ------------ START EDITING HERE ----------------------
        idToNameMap.each { key, value ->
            idListResult << "$key$value"
        }
        // ------------ STOP EDITING HERE  ----------------------
        assert idListResult == ['333Matthew', '233Christopher', '133Dominic']
    }

    void test02_Ranges() {
        // Groovy allows you to create quick lists for sequential values. For example 5..10 or 'a'..'d'
        // Read at http://groovy-lang.org/groovy-dev-kit.html#_working_with_collections

        // A simple example:
        def range = 5..10

        // What will range equal?
        def expectedRange = []
        // ------------ START EDITING HERE ----------------------
        expectedRange = [5, 6, 7, 8, 9, 10]
        // ------------ STOP EDITING HERE  ----------------------
        assert range == expectedRange
    }

    void test03_IterateOnRanges() {
        // Just as you can iterate over lists, you can iterate over ranges.

        // Create a list of all odd letters (a, c, e, ... etc) using ranges
        // http://docs.groovy-lang.org/latest/html/groovy-jdk/java/lang/Object.html#eachWithIndex(groovy.lang.Closure)
        def rangeResult = []
        // ------------ START EDITING HERE ----------------------
        def range = 'a'..'z'
        range.eachWithIndex { value, index ->
            if (index % 2 == 0)
                rangeResult << value
        }
        // ------------ STOP EDITING HERE  ----------------------
        assert rangeResult == ['a', 'c', 'e', 'g', 'i', 'k', 'm', 'o', 'q', 's', 'u', 'w', 'y']
    }


}
