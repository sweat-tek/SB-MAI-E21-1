package org.jhotdraw.gui.plaf.palettescenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import org.jhotdraw.gui.JFontChooser;
import org.jhotdraw.gui.plaf.palette.PaletteFontChooserUI;
import org.junit.Assert;

public class ThenPaletteFontChooserUI extends Stage<ThenPaletteFontChooserUI> {
  @ProvidedScenarioState
  protected JFontChooser fontChooser;

  @ProvidedScenarioState
  protected ActionListenerImplementation actionListenerImplementation;

  @ProvidedScenarioState
  protected PaletteFontChooserUI paletteFontChooserUI;

  public ThenPaletteFontChooserUI fontHasBeenChosen() {

    // Check that the font event was dispatched properly when the user selected it
    Assert.assertTrue(actionListenerImplementation.getFontHasBeenChosen());

    return self();
  }
}
