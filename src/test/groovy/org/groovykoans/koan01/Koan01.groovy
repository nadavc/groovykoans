/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan01

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


/**
 * Koan01 - Groovy 101
 *
 * Resource list:
 *   https://docs.groovy-lang.org/docs/groovy-2.4.3/html/documentation/#_junit_4
 *   https://docs.groovy-lang.org/docs/groovy-2.4.3/html/api/groovy/test/GroovyAssert.html
 *   https://docs.groovy-lang.org/docs/groovy-2.4.3/html/documentation/#_power_assertion
 *   http://docs.groovy-lang.org/latest/html/documentation/index.html#all-strings
 *   http://groovy-lang.org/groovy-dev-kit.html#_working_with_collections
 *   http://groovy-lang.org/groovy-dev-kit.html#_working_with_collections
 *   http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/List.html
 *   http://docs.groovy-lang.org/latest/html/documentation/index.html#groovy-operators
 */
class Koan01 {

    @Test
    @DisplayName("Assertion and some Syntax")
    public void test01_AssertionsAndSomeSyntax() {
        // Groovy introduces the GroovyTestCase for testing with JUnit 3. JUnit 4 test cases can be used without restrictions
        // as well. We are using JUnit 4 Tests using @Test Annotations. GroovyAssert class holds static assert methods that can
        // be used instead of GroovyTestCase. However, it's a good practice to use the Power Assertion statement instead.
        // Relevant Documentation links can be found below:
        // Groovy JUnit 4       -> https://docs.groovy-lang.org/docs/groovy-2.4.3/html/documentation/#_junit_4
        // GroovyAssert         -> https://docs.groovy-lang.org/docs/groovy-2.4.3/html/api/groovy/test/GroovyAssert.html
        // Groovy Power Asserts -> https://docs.groovy-lang.org/docs/groovy-2.4.3/html/documentation/#_power_assertion

        // Groovy can be used solely with Java syntax. You have full control over what facet of Groovy you want.

        // Let's start. First - Groovy requires much less boilerplate code. For example, in Groovy we don't
        // have to use semicolons at all. As a matter of fact, we don't always need to define the type of the variable!
        boolean assertion = false
        def hello = "Hola"

        // Assign our variables the required values to continue...
        // ------------ START EDITING HERE ----------------------
        hello = "Hello"
        assertion = true
        // ------------ STOP EDITING HERE  ----------------------

        assert assertion, 'Assign "true" to the "assertion" variable to proceed'
        assert hello == "Hello", 'Modify "Hola" to "Hello" to proceed'
    }

    @Test
    @DisplayName("GStrings")
    void test02_GStrings() {
        // Groovy allows you to use either regular quotes (') or double-quotes (") for String declarations.
        // The difference is that double-quotes create a GString, which is a super-powered String.
        // For docs about GStrings, see http://docs.groovy-lang.org/latest/html/documentation/index.html#all-strings

        // GStrings allow you to use the ${} syntax within them. The ${} can contain any valid Groovy expression.
        def name = 'George'
        def greeting = "Hello ${name}, how are you?" // 'Hello George, how are you?
        def math = "The result of 4 + 4 is ${4 + 4}" // 'The result of 4 + 4 is 8'

        // Create the target string with the ${} mechanism. Remember that ${} can contain method calls too!
        String result
        // ------------ START EDITING HERE ----------------------

        result = "The size of the string '${greeting}' is ${greeting.length()}"

        // ------------ STOP EDITING HERE  ----------------------

        assert result == "The size of the string 'Hello George, how are you?' is 26"
    }

    @Test
    void test03_MapsInGroovy() {
        // Maps are also special citizens in Groovyland.
        // Docs can be found here: http://groovy-lang.org/groovy-dev-kit.html#Collections-Maps
        def map = [right: 'derecha', left: 'izquierda']

        // Concatenate the two values of 'right' and 'left' into result to proceed using Groovy syntax
        def result
        // ------------ START EDITING HERE ----------------------

        result = map.right + map.left

        // ------------ STOP EDITING HERE  ----------------------

        assert result.toCharArray().size() == 16
    }

    @Test
    void test04_Lists() {
        // In Java, list creation can be somewhat cumbersome:
        List<String> javaList = new ArrayList<String>();
        javaList.add("King");
        javaList.add("Queen");
        javaList.add("Prince");

        // In Groovy, this is simplified to:
        // (See http://groovy-lang.org/groovy-dev-kit.html#Collections-Lists
        // and http://docs.groovy-lang.org/latest/html/groovy-jdk/java/util/List.html)
        def groovyList = ['King', 'Prince']

        // Add the missing item to the Groovy list. Pay attention to the order of the items.
        // Hint: you can use either Java's add(int, String) or Groovy's plus() method.
        // ------------ START EDITING HERE ----------------------

        groovyList = groovyList.plus(1, 'Queen')

        // ------------ STOP EDITING HERE  ----------------------

        // Note how Groovy allows you to compare the *content* of the lists
        assert groovyList == javaList
    }

    void test05_ElvisAndSafeNavigation() {
        // Preparation code for the examples that follow. We'll get to this code in later Koans.
        User player = new User('Ronaldo', 'Nazário de Lima', 'ron', null)
        UserService userServiceWithUserLoggedIn = [getLoggedInUser: { player }] as UserService
        UserService userServiceWithoutLoggedInUser = [getLoggedInUser: { null }] as UserService

        // Groovy introduces two convenient operators for dealing with nulls: elvis (?:) and safe navigation (?.)
        // Read all about it at http://docs.groovy-lang.org/latest/html/documentation/index.html#groovy-operators

        // Assume we have a User object that may or may not contain a first name and an address.
        // In Java, we could end up with the following code:

        String firstName = player.getFirstName();
        String javaDisplayName = firstName == null ? player.getUsername() : firstName;
        String javaCity = "";
        if (player.getAddress() != null && player.getAddress().getCity() != null) {
            // Be careful of NullPointerExceptions
            javaCity = player.getAddress().getCity();
        }

        // With Groovy's new operators, this becomes much simpler:
        def groovyDisplayName = player.firstName ?: player.username
        def groovyCity = player?.address?.city

        // Using your newly acquired knowledge, fix the createMessageForUser method below
        // so that anonymous users get 'Hello Anonymous!' and logged in users get 'Hello <first name>'
        // You should use userService.getLoggedInUser() as well.
        assert createMessageForUser(userServiceWithUserLoggedIn) == 'Hello Ronaldo!'
        assert createMessageForUser(userServiceWithoutLoggedInUser) == 'Hello Anonymous!'
    }

    private String createMessageForUser(UserService userService) {
        def message
        // ------------ START EDITING HERE ----------------------


        // ------------ STOP EDITING HERE  ----------------------

        // Note how Groovy doesn't require the 'return' keyword! It will simply return the last expression.
        message
    }

}
