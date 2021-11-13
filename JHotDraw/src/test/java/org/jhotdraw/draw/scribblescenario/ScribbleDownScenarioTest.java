package org.jhotdraw.draw.scribblescenario;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

public class ScribbleDownScenarioTest extends ScenarioTest<GivenDrawing, WhenScribble, ThenDrawn> {
    // As a user, I want an option to be able to quickly draw doodles.

    // Given I have a blank sheet,
    // When I scribble down something
    // Then I should see result.

    @Test
    public void user_can_scribble_down_something() {
        given().an_empty_sheet();
        when().the_user_scribbles_down_something();
        then().the_drawing_is_shown_on_the_sheet();
    }
}
