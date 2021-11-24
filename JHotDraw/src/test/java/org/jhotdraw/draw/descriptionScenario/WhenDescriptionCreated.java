/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.descriptionScenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

/**
 *
 * @author tjell
 */
public class WhenDescriptionCreated extends Stage<WhenDescriptionCreated> {
    
    @ExpectedScenarioState
    protected SVGTextFigure figure;

    public WhenDescriptionCreated clear_description_has_been_made(){
        figure.setText("This is a description");
        return self();
    }    
}
