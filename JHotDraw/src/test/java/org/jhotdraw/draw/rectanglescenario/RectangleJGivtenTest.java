package org.jhotdraw.draw.rectanglescenario;


import org.junit.Test;
import com.tngtech.jgiven.junit.ScenarioTest;

public class RectangleJGivtenTest extends ScenarioTest<GivenRectangle, WhenGivenAttributes, ThenRectangle> {
    
    @Test
    public void create_new_square() {
        given().an_rectangle();
        when().given_attributes();
        then().then_rectangle();
    
        
    
    }
    
    
}
