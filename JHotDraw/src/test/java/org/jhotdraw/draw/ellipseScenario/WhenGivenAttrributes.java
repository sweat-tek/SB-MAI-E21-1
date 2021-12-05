package org.jhotdraw.draw.ellipseScenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.samples.svg.figures.SVGEllipseFigure;

import java.awt.geom.Point2D;
import java.util.Map;

public class WhenGivenAttrributes extends Stage<WhenGivenAttrributes> {
    @ExpectedScenarioState
    protected SVGEllipseFigure figure;

    @ProvidedScenarioState
    protected Map<AttributeKey, Object> attributes;

    @ProvidedScenarioState
    double anchor = 100;

    @ProvidedScenarioState
    double lead = 50;

    public WhenGivenAttrributes given_attributes() {
        figure.setBounds(new Point2D.Double(anchor, anchor), new Point2D.Double(lead, lead));
        return self();
    }
}
