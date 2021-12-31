/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.util.ArrayList;
import java.util.Collection;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Damianul
 */
public class BringToFrontActionTest {
    
    public BringToFrontActionTest() {
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
     * Test of bringToFront method, of class BringToFrontAction.
     */
    @Test
    public void testBringToFront() {
        System.out.println("bringToFront");
        try
        {
        DrawingView view = null;
        Collection<Figure> figures = new ArrayList();
        BringToFrontAction.bringToFront(view, figures);
        }
        catch(NullPointerException e)
        {
        System.out.println("Interface cannot be instantiated.  ");
        }
        
    } 
}
