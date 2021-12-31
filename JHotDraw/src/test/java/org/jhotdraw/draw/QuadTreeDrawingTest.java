/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import org.jhotdraw.geom.Dimension2DDouble;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Damianul
 */
public class QuadTreeDrawingTest {
    
    public QuadTreeDrawingTest() {
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
     * Test of indexOf method, of class QuadTreeDrawing.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Figure figure = null;
        QuadTreeDrawing instance = new QuadTreeDrawing();
        int expResult = -1;
        int result = instance.indexOf(figure);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFiguresFrontToBack method, of class QuadTreeDrawing.
     */
    @Test
    public void testGetFiguresFrontToBack() {
        System.out.println("getFiguresFrontToBack");
        QuadTreeDrawing instance = new QuadTreeDrawing();
        List<Figure> expResult = new ArrayList();
        List<Figure> result = instance.getFiguresFrontToBack();
        assertEquals(expResult, result);
    }
    /**
     * Test of findFigureBehind method, of class QuadTreeDrawing.
     */
    @Test
    public void testFindFigureBehind_Point2DDouble_Figure() {
        System.out.println("findFigureBehind");
        Point2D.Double p = null;
        Figure figure = null;
        QuadTreeDrawing instance = new QuadTreeDrawing();
        Figure expResult = null;
        Figure result = instance.findFigureBehind(p, figure);
        assertEquals(expResult, result);
    }

    /**
     * Test of findFiguresWithin method, of class QuadTreeDrawing.
     */
    @Test
    public void testFindFiguresWithin() {
        System.out.println("findFiguresWithin");
        Rectangle2D.Double bounds = null;
        QuadTreeDrawing instance = new QuadTreeDrawing();
        List<Figure> expResult = new ArrayList();
        List<Figure> result = instance.findFiguresWithin(bounds);
        assertEquals(expResult, result);
    }

    /**
     * Test of bringToFront method, of class QuadTreeDrawing.
     */
    @Test
    public void testBringToFront() {
        System.out.println("bringToFront");
        Figure figure = null;
        QuadTreeDrawing instance = new QuadTreeDrawing();
        instance.bringToFront(figure);
    }

    /**
     * Test of sendToBack method, of class QuadTreeDrawing.
     */
    @Test
    public void testSendToBack() {
        System.out.println("sendToBack");
        Figure figure = null;
        QuadTreeDrawing instance = new QuadTreeDrawing();
        instance.sendToBack(figure);
    }

    /**
     * Test of contains method, of class QuadTreeDrawing.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Figure f = null;
        QuadTreeDrawing instance = new QuadTreeDrawing();
        boolean expResult = false;
        boolean result = instance.contains(f);
        assertEquals(expResult, result);
    }

    /**
     * Test of setAttributeOnChildren method, of class QuadTreeDrawing.
     */
    @Test
    public void testSetAttributeOnChildren() {
        System.out.println("setAttributeOnChildren");
        AttributeKey key = null;
        Object newValue = null;
        QuadTreeDrawing instance = new QuadTreeDrawing();
        instance.setAttributeOnChildren(key, newValue);
    }

    /**
     * Test of setCanvasSize method, of class QuadTreeDrawing.
     */
    @Test
    public void testSetCanvasSize() {
        System.out.println("setCanvasSize");
        Dimension2DDouble newValue = null;
        QuadTreeDrawing instance = new QuadTreeDrawing();
        instance.setCanvasSize(newValue);
    }

    /**
     * Test of getCanvasSize method, of class QuadTreeDrawing.
     */
    @Test
    public void testGetCanvasSize() {
        System.out.println("getCanvasSize");
        QuadTreeDrawing instance = new QuadTreeDrawing();
        Dimension2DDouble expResult = null;
        Dimension2DDouble result = instance.getCanvasSize();
        assertEquals(expResult, result);
    }
}
