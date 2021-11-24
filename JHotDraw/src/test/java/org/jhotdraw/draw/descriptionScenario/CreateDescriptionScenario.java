/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.descriptionScenario;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author tjell
 */
public class CreateDescriptionScenario extends
        ScenarioTest<GivenDescription, WhenDescriptionCreated, ThenClearDescriptionIsCreated>{
    
    //Acceptance Text
    /**
     * Given I have an area that need a textual description 
     * When I add the text
     * Then I have created a clear describtion
     */
    
    @Test
    public void clear_describtion_has_been_created() {
        given().area_with_no_or_bad_description();
        when().clear_description_has_been_made();
        then().the_text_description_has_been_added();
    }
}
