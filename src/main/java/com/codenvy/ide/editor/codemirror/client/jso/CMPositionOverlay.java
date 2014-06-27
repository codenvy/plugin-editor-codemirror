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

import com.google.gwt.core.client.JavaScriptObject;

public class CMPositionOverlay extends JavaScriptObject {
    protected CMPositionOverlay() {
    }

    public final native int getLine()/*-{
        return this.line;
    }-*/;

    public final native int getCharacter()/*-{
        return this.ch;
    }-*/;

    public static final native CMPositionOverlay create(int line, int character) /*-{
        var result = {};
        result.line = line;
        result.ch = character;
        return result;
    }-*/;
}
