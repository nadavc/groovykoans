/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan08

/**
 * Koan08 - More goodness
 *
 * Resource list:
 *   * http://groovy.codehaus.org/Logical+Branching#LogicalBranching-switchstatement
 */
class Koan08 extends GroovyTestCase {

    void test01_SwitchStatements() {
        // Some people consider switch-case clauses to be a code smell because the same behavior can be
        // achieved using polymorphism. Having said that, let's look at what Groovy has to offer.
        // Have a read here: http://groovy.codehaus.org/Logical+Branching#LogicalBranching-switchstatement

        // Using a switch statement, create a closure that accepts input (could be string or number) and returns
        // the following:
        // - If it's an integer between 1-100, divide it by two
        // - If it's a string that ends with 'ee', replace its end with 'ey'
        // - Otherwise return the input

        def magicClosure = { input ->
            // ------------ START EDITING HERE ----------------------


            // ------------ STOP EDITING HERE  ----------------------
        }
        [5: 2.5, 'smile': 'smile', 'smilee': 'smiley', 'heehee': 'heehey'].each { key, expectedValue ->
            assert magicClosure(key) == expectedValue
        }

    }

    void test02_IsCaseInSwitch() {
        // What the switch-case clause basically does in the following:

        // switch (test) {
        //   case candidate: break;
        // }
        //
        // candidate.isCase(test)

        // This means that if we implement our own isCase(), we can take advantage of it in switch statements.
        // For this exercise we have a Cartoon object that has one single feeling.
        // Let's implement a isCase() in Feeling so we can use switch-case on a Cartoon.

        def cartoon = new Cartoon(name: 'Mickey Mouse', feeling: Feeling.Guilty)

        switch (cartoon) {
            case Feeling.Guilty:
                // process guilty feeling cartoon
                break
            default:
                fail()
        }

        // Suppose people may have more than one Feeling. Implement the appropriate isCase to allow switching on them
        def person = new Person(name: 'Jack Bauer', feelings: [Feeling.Suicidal, Feeling.Relaxed])

        switch (person) {
            case Feeling.Anticipation:
                break
            case [Feeling.Happy, Feeling.Sad]:
                // Note how we can also use Lists here. In this case the Feeling.isCase() is triggered on all items
                break
            case Feeling.Suicidal:
                // process suicidal person
                break
            default:
                fail()
        }

    }

    void test03_MultiAssignment() {
        // Sometimes you want to return more than one variable from a method. Yes, you could do it with an enclosing
        // class, but it could be an overkill. Groovy calls it Multiple Assignments.
        // http://groovy.codehaus.org/Multiple+Assignment

        // Create a closure that returns two random integers in a given range
        def generateTwoRandomInts = { int maxInt ->
            // ------------ START EDITING HERE ----------------------


            // ------------ STOP EDITING HERE  ----------------------
        }

        def (intA, intB) = generateTwoRandomInts(10)
        assert intA in 0..10
        assert intB in 0..10
    }

}
