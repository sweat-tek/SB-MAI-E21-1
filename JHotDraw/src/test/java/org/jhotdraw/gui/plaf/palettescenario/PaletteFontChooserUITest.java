package org.jhotdraw.gui.plaf.palettescenario;

import com.tngtech.jgiven.junit.ScenarioTest;

import org.junit.Test;

public class PaletteFontChooserUITest
    extends ScenarioTest<GivenPaletteFontChooserUI, WhenPaletteFontChooserUI, ThenPaletteFontChooserUI> {

  @Test
  public void calltestsomething() {
    given().fontSelectionUnitCreated();
    when().theUserConfirmsFontSelection();
    then().fontHasBeenChosen();
  }
}
