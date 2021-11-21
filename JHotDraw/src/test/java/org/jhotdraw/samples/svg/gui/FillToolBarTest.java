/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui;

import javax.swing.JComponent;
import javax.swing.JPanel;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emilklindt
 */
public class FillToolBarTest {
    @Test
    public void testCreateDisclosedComponentHiddenState() {
        FillToolBar fillToolBar = new FillToolBar(); 
       
        JComponent disclosedComponentHidden = fillToolBar.createDisclosedComponent(0);
        assertNull(disclosedComponentHidden);
    }
    
    @Test
    public void testCreateDisclosedComponentMinimizedState() {
        FillToolBar fillToolBar = new FillToolBar();
        fillToolBar.setEditor(new DefaultDrawingEditor());
       
        JComponent disclosedComponentMinimized = fillToolBar.createDisclosedComponent(1);
        
        assertTrue(disclosedComponentMinimized instanceof JPanel);
        assertEquals(2, disclosedComponentMinimized.getComponentCount());
    }
    
    @Test
    public void testCreateDisclosedComponentOpenState() {
        FillToolBar fillToolBar = new FillToolBar();
        fillToolBar.setEditor(new DefaultDrawingEditor());
        
        JComponent disclosedComponentOpen = fillToolBar.createDisclosedComponent(2);
        
        assertTrue(disclosedComponentOpen instanceof JPanel);
        assertEquals(3, disclosedComponentOpen.getComponentCount());
    }
    
    @Test
    public void testGetID() {
        FillToolBar fillToolBar = new FillToolBar(); 
       
        assertEquals(fillToolBar.getID(), "fill");
    }
    
    
}
