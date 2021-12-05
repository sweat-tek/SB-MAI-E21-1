package org.jhotdraw.draw.ellipseScenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;

public class GivenEllipse extends Stage<GivenEllipse> {
    @ProvidedScenarioState
    protected SVGEllipseFigure figure;

    public GivenEllipse an_ellipse() {
        figure = new SVGEllipseFigure();
        return self();
    }
}
