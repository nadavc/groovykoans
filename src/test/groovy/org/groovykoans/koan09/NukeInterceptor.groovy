package org.groovykoans.koan09

class NukeInterceptor implements Interceptor {

    boolean isAuthorized = true

    // ------------ START EDITING HERE ----------------------
    @Override
    Object beforeInvoke(Object obj, String methodName, Object[] args) {
        if (methodName == 'nukeCity' && args[0] != 'admin')
            isAuthorized = false
        null
    }

    @Override
    Object afterInvoke(Object obj, String methodName, Object[] args, Object result) {
        isAuthorized = true
        result
    }

    @Override
    boolean doInvoke() {
        isAuthorized
    }
    // ------------ STOP EDITING HERE  ----------------------
}

