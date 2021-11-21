package org.jhotdraw.draw.scribblescenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.BezierFigure;

public class GivenDrawing extends Stage<GivenDrawing> {
    @ProvidedScenarioState
    protected BezierFigure figure;

    public GivenDrawing an_empty_sheet() {
        figure = new BezierFigure();
        return self();
    }
}
