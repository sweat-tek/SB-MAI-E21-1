/*
 * @(#)BringToFrontAction.java  2.0  2008-05-30
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


public class BringToFrontAction extends AbstractSelectedAction {
    

    public static String ID = "edit.bringToFront";
    private static final Logger LOG = getLogger(BringToFrontAction.class.getName());
    /**
     *
     * @param view
     * @param figures
     */
    public static void bringToFront(DrawingView view, Collection<Figure> figures) {
        Drawing drawing = view.getDrawing();
        drawing.sort(figures).forEach(drawing::bringToFront);
    }
       
    /** Creates a new instance.
     * @param editor */
    public BringToFrontAction(DrawingEditor editor) {
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
        bringToFront(view, figures);
        fireUndoableEditHappened(new AbstractUndoableEdit() {
            @Override
            public String getPresentationName() {
       return labels.getTextProperty(ID);
            }
            @Override
            public void redo() throws CannotRedoException {
                super.redo();
                bringToFront(view, figures);
            }
            @Override
            public void undo() throws CannotUndoException {
                super.undo();
                sendToBack(view, figures);
            }
        }
        
        );
    }

    /**
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
