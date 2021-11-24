/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import org.jhotdraw.samples.svg.SVGAttributeKeys;
import org.jhotdraw.samples.svg.figures.SVGAttributedFigure;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.jhotdraw.samples.svg.figures.SVGTextHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author tjell
 */
public class SVGTextFigureTest {

    private SVGTextFigure textFigure;
    private AffineTransform tx;
    private SVGTextHelper textHelper;
    
    @Before
    public void testSetup() {
        textFigure = new SVGTextFigure();
        tx = new AffineTransform();
        textHelper = new SVGTextHelper(textFigure, tx);
    }
    
    @Test
    public void testSetTransform() {
        AffineTransform key = textFigure.getAttribute(SVGAttributeKeys.TRANSFORM);
        Assert.assertNull(key);
        textHelper.transform();
        key = textFigure.getAttribute(SVGAttributeKeys.TRANSFORM);
        Assert.assertNotNull(key);
    }
}
