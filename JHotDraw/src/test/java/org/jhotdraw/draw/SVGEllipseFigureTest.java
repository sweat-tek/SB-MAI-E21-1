package org.jhotdraw.draw;

import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SVGEllipseFigureTest {
    SVGEllipseFigure ellipseFigure;

    @Before
    public void testInit() {
        ellipseFigure = new SVGEllipseFigure(100.0, 100.0, 5.0, 5.0);
    }

    @Test
    public void testEllipseFigure() {
        System.out.println("ellipseFigure");
        assertEquals(100, (int)ellipseFigure.getX());
        assertEquals(100, (int)ellipseFigure.getY());
        assertEquals(5, (int)ellipseFigure.getWidth());
        assertEquals(5, (int)ellipseFigure.getHeight());
    }

    @Test
    public void testGetWidthExpansion() {
        System.out.println("getWidthExpansion");
        assertEquals(1, (int)ellipseFigure.getWidthExpansion());
    }

    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SVGEllipseFigure figure = new SVGEllipseFigure(1, 1, 0, 0);
        assertTrue(figure.isEmpty());
    }
}
