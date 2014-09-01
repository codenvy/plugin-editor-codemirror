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
package com.codenvy.ide.editor.codemirror.client;

import com.codenvy.ide.api.text.Region;
import com.codenvy.ide.editor.codemirror.client.jso.CMDocumentOverlay;
import com.codenvy.ide.editor.codemirror.client.jso.CMPositionOverlay;
import com.codenvy.ide.jseditor.client.document.DocumentHandle;
import com.codenvy.ide.jseditor.client.document.EmbeddedDocument;
import com.codenvy.ide.jseditor.client.events.CursorActivityHandler;
import com.codenvy.ide.jseditor.client.events.HasCursorActivityHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

/**
 * CodeMirror implementation of {@link EmbeddedDocument}.
 *
 * @author "Mickaël Leduque"
 */
public class CodeMirrorDocument implements EmbeddedDocument, DocumentHandle {

    /** The internal document representation for CodeMirror. */
    private final CMDocumentOverlay         documentOverlay;

    private final HasCursorActivityHandlers hasCursorActivityHandlers;

    public CodeMirrorDocument(final CMDocumentOverlay documentOverlay,
                              final HasCursorActivityHandlers hasCursorActivityHandlers) {
        this.documentOverlay = documentOverlay;
        this.hasCursorActivityHandlers = hasCursorActivityHandlers;
    }

    @Override
    public TextPosition getPositionFromIndex(int index) {
        final CMPositionOverlay pos = this.documentOverlay.posFromIndex(index);
        return new TextPosition(pos.getLine(), pos.getCharacter());
    }

    @Override
    public int getIndexFromPosition(TextPosition position) {
        return documentOverlay.indexFromPos(CMPositionOverlay.create(position.getLine(), position.getCharacter()));
    }

    @Override
    public void setCursorPosition(TextPosition position) {
        this.documentOverlay.setCursor(position.getLine(), position.getCharacter());
    }

    @Override
    public TextPosition getCursorPosition() {
        final CMPositionOverlay pos = this.documentOverlay.getCursor();
        return new TextPosition(pos.getLine(), pos.getCharacter());
    }

    @Override
    public int getLineCount() {
        return this.documentOverlay.lineCount();
    }

    @Override
    public HandlerRegistration addCursorHandler(final CursorActivityHandler handler) {
        return this.hasCursorActivityHandlers.addCursorActivityHandler(handler);
    }

    @Override
    public String getContents() {
        return this.documentOverlay.getValue();
    }

    public void replace(final Region region, final String text) {
        final CMPositionOverlay fromPos = this.documentOverlay.posFromIndex(region.getOffset());
        final CMPositionOverlay toPos = this.documentOverlay.posFromIndex(region.getOffset() + region.getLength());

        this.documentOverlay.replaceRange(text, fromPos, toPos);
    }

    public DocumentHandle getDocumentHandle() {
        return this;
    }

    @Override
    public boolean isSameAs(final DocumentHandle document) {
        return (this.equals(document));
    }
}
