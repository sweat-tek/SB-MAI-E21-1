package org.jhotdraw.geom;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Bounds2DCreator {
    private ArrayList<BezierPath.Node> nodes;
    private transient Rectangle2D.Double bounds;
    private int size;
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private boolean isClosed;

    public Bounds2DCreator(ArrayList<BezierPath.Node> nodes, int size, boolean isClosed) {
        this.nodes = nodes;
        this.size = size;
        this.isClosed = isClosed;
        resetPoints();
    }

    public Rectangle2D.Double createBounds2D() {
        if (size == 0) {
            resetPoints();
        } else {
            handleFirstNode();
            handleLastNode();
            // Handle all other nodes.
            for (int i = 1, n = size - 1; i < n; i++) {
                handleNode(i);
            }
        }

        bounds = new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
        return (Rectangle2D.Double) bounds.clone();
    }

    private void resetPoints() {
        x1 = 0.0f;
        x2 = 0.0f;
        y1 = 0.0f;
        y2 = 0.0f;
    }

    private void findLargest(BezierPath.Node node, int index) {
        double x = node.x[index];
        double y = node.y[index];
        if (x < x1) {
            x1 = x;
        }
        if (y < y1) {
            y1 = y;
        }
        if (x > x2) {
            x2 = x;
        }
        if (y > y2) {
            y2 = y;
        }
    }

    private void handleFirstNode() {
        BezierPath.Node node = nodes.get(0);
        x1 = node.x[0];
        x2 = node.x[0];
        y1 = node.y[0];
        y2 = node.y[0];

        if (isClosed && (node.mask & BezierPath.C1_MASK) != 0) {
            findLargest(node, 1);
        }
        if ((node.mask & BezierPath.C2_MASK) != 0) {
            findLargest(node, 2);
        }
    }

    private void handleLastNode() {
        int last = size - 1;
        BezierPath.Node node = nodes.get(last);
        findLargest(node, 0);
        if ((node.mask & BezierPath.C1_MASK) != 0) {
            findLargest(node, 1);
        }
        if (isClosed && (node.mask & BezierPath.C2_MASK) != 0) {
            findLargest(node, 2);
        }
    }

    private void handleNode(int index) {
        BezierPath.Node node = nodes.get(index);
        findLargest(node, 0);
        if ((node.mask & BezierPath.C1_MASK) != 0) {
            findLargest(node, 1);
        }
        if ((node.mask & BezierPath.C2_MASK) != 0) {
            findLargest(node, 2);
        }
    }
}
