/**
 * Copyright 2012 The original author or authors
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
 
package org.groovykoans.koan03

/**
 * A simple GroovyBean representing a person.
 * First and last name can be modified, but ssn is forever.
 */
class GroovyPerson {
    String firstName
    String lastName
    final String ssn      // Marking the field 'final' makes it read-only after construction.

    GroovyPerson(String firstName, String lastName, String ssn) {
        this.firstName = firstName
        this.lastName = lastName
        this.ssn = ssn
    }
}
