/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan12

class Factory {

    def numbers;
    def worker;

    // defaults to a Hard (and slow) Worker implementation
    Factory(worker = new HardWorker(), numbers = 1..10) {
        this.numbers = numbers;
        this.worker = worker;
    }

    def work() {
        numbers.collect {
            worker.work(it)
        }
    }

}
