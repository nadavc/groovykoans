package org.groovykoans.koan08

public enum Feeling {
    Happy, Sad, Neutral, Suicidal, Anticipation, Surprised, Relaxed, Guilty

    // ------------ START EDITING HERE ----------------------
    boolean isCase(Person person) {
        person.feelings.contains(this)
    }

    boolean isCase(Cartoon animal) {
        animal.feeling == this
    }
    // ------------ STOP EDITING HERE  ----------------------


}