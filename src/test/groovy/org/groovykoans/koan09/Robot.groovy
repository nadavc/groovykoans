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
        if (methodName==~/go(Left|Right|Up|Down)*/) {
            methodName.findAll(/(?i)(left|right|up|down)/) { match, String action ->
                InvokerHelper.getMetaClass(this).invokeMethod(this, action.toLowerCase(), null)
            }
        }
        null
    }
    // ------------ STOP EDITING HERE  ----------------------
}
