/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.rectanglescenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import org.junit.Assert;



/**
 *
 * @author sebastianbendz
 */
public class ThenRectangle extends Stage<ThenRectangle>{
    
    @ExpectedScenarioState
    protected SVGRectFigure figure;
    
    @ExpectedScenarioState
    double pointDouble;
    
    @ExpectedScenarioState
    double pointDoubleTwo;
    
    
    
    public ThenRectangle then_rectangle() {

        System.out.println(pointDouble + " " + pointDoubleTwo + " " + figure.getArcHeight() + " " + figure.getArcWidth());
        Assert.assertTrue(figure.getArcHeight() == (pointDouble-pointDoubleTwo)/2);
        Assert.assertTrue(figure.getArcWidth() == (pointDouble-pointDoubleTwo)/2);
        return self();
    }
    
}
