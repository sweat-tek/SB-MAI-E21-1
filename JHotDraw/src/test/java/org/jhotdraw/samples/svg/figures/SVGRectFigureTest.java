/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.figures;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Collection;
import org.jhotdraw.draw.ConnectionFigure;
import org.jhotdraw.draw.Connector;
import org.jhotdraw.draw.Handle;
import org.jhotdraw.geom.Dimension2DDouble;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sebastianbendz
 */
public class SVGRectFigureTest {
    
   
    
    public SVGRectFigureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
   

    /**
     * Test of setBounds method, of class SVGRectFigure.
     
    @Test
    public void testSetBounds() {
        System.out.println("setBounds");
        Point2D.Double anchor = new Point2D.Double(2, 5);
        Point2D.Double lead = new Point2D.Double(3, 3);
        
        double expWidth = 1;
        
        SVGRectFigure instance = new SVGRectFigure();
        
       
        instance.setBounds(anchor, lead);
        double width = instance.getWidth();
        double height = instance.getHeight();
        
      
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
    /**
     * Test of createHandles method, of class SVGRectFigure.
     */
    @Test
    public void testCreateHandles() {
        System.out.println("createHandles");
        int detailLevel = 1;
        SVGRectFigure instance = new SVGRectFigure();
     
        Collection<Handle> result = instance.createHandles(detailLevel);
        Boolean expResult = false;
        // The expected size is 10 when detailLevel equals 1, as TransformHandleKit.addTransformHandles has multiple methods that add handles.
        int expSize = 10;
        
        assertEquals(expResult, result.isEmpty());
        assertEquals(expSize, result.size());
        
    }

    /**
     * Test of isEmpty method,l of class SVGRectFigure.
     * Setting width or height to 0 should make isEmpty() return true
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        double width = 0;
        double height = 0;
        SVGRectFigure instance = new SVGRectFigure(1, 1, width, height);
        boolean expResult = true;
        System.out.println(instance.getBounds());
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    
    
    
}
