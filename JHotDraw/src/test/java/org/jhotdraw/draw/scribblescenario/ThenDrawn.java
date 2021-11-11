package org.jhotdraw.draw.scribblescenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.draw.BezierFigure;
import org.junit.Assert;

public class ThenDrawn extends Stage<ThenDrawn> {
    @ExpectedScenarioState
    protected BezierFigure figure;

    public ThenDrawn the_drawing_is_shown_on_the_sheet() {
        Assert.assertTrue(figure.getNodeCount() > 0);
        return self();
    }
}
