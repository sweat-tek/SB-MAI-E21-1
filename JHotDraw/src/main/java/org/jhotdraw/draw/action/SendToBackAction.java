/*
 * @(#)SendToBackAction.java  2.0  2008-05-30
 *
 * Copyright (c) 2003-2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */

package org.jhotdraw.draw.action;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.util.*;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.undo.*;
import org.jhotdraw.app.JHotDrawFeatures;
import org.jhotdraw.draw.*;
import static org.jhotdraw.draw.action.BringToFrontAction.bringToFront;
import static org.jhotdraw.draw.action.SendToBackAction.sendToBack;


public class SendToBackAction extends AbstractSelectedAction {
    

    public static String ID = "edit.sendToBack";
    /** Creates a new instance.
     * @param editor */
    public SendToBackAction(DrawingEditor editor) {
        super(editor);
        labels.configureAction(this, ID);
    }

    /**
     *
     * @param e
     */
    @FeatureEntryPoint(JHotDrawFeatures.ARRANGE)
       @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        final DrawingView view = getView();
        final LinkedList<Figure> figures = new LinkedList<>(view.getSelectedFigures());
        sendToBack(view, figures);
        fireUndoableEditHappened(new AbstractUndoableEdit() {
            @Override
            public String getPresentationName() {
       return labels.getTextProperty(ID);
            }
            @Override
            public void redo() throws CannotRedoException {
                super.redo();
                sendToBack(view, figures);
            }
            @Override
            public void undo() throws CannotUndoException {
                super.undo();
                bringToFront(view, figures);
            }
        }
        );
    }

    /**
     *
     * @param view
     * @param figures
     */
    public static void sendToBack(DrawingView view, Collection figures) {
        Iterator i = figures.iterator();
        Drawing drawing = view.getDrawing();
        while (i.hasNext()) {
            Figure figure = (Figure) i.next();
            drawing.sendToBack(figure);
        }
    }
    private static final Logger LOG = getLogger(SendToBackAction.class.getName());

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
