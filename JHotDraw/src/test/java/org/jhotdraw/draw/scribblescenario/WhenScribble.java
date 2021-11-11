package org.jhotdraw.draw.scribblescenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.geom.BezierPath;

public class WhenScribble extends Stage<WhenScribble> {
    @ExpectedScenarioState
    protected BezierFigure figure;

    public WhenScribble the_user_scribbles_down_something() {
        addNodes();
        return self();
    }

    private void addNodes() {
        figure.addNode(new BezierPath.Node(194.000000,122.000000));
        figure.addNode(new BezierPath.Node(191.000000,249.000000));
        figure.addNode(new BezierPath.Node(190.000000,249.000000));
        figure.addNode(new BezierPath.Node(190.000000,250.000000));
        figure.addNode(new BezierPath.Node(201.100000,207.900000));
        figure.addNode(new BezierPath.Node(220.800000,194.500000));
        figure.addNode(new BezierPath.Node(226.000000,210.800000));
        figure.addNode(new BezierPath.Node(224.000000,248.000000));
        figure.addNode(new BezierPath.Node(264.000000,226.700000));
        figure.addNode(new BezierPath.Node(274.000000,198.000000));
        figure.addNode(new BezierPath.Node(258.900000,214.200000));
        figure.addNode(new BezierPath.Node(253.300000,242.100000));
        figure.addNode(new BezierPath.Node(270.000000,247.900000));
        figure.addNode(new BezierPath.Node(292.200000,219.600000));
        figure.addNode(new BezierPath.Node(306.000000,138.000000));
        figure.addNode(new BezierPath.Node(305.000000,138.000000));
        figure.addNode(new BezierPath.Node(296.100000,185.300000));
        figure.addNode(new BezierPath.Node(289.000000,258.000000));
        figure.addNode(new BezierPath.Node(296.400000,257.700000));
        figure.addNode(new BezierPath.Node(304.100000,248.900000));
        figure.addNode(new BezierPath.Node(312.700000,227.900000));
        figure.addNode(new BezierPath.Node(332.000000,142.000000));
        figure.addNode(new BezierPath.Node(333.000000,142.000000));
        figure.addNode(new BezierPath.Node(333.000000,141.000000));
        figure.addNode(new BezierPath.Node(309.000000,265.000000));
        figure.addNode(new BezierPath.Node(321.000000,264.900000));
        figure.addNode(new BezierPath.Node(343.000000,235.100000));
        figure.addNode(new BezierPath.Node(355.000000,211.000000));
        figure.addNode(new BezierPath.Node(356.000000,211.000000));
        figure.addNode(new BezierPath.Node(336.100000,248.800000));
        figure.addNode(new BezierPath.Node(335.000000,265.000000));
        figure.addNode(new BezierPath.Node(335.000000,266.000000));
        figure.addNode(new BezierPath.Node(349.800000,266.700000));
        figure.addNode(new BezierPath.Node(365.000000,255.000000));
        figure.addNode(new BezierPath.Node(371.000000,216.000000));
    }

}
