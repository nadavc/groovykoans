/*
 * Copyright (c) 2012-2014 nadavc <https://twitter.com/nadavc>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the WTFPL, Version 2, as published by Sam Hocevar.
 * See the COPYING file for more details.
 */

package org.groovykoans.koan01;

public interface UserService {

    /**
     * @return the currently logged in user. Null if no user is logged in.
     */
    User getLoggedInUser();
}
