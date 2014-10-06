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

/**
 * A line+character position in the text.
 */
public class CMPositionOverlay extends JavaScriptObject {
    protected CMPositionOverlay() {
    }

    /**
     * Returns the line part.
     * @return the line
     */
    public final native int getLine() /*-{
        return this.line;
    }-*/;

    /**
     * Returns the character part.
     * @return the character
     */
    public final native int getCharacter() /*-{
        return this.ch;
    }-*/;

    /**
     * Creates a new instance of position.
     * @param line the line part of the position
     * @param character the character part of the position
     * @return the position instance
     */
    public static final native CMPositionOverlay create(int line, int character) /*-{
        var result = {};
        result.line = line;
        result.ch = character;
        return result;
    }-*/;
}
