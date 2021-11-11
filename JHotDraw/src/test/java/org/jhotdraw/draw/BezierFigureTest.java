package org.jhotdraw.draw;

import org.jhotdraw.geom.BezierPath;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class BezierFigureTest {
    BezierFigure figure;
    Random random;

    @Before
    public void setup() {
        figure = new BezierFigure();
        random = new Random();
    }

    @Test
    public void testAddNode() {
        Assert.assertEquals(0, figure.getNodeCount());

        addNode();
        Assert.assertEquals(1, figure.getNodeCount());

        addNode();
        Assert.assertEquals(2, figure.getNodeCount());
    }

    @Test
    public void testChangedBounds2D() {
        Rectangle2D bounds = figure.getBezierPath().getBounds2D();
        Assert.assertNotNull(bounds);

        double x = bounds.getX();
        double y = bounds.getY();
        addNode(0.9, 0.9);
        bounds = figure.getBezierPath().getBounds2D();
        Assert.assertTrue(x != bounds.getX());
        Assert.assertTrue(y != bounds.getY());

        x = bounds.getX();
        y = bounds.getY();
        addNode(0.2, 0.2);
        bounds = figure.getBezierPath().getBounds2D();
        Assert.assertTrue(x != bounds.getX());
        Assert.assertTrue(y != bounds.getY());
    }

    private void addNode() {
        figure.addNode(new BezierPath.Node(new Point2D.Double(random.nextDouble(), random.nextDouble())));
    }

    private void addNode(double x, double y) {
        figure.addNode(new BezierPath.Node(new Point2D.Double(x, y)));
    }
}
