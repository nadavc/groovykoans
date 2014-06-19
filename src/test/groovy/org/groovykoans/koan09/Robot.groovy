/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan09

import org.codehaus.groovy.runtime.InvokerHelper

class Robot {
    // ------------ START EDITING HERE ----------------------
    def x = 0, y = 0

    void left() {
        x--
    }

    void right() {
        x++
    }

    void up() {
        y++
    }

    void down() {
        y--
    }

    Object invokeMethod(String methodName, Object args) {
        if (methodName ==~ /go(Left|Right|Up|Down)*/) {
            methodName.findAll(/(?i)(left|right|up|down)/) { match, String action ->
                InvokerHelper.getMetaClass(this).invokeMethod(this, action.toLowerCase(), null)
            }
        }
        null
    }
    // ------------ STOP EDITING HERE  ----------------------
}
