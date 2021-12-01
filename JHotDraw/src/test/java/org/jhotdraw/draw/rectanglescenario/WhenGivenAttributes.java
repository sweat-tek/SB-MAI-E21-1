/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jhotdraw.draw.rectanglescenario;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import java.awt.geom.Point2D;
import java.util.Map;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
/**
 *
 * @author sebastianbendz
 */
public class WhenGivenAttributes extends Stage<WhenGivenAttributes> {
    
    @ExpectedScenarioState
    protected SVGRectFigure figure;
    
    @ProvidedScenarioState
    protected Map<AttributeKey, Object> attributes;
    
    @ProvidedScenarioState
    double width = 60;
    
    @ProvidedScenarioState
    double height = 60;
    
    @ProvidedScenarioState
    double pointDouble = 50;
    
    @ProvidedScenarioState
    double pointDoubleTwo = 20;
    
    public WhenGivenAttributes given_attributes() {
        figure.setBounds(new Point2D.Double(pointDouble, pointDouble),new Point2D.Double(pointDoubleTwo, pointDoubleTwo));
        figure.setArc(width, height);
        return self();
    }
    
}
