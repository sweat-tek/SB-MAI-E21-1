/*
 * @(#)QuadTreeDrawing.java  2.2.2  2009-04-04
 *
 * Copyright (c) 1996-2009 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.draw;

import dk.sdu.mmmi.featuretracer.lib.FeatureEntryPoint;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import static java.util.Collections.unmodifiableList;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import org.jhotdraw.app.JHotDrawFeatures;
import static org.jhotdraw.draw.AttributeKeys.TRANSFORM;
import static org.jhotdraw.draw.FigureLayerComparator.INSTANCE;
import org.jhotdraw.geom.Dimension2DDouble;
import org.jhotdraw.geom.Geom;
import org.jhotdraw.geom.QuadTree;
import org.jhotdraw.util.*;


public class QuadTreeDrawing extends AbstractDrawing {

    private static final Logger LOG = getLogger(QuadTreeDrawing.class.getName());

    private QuadTree<Figure> quadTree = new QuadTree<Figure>();
    private boolean needsSorting = false;
    private Dimension2DDouble canvasSize;

    /**
     *
     * @param figure
     * @return
     */
    @Override
    public int indexOf(Figure figure) {
        return children.indexOf(figure);
    }

    /**
     *
     * @param index
     * @param figure
     */
    @Override
    public void basicAdd(int index, Figure figure) {
        super.basicAdd(index, figure);
        quadTree.add(figure, figure.getDrawingArea());
        needsSorting = true;
    }

    /**
     *
     * @param index
     * @return
     */
    @Override
    public Figure basicRemoveChild(int index) {
        Figure figure = getChild(index);
        quadTree.remove(figure);
        needsSorting = true;
        super.basicRemoveChild(index);
        return figure;
    }

    /**
     *
     * @param g
     */
    @Override
    public void draw(Graphics2D g) {
        Rectangle2D clipBounds = g.getClipBounds();
        if (clipBounds != null) {
            Collection<Figure> c = quadTree.findIntersects(clipBounds);
            Collection<Figure> toDraw = sort(c);
            draw(g, toDraw);
        } else {
            draw(g, children);
        }
    }

    /**
     * Implementation note: Sorting can not be done for orphaned children.
     * @param c
     * @return 
     */
    @Override
    public java.util.List<Figure> sort(Collection<? extends Figure> c) {
        ensureSorted();
        ArrayList<Figure> sorted = new ArrayList<>(c.size());
        children.stream().filter(f -> (c.contains(f))).forEachOrdered(f -> {
            sorted.add(f);
        });
        return sorted;
    }

    /**
     *
     * @param g
     * @param c
     */
    public void draw(Graphics2D g, Collection<Figure> c) {
        c.stream().filter(f -> (f.isVisible())).forEachOrdered(f -> {
            f.draw(g);
        });
    }

    /**
     *
     * @param bounds
     * @return
     */
    public java.util.List<Figure> getChildren(Rectangle2D.Double bounds) {
        return new LinkedList<>(quadTree.findInside(bounds));
    }

    /**
     *
     * @return
     */
    @Override
    public java.util.List<Figure> getChildren() {
        return unmodifiableList(children);
    }

    /**
     *
     * @param p
     * @return
     */
    @Override
    public Figure findFigureInside(Point2D.Double p) {
        Collection<Figure> c = quadTree.findContains(p);
        for (Figure f : getFiguresFrontToBack()) {
            if (c.contains(f) && f.contains(p)) {
                return f.findFigureInside(p);
            }
        }
        return null;

    }

    /**
     * Returns an iterator to iterate in
     * Z-order front to back over the children.
     */
    @Override
    public java.util.List<Figure> getFiguresFrontToBack() {
        ensureSorted();
        return new ReversedList<>(children);
    }

    /**
     *
     * @param p
     * @return
     */
    @Override
    public Figure findFigure(Point2D.Double p) {
        Collection<Figure> c = quadTree.findContains(p);
        switch (c.size()) {
            case 0:
                return null;
            case 1: {
                Figure f = c.iterator().next();
                return (f.contains(p)) ? f : null;
            }
            default: {
                for (Figure f : getFiguresFrontToBack()) {
                    if (c.contains(f) && f.contains(p)) {
                        return f;
                    }
                }
                return null;
            }
        }
    }

    /**
     *
     * @param p
     * @param ignore
     * @return
     */
    @Override
    public Figure findFigureExcept(Point2D.Double p, Figure ignore) {
        Collection<Figure> c = quadTree.findContains(p);
        switch (c.size()) {
            case 0: {
                return null;
            }
            case 1: {
                Figure f = c.iterator().next();
                return (f == ignore || !f.contains(p)) ? null : f;
            }
            default: {
                for (Figure f : getFiguresFrontToBack()) {
                    if (f != ignore && f.contains(p)) {
                        return f;
                    }
                }
                return null;
            }
        }
    }

    /**
     *
     * @param p
     * @param ignore
     * @return
     */
    @Override
    public Figure findFigureExcept(Point2D.Double p, Collection<? extends Figure> ignore) {
        Collection<Figure> c = quadTree.findContains(p);
        switch (c.size()) {
            case 0: {
                return null;
            }
            case 1: {
                Figure f = c.iterator().next();
                return (!ignore.contains(f) || !f.contains(p)) ? null : f;
            }
            default: {
                for (Figure f : getFiguresFrontToBack()) {
                    if (!ignore.contains(f) && f.contains(p)) {
                        return f;
                    }
                }
                return null;
            }
        }
    }

    /**
     *
     * @param p
     * @param figure
     * @return
     */
    @Override
    public Figure findFigureBehind(Point2D.Double p, Figure figure) {
        boolean isBehind = false;
        for (Figure f : getFiguresFrontToBack()) {
            if (isBehind) {
                if (f.isVisible() && f.contains(p)) {
                    return f;
                }
            } else {
                isBehind = figure == f;
            }
        }
        return null;
    }

    /**
     *
     * @param p
     * @param children
     * @return
     */
    @Override
    public Figure findFigureBehind(Point2D.Double p, Collection<? extends Figure> children) {
        int inFrontOf = children.size();
        for (Figure f : getFiguresFrontToBack()) {
            if (inFrontOf == 0) {
                if (f.isVisible() && f.contains(p)) {
                    return f;
                }
            } else {
                if (children.contains(f)) {
                    inFrontOf--;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param r
     * @return
     */
    @Override
    public java.util.List<Figure> findFigures(Rectangle2D.Double r) {
        LinkedList<Figure> c = new LinkedList<>(quadTree.findIntersects(r));
        switch (c.size()) {
            case 0:
            // fall through
            case 1:
                return c;
            default:
                return sort(c);
        }
    }

    /**
     *
     * @param bounds
     * @return
     */
    @Override
    public java.util.List<Figure> findFiguresWithin(Rectangle2D.Double bounds) {
        LinkedList<Figure> contained = new LinkedList<>();
        children.forEach((Figure f) -> {
            Rectangle2D.Double r = f.getBounds();
            if (TRANSFORM.get(f) != null) {
                Rectangle2D rt;
                rt = TRANSFORM.get(f).createTransformedShape(r).getBounds2D();
                r = (rt instanceof Rectangle2D.Double) ? (Rectangle2D.Double) rt : new Rectangle2D.Double(rt.getX(), rt.getY(), rt.getWidth(), rt.getHeight());
            }
            if (f.isVisible() && Geom.contains(bounds, r)) {
                contained.add(f);
            }
        });
        return contained;
    }

    /**
     *
     * @param figure
     */
    @Override
    @FeatureEntryPoint(JHotDrawFeatures.ARRANGE)
    public void bringToFront(Figure figure) {
        if (children.remove(figure)) {
            children.add(figure);
            needsSorting = true;
            fireAreaInvalidated(figure.getDrawingArea());
        }
    }

    /**
     *
     * @param figure
     */
    @Override
    @FeatureEntryPoint(JHotDrawFeatures.ARRANGE)
    public void sendToBack(Figure figure) {
        if (children.remove(figure)) {
            children.add(0, figure);
            needsSorting = true;
            fireAreaInvalidated(figure.getDrawingArea());
        }
    }

    /**
     *
     * @param f
     * @return
     */
    @Override
    public boolean contains(Figure f) {
        return children.contains(f);
    }

    /**
     * Ensures that the children are sorted in z-order sequence.
     */
    private void ensureSorted() {
        if (needsSorting) {
            Collections.sort(children, INSTANCE);
            needsSorting = false;
        }
    }

    /**
     *
     * @param key
     * @param newValue
     */
    @Override
    protected void setAttributeOnChildren(AttributeKey key, Object newValue) {
        // empty
    }

    /**
     *
     * @param newValue
     */
    public void setCanvasSize(Dimension2DDouble newValue) {
        Dimension2DDouble oldValue = canvasSize;
        canvasSize = (newValue == null) ? null : (Dimension2DDouble) newValue.clone();
        firePropertyChange("canvasSize", oldValue, newValue);
    }

    /**
     *
     * @return
     */
    public Dimension2DDouble getCanvasSize() {
        return (canvasSize == null) ? null : (Dimension2DDouble) canvasSize.clone();
    }

    /**
     *
     * @return
     */
    @Override
    public QuadTreeDrawing clone() {
        QuadTreeDrawing that = (QuadTreeDrawing) super.clone();
        that.canvasSize = (this.canvasSize == null) ? null : (Dimension2DDouble) this.canvasSize.clone();
        that.quadTree = new QuadTree<>();
        getChildren().forEach(f -> {
            quadTree.add(f, f.getDrawingArea());
        });
        return that;
    }

    /**
     *
     * @return
     */
    @Override
    protected EventHandler createEventHandler() {
        return new QuadTreeEventHandler();
    }


    /**
     *
     * @param g
     */
    @Override
    protected void drawFill(Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param g
     */
    @Override
    protected void drawStroke(Graphics2D g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     * Handles all figure events fired by Figures contained in the Drawing.
     */
    protected class QuadTreeEventHandler extends AbstractCompositeFigure.EventHandler {
        
        /**
         *
         * @param e
         */
        @Override
        public void figureChanged(FigureEvent e) {
            quadTree.remove(e.getFigure());
            quadTree.add(e.getFigure(), e.getFigure().getDrawingArea());
            needsSorting = true;
            invalidate();
            fireAreaInvalidated(e.getInvalidatedArea());
        }
    }
}
