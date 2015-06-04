/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan04

/**
 * Koan04 - Closures
 *
 * Resource list:
 *   http://docs.groovy-lang.org/latest/html/documentation/index.html#_closures
 *   http://docs.groovy-lang.org/latest/html/groovy-jdk/java/lang/String.html#eachMatch(java.lang.String, groovy.lang.Closure)
 *   http://docs.groovy-lang.org/latest/html/groovy-jdk/java/io/File.html
 *   http://docs.groovy-lang.org/latest/html/groovy-jdk/java/lang/String.html
 */
class Koan04 extends GroovyTestCase {

    void test01_IntroToClosures() {
        // Closures are probably the most important feature Groovy has to offer. Unfortunately, they're
        // tricky to understand if you have never done any functional programming.

        // In short, Closures are somewhat like function objects. They contain code that may (or may not) be executed at
        // a later time and have access to variables you pass into them (as well as implicit and free variables that
        // were defined in the environment it was declared in).

        // Let's start with a simple example.
        def sayHelloClosure = { return 'Hello from Closure' }

        // We can then execute it as if it were a regular method, using:
        def helloClosureResult = sayHelloClosure()

        // What is the result from the above execution?
        def expectedHelloClosureResult
        // ------------ START EDITING HERE ----------------------
        expectedHelloClosureResult = 'Hello from Closure'
        // ------------ STOP EDITING HERE  ----------------------
        assert helloClosureResult == expectedHelloClosureResult

        // Closures can also accept parameters, like so
        def personalizedHelloClosure = { String name -> return "Hello $name" }
        String helloRonalda = personalizedHelloClosure('Ronalda')

        // What is the result from the above execution?
        String expectedHelloRonalda
        // ------------ START EDITING HERE ----------------------
        expectedHelloRonalda = 'Hello Ronalda'
        // ------------ STOP EDITING HERE  ----------------------
        assert helloRonalda == expectedHelloRonalda

        // But there's a shorthand version for this. One parameter closures implicitly add a variable named 'it'
        // which represents that single parameter. We also learned that 'return' isn't mandatory in functions if
        // the last statement is the return statement. Combining those two facts, we get:
        def happyBirthdayClosure = { "Happy Birthday To $it" }
        String happyBirthdayGranger = happyBirthdayClosure('Hermione')

        // What is the result from the above execution?
        def expectedHappyBirthdayGranger
        // ------------ START EDITING HERE ----------------------
        expectedHappyBirthdayGranger = 'Happy Birthday To Hermione'
        // ------------ STOP EDITING HERE  ----------------------
        assert happyBirthdayGranger == expectedHappyBirthdayGranger

        // Create a closure that accepts two integers, adds them, and multiplies the result by two
        def resultClosure
        // ------------ START EDITING HERE ----------------------
        resultClosure = { int a, int b -> (a + b) * 2 }
        // ------------ STOP EDITING HERE  ----------------------

        assert resultClosure(2, 3) == 10
        shouldFail {
            resultClosure('one', 'two')
        }
    }

    void test02_MoreClosureIntro() {
        // Now that you're familiar with Closures, you can read about them here:
        // http://docs.groovy-lang.org/latest/html/documentation/index.html#_closures

        // So how can we use closures? Everywhere. Groovy adds a lot of convenience methods on top of regular
        // Java constructs.

        def list = ['one', 'two', 'three']
        // In Java, if you wanted to create a list of all items beginning with 't', you would do the following:
        List<String> javaResult = new ArrayList<String>();
        for (String s : list) {
            if (s.startsWith("t")) {
                javaResult.add(s);
            }
        }

        // In Groovy (with closures), it's much simpler
        List<String> groovyResult = list.grep({ it.startsWith('t') })

        // Let's check that we got the same result (you can use the assertX methods)
        // ------------ START EDITING HERE ----------------------
        assert javaResult == groovyResult
        // ------------ STOP EDITING HERE  ----------------------

        // To make the code even cleaner, Groovy allows some syntactic sugar. If your method has a closure as its
        // last parameter, it can be separated from the rest of the parameters as such:

        def monkeyColors = []
        // http://docs.groovy-lang.org/latest/html/groovy-jdk/java/lang/String.html#eachMatch(java.lang.String, groovy.lang.Closure)
        "I have seen blue monkeys, red monkeys, and purple monkeys".eachMatch('(\\w+) monkeys') { entireMatch, color ->
            monkeyColors.add(color)
        }

        // What will monkeyColors contain?
        def expectedMonkeyColors = []
        // ------------ START EDITING HERE ----------------------
        expectedMonkeyColors = ['blue', 'red', 'purple']
        // ------------ STOP EDITING HERE  ----------------------
        assert monkeyColors == expectedMonkeyColors

        // Okay. Time for an exercise. Have a look at Groovy's additions on top of the File class by reading
        // docs at http://docs.groovy-lang.org/latest/html/groovy-jdk/java/io/File.html
        // Once done, read the content of "exercise.txt" (it's right next to the file you're viewing) into a
        // StringWriter but leave out the lines that begin with #.

        StringWriter filteredResult = new StringWriter()
        def prefix = 'src/test/groovy/org/groovykoans/koan04/'
        // ------------ START EDITING HERE ----------------------
        def file = new File("$prefix/exercise.txt")
        file.filterLine(filteredResult) { String line ->
            !line.startsWith('#')
        }
        // ------------ STOP EDITING HERE  ----------------------

        String result = filteredResult.toString().trim().replaceAll(/[\n\r]+/, '\n')
        String answer = new File("$prefix/exercise-solved.txt").text.replaceAll(/[\n\r]+/, '\n')
        assert answer == result
    }

    void test03_MoreClosureSyntacticSugar() {
        // Depending on personal preference, you can choose to omit parenthesis from method calls if there is at least
        // one parameter and no ambiguity. For example:

        def count = "That ain't no woman! It's a man, man!".count 'man'

        // Can you guess what count() does? If not, look it up in
        // http://docs.groovy-lang.org/latest/html/groovy-jdk/java/lang/String.html
        def expectedCount
        // ------------ START EDITING HERE ----------------------
        expectedCount = 3
        // ------------ STOP EDITING HERE  ----------------------

        assert count == expectedCount

        // Admittedly, that past example doesn't make the code any clearer.
        // However, when we have methods with a closure as a parameter, it removes a lot of the noise:
        def mysteryList = ['Groovy', 'Baby', 'Yeah'].findAll {  // no parenthesis
            it.contains('a')
        }

        // What will the value of mysteryList be?
        def expectedMysteryList
        // ------------ START EDITING HERE ----------------------
        expectedMysteryList = ['Baby', 'Yeah']
        // ------------ STOP EDITING HERE  ----------------------
        assert mysteryList == expectedMysteryList

    }

}
