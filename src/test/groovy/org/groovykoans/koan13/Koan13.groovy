/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan13

import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Unroll

/**
 * Koan13 - Spock testing framework
 *
 * Reading list:
 *   * https://spockframework.github.io/spock/docs/1.0/data_driven_testing.html
 */
@Stepwise
class Koan13 extends Specification {

    def "introduction to Spock"() {
        // Noticed something different about this Koan? We're now using the Spock testing framework.
        // Spock relies on the power of Groovy to allow simpler and better structured unit tests as well as
        // a groovy mocking framework. Note how much easier it is to read the test case title!

        // Let's start. Spock has one mandatory block - 'expect'. You can find more information at the link above
        // and then make the following pass
        expect:
        def circum = { r -> 2 * Math.PI * r }
        // ------------ START EDITING HERE ----------------------
        def r = 1.div(Math.PI)
        // ------------ STOP EDITING HERE  ----------------------
        circum(r) == 2
    }

    def "testing magic formula"(a, b, expectedResult) {
        // Let's use the 'where' block. This actually executes the test 5 times with 5 different parameters.
        // Fill in the blanks in magicFormula below.
        expect:
        magicFormula(a, b) == expectedResult

        where:
        a   | b | expectedResult
        1   | 1 | 3
        2   | 2 | 6
        3   | 3 | 11
        3   | 0 | 2
        'a' | 2 | 'aa2'

    }

    def magicFormula(a, b) {
        // ------------ START EDITING HERE ----------------------
        a * b + 2
        // ------------ STOP EDITING HERE  ----------------------
    }

    @Unroll
    def "check if #a times #b equals #c"() {
        // Fix the 'where' block to make this test pass for all ints a,b such that 0<= a,b <=10 (121 permutations).
        // Also note how we now used @Unroll and derived the parameter names from the test name
        expect:
        advancedMultiplication(a, b) == c

        where:
        // Hint - this can be done in two lines
        // ------------ START EDITING HERE ----------------------
        a << (0..10).collect { [it].multiply(11) }.flatten()    // 0,0,0,0,0,0,0,0,0,0,0,1,1,1,1 ...
        b << (0..10).multiply(11)                               // 0,1,2..10,0,1,2,..10,...
        // ------------ STOP EDITING HERE  ----------------------
        c = a * b
    }

    def advancedMultiplication(a, b) {
        (2 * a * 2 * b) / 4
    }

}
