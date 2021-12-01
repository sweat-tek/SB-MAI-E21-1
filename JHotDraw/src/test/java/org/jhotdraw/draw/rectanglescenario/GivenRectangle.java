/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.rectanglescenario;

import com.tngtech.jgiven.Stage;
import org.jhotdraw.samples.svg.figures.SVGRectFigure;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
/**
 *
 * @author sebastianbendz
 */
public class GivenRectangle extends Stage<GivenRectangle>{
    
    @ProvidedScenarioState
    protected SVGRectFigure figure;
    
    public GivenRectangle an_rectangle() {
        figure = new SVGRectFigure();
        return self();
    
    }
 
    
}
