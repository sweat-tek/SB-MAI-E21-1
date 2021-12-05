package org.jhotdraw.draw.ellipseScenario;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class CreateEllipseScenario extends ScenarioTest<GivenEllipse, WhenGivenAttributes, ThenEllipse> {
    @Test
    public void create_new_ellipse() {
        given().an_ellipse();
        when().given_attributes();
        then().ellipse();
    }
}
