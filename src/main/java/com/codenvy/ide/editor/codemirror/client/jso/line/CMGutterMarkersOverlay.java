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
package com.codenvy.ide.editor.codemirror.client.jso.line;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

import elemental.dom.Element;

/**
 * The map of gutter markers for a line, included in the result of lineInfo().
 */
public class CMGutterMarkersOverlay extends JavaScriptObject {

    protected CMGutterMarkersOverlay() {
    }

    /**
     * Returns the marker for the given gutter.
     * 
     * @param gutterId the gutter
     * @return the marker element
     */
    public final native Element getMarker(String gutterId) /*-{
        return this[gutterId];
    }-*/;

    public final native boolean hasMarker(String gutterId) /*-{
        return this.hasOwnProperty(gutterId);
    }-*/;

    /**
     * Returns the list of gutters.
     * 
     * @return the gutters
     */
    public final native JsArrayString getIds() /*-{
        return this.getOwnPropertyNames();
    }-*/;
}