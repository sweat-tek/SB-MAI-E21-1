/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.samples.svg.Gradient;

import java.awt.geom.AffineTransform;

import static org.jhotdraw.draw.AttributeKeys.TRANSFORM;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.FILL_GRADIENT;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.STROKE_GRADIENT;

/**
 *
 * @author tjell
 */
public class SVGTextHelper {
    
    private SVGAttributedFigure figure;
    private AffineTransform tx;

    public SVGTextHelper(SVGAttributedFigure figure, AffineTransform tx) {
        this.figure = figure;
        this.tx = tx;
    }

    protected void transform() {
        if (TRANSFORM.get(figure) == null) {
            TRANSFORM.basicSet(figure, (AffineTransform) tx.clone());
        } else {
            AffineTransform t = TRANSFORM.getClone(figure);
            t.preConcatenate(tx);
            TRANSFORM.basicSet(figure, t);
        }
    }

    protected void fillGradient() {
        if (FILL_GRADIENT.get(figure) != null &&
                !FILL_GRADIENT.get(figure).isRelativeToFigureBounds()) {
            Gradient g = FILL_GRADIENT.getClone(figure);
            g.transform(tx);
            FILL_GRADIENT.basicSet(figure, g);
        }
    }

    protected void strokeGradient() {
        if (STROKE_GRADIENT.get(figure) != null &&
                !STROKE_GRADIENT.get(figure).isRelativeToFigureBounds()) {
            Gradient g = STROKE_GRADIENT.getClone(figure);
            g.transform(tx);
            STROKE_GRADIENT.basicSet(figure, g);
        }
    }
    
}
