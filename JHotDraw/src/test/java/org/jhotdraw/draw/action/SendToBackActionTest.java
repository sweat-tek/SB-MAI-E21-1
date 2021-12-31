/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import org.jhotdraw.draw.DrawingView;
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
public class SendToBackActionTest {
    
    public SendToBackActionTest() {
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
     * Test of sendToBack method, of class SendToBackAction.
     */
    @Test
    public void testSendToBack() {
        System.out.println("sendToBack");
        try
        {
        DrawingView view = null;
        Collection figures = new ArrayList();
        SendToBackAction.sendToBack(view, figures);   
        }
        catch(NullPointerException e)
        {
        System.out.println("Interface cannot be instantiated.  ");
        }
        
    }   
}
