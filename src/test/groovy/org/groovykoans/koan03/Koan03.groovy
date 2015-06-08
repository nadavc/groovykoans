/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan03

/**
 * Koan03 - GroovyBeans and classes
 *
 * Resource list:
 *   http://docs.groovy-lang.org/latest/html/documentation/#_class
 *   http://mrhaki.blogspot.com/2009/09/groovy-goodness-parameters-with-default.html
 */
class Koan03 extends GroovyTestCase {

    void test01_IntroToGroovyBeans() {
        // JavaBeans (or POJOs) are simple Java objects with getters (getX) and setters (setX) for its members
        JavaPerson javaPerson = new JavaPerson("Argus", "Filch", "1234");

        // Groovy introduces an easier way to create JavaBeans. They're called GroovyBeans.
        // Have a read here: http://docs.groovy-lang.org/latest/html/documentation/#_class
        GroovyPerson groovyPerson = new GroovyPerson('Harry', 'Potter', '3322')

        // Explore the differences between JavaPerson and GroovyPerson and read some of the user guide above.
        // When you're done, add the necessary getters to get the respective first names
        // Hint: The reason you don't have a place to add code in Groovy is because you don't have to!
        def javaFirstName
        def groovyFirstName
        // ------------ START EDITING HERE ----------------------
        javaFirstName = javaPerson.getFirstName();
        groovyFirstName = groovyPerson.firstName
        // ------------ STOP EDITING HERE  ----------------------

        assert javaFirstName == 'Argus'
        assert groovyFirstName == 'Harry'
    }

    void test02_ReadOnlyFieldInGroovyBean() {
        // You've probably noticed how Groovy automatically generates getters/setters for you. But what if you don't
        // want to generate a setter because it's a read-only field? Just mark it with 'final'. Groovy will understand.

        // Try to modify Ken's ssn. You should get a ReadOnlyPropertyException.
        def person = new GroovyPerson('Ken', 'Kousen', '7878')
        def failed = true
        shouldFail (ReadOnlyPropertyException) {
            // ------------ START EDITING HERE ----------------------
            person.ssn = '1234'
            // ------------ STOP EDITING HERE  ----------------------
            failed = false
        }

        assert failed

        // The code wrapping your additions verifies that the ReadOnlyProperty exception has been thrown.
        // The curly brackets ({}) represent a closure. We'll get into what that means very soon.
    }

    void test03_NamedParametersInConstructors() {
        // To enhance code clarity, Groovy allows using named arguments in methods.
        def quote = new SimpleGroovyBean(title: 'Quote object',
                data: "Never trust anything that can think for itself if you can't see where it keeps its brain")

        // If you pay close attention, you'll see that 'data' is actually untyped.
        // Practically, it's the same as specifying an 'Object' as the type.

        // Create a SimpleGroovyBean using named arguments, to represent a transaction with -30 as its data.
        def transaction
        // ------------ START EDITING HERE ----------------------
        transaction = new SimpleGroovyBean(title: 'Transaction', data: -30)
        // ------------ STOP EDITING HERE  ----------------------

        assert transaction.data == -30
    }

    void test04_DefaultValues() {
        // Groovy also allows you to have default values.
        // See http://mrhaki.blogspot.com/2009/09/groovy-goodness-parameters-with-default.html

        // Once you've learned how to use default values, modify the NameWithDefaultValue
        // class to set name to 'Anonymous' if no name has been specified.
        def nameObject = new NameWithDefaultValue()
        assert nameObject.name == 'Anonymous'
    }

}
