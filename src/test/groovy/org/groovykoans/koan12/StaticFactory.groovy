/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan12

class StaticFactory {

    List<Integer> numbers

    static Worker getWorker() {
        return new HardWorker()
    }

    List<Integer> work() {
        numbers.collect {
            getWorker().work(it)
        }
    }


}
