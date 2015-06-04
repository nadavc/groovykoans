/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
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
        predicate1 = true
        predicate2 = false
        // ------------ STOP EDITING HERE  ----------------------

        assert predicate1
        assert predicate2 == false
    }

    void test02_Collections() {
        // Lists and maps evaluate to false if they're empty.  Otherwise, they evaluate to true.
        Map<String, String> map = [:]
        List<String> list = ['item']

        // ------------ START EDITING HERE ----------------------
        map['key'] = 'value'
        list.clear()
        // ------------ STOP EDITING HERE  ----------------------

        assert map.asBoolean()
        assert list.asBoolean() == false
    }

    void test03_StringTruth() {
        // Quite intuitively, empty (or null) strings are false.
        String s1 = 'Non-empty string'
        String s2 = ''

        // ------------ START EDITING HERE ----------------------
        s1 = ''
        s2 = 'something'
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
        balance[3] = 3
        // ------------ STOP EDITING HERE  ----------------------

        // Iterate through the list and AND the boolean values of its members.
        // For an easier way to do this in Groovy, check out the any() method at
        // http://docs.groovy-lang.org/latest/html/groovy-jdk/java/lang/Object.html#any(groovy.lang.Closure)
        def result = true
        for (int i : balance) {
            result = result && i.asBoolean()
        }
        assert result
    }

}
