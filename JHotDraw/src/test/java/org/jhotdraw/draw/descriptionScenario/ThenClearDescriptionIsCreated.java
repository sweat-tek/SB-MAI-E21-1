/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.descriptionScenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.junit.Assert;

/**
 *
 * @author tjell
 */
public class ThenClearDescriptionIsCreated extends 
        Stage<ThenClearDescriptionIsCreated>{
    
    @ExpectedScenarioState
    protected SVGTextFigure figure;

    public ThenClearDescriptionIsCreated the_text_description_has_been_added() {
        Assert.assertTrue(figure.getText().length() > 4);
        return this;
    }
}
