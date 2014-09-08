/*******************************************************************************
 * Copyright (c) 2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.ide.editor.codemirror.client.jso;

import java.util.ArrayList;
import java.util.List;

import com.codenvy.ide.editor.codemirror.client.CodeMirrorKeyBindingAction;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

/**
 * Overlay class over Keymap CodeMirror objects.
 *
 * @author "Mickaël Leduque"
 */
public class CMKeymapOverlay extends JavaScriptObject {

    protected CMKeymapOverlay() {
    }

    public final static native CMKeymapOverlay create() /*-{
        return {};
    }-*/;

    private static final native JsArrayString keys(CMKeymapOverlay jsObject) /*-{
        return Object.keys(jsObject);
    }-*/;

    public final List<String> getKeys() {
        final JsArrayString jsObject = keys(this);
        final List<String> result = new ArrayList<>();
        for (int i = 0; i < jsObject.length(); i++) {
            result.add(jsObject.get(i));
        }
        return result;
    }

    public final native <T> void addBinding(String keySpec, T thisInstance, CodeMirrorKeyBindingAction<T> keyBindingAction) /*-{
        var keymapFun = function() {
            var javaMethod = keyBindingAction.@com.codenvy.ide.editor.codemirror.client.CodeMirrorKeyBindingAction::action(*);
            javaMethod(thisInstance);
        }
        this[keySpec] = $entry(keymapFun);
    }-*/;

    public final native void addBinding(String keySpec, String commandName) /*-{
        this[keySpec] = commandName;
    }-*/;

    public final Type getType(final String key) {
        if (isCommandName(key)) {
            return Type.COMMAND_NAME;
        } else if (isFunction(key)) {
            return Type.FUNCTION;
        } else if (isPass(key)) {
            return Type.PASS;
        } else {
            return Type.UNKNOWN;
        }
    }

    private final native boolean isCommandName(String key) /*-{
        return typeof (this[key]) === "string";
    }-*/;

    private final native boolean isFunction(String key) /*-{
        return typeof (this[key]) === "function";
    }-*/;

    private final native boolean isPass(String key) /*-{
        if (typeof (this[key]) === "boolean") {
            return this[key] == false;
        } else {
            return false;
        }
    }-*/;

    public final native String getCommandName(String key) /*-{
        return this[key];
    }-*/;

    public final native String getFunctionSource(String key) /*-{
        return this[key].toString();
    }-*/;

    public static enum Type {
        COMMAND_NAME,
        FUNCTION,
        PASS,
        UNKNOWN
    }
}
