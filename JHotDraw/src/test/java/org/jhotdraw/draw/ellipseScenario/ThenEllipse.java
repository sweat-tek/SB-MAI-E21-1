package org.jhotdraw.draw.ellipseScenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;

import static org.junit.Assert.*;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ThenEllipse extends Stage<ThenEllipse> {
    @ExpectedScenarioState
    protected SVGEllipseFigure figure;

    @ExpectedScenarioState
    double anchor;

    @ExpectedScenarioState
    double lead;

    public ThenEllipse ellipse() {
        Rectangle2D.Double bounds = figure.getBounds();

        assertEquals((int)anchor, (int)bounds.width);
        assertEquals((int)lead, (int)bounds.height);

        return self();
    }
}
