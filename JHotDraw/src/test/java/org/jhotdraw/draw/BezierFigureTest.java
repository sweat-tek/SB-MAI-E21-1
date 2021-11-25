package org.jhotdraw.draw;

import org.jhotdraw.geom.BezierPath;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BezierFigureTest {
    private BezierFigure figure;
    private Random random;
    private List<BezierPath.Node> nodes;

    @Before
    public void setup() {
        figure = new BezierFigure();
        random = new Random();
        nodes = new ArrayList<>();
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

    @Test
    public void testCappedPath() {
        Assert.assertEquals(0, figure.getCappedPath().size());

        addNode();
        Assert.assertEquals(1, figure.getCappedPath().size());

        addNode();
        Assert.assertEquals(2, figure.getCappedPath().size());

        // Compare the coordinates of the nodes in getCappedPath() to the nodes added.
        for (int i = 0; i < nodes.size(); i++) {
            Assert.assertEquals(nodes.get(i).x[0], figure.getCappedPath().get(i).x[0], 0.0);
            Assert.assertEquals(nodes.get(i).y[0], figure.getCappedPath().get(i).y[0], 0.0);
        }
    }

    private void addNode() {
        BezierPath.Node node = new BezierPath.Node(new Point2D.Double(random.nextDouble(), random.nextDouble()));
        nodes.add(node);
        figure.addNode(node);
    }

    private void addNode(double x, double y) {
        figure.addNode(new BezierPath.Node(new Point2D.Double(x, y)));
    }
}
