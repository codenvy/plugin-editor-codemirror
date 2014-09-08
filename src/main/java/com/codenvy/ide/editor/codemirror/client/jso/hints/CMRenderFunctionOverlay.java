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
package com.codenvy.ide.editor.codemirror.client.jso.hints;

import com.google.gwt.core.client.JavaScriptObject;

import elemental.dom.Element;

public class CMRenderFunctionOverlay extends JavaScriptObject {

    protected CMRenderFunctionOverlay() {
    }

    public static final native CMRenderFunctionOverlay create(RenderFunction renderFunc) /*-{
        return $entry(function(element, data, completion) {
            renderFunc.@com.codenvy.ide.editor.codemirror.client.jso.hints.CMRenderFunctionOverlay.RenderFunction::renderHint(Lelemental/dom/Element;Lcom/codenvy/ide/editor/codemirror/client/jso/hints/CMHintResultsOverlay;Lcom/google/gwt/core/client/JavaScriptObject;)(element, data, completion);
        });
    }-*/;

    public interface RenderFunction {
        void renderHint(Element element, CMHintResultsOverlay data, JavaScriptObject completion);
    }
}
