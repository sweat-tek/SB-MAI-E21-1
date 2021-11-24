/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.descriptionScenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;

/**
 *
 * @author tjell
 */
public class GivenDescription extends Stage<GivenDescription> {

    @ProvidedScenarioState
    protected SVGTextFigure figure;

    public GivenDescription area_with_no_or_bad_description(){
        figure = new SVGTextFigure();
        return self();
    }
}
