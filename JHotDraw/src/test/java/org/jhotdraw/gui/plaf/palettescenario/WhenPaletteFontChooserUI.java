package org.jhotdraw.gui.plaf.palettescenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import org.jhotdraw.gui.JFontChooser;
import org.jhotdraw.gui.plaf.palette.PaletteFontChooserUI;

public class WhenPaletteFontChooserUI extends Stage<WhenPaletteFontChooserUI> {
  @ProvidedScenarioState
  protected JFontChooser fontChooser;

  @ProvidedScenarioState
  protected ActionListenerImplementation actionListenerImplementation;

  @ProvidedScenarioState
  protected PaletteFontChooserUI paletteFontChooserUI;

  public WhenPaletteFontChooserUI theUserConfirmsFontSelection() {
    paletteFontChooserUI.installUI(fontChooser);

    // The user has approved the font selection this fires an action
    fontChooser.approveSelection();
    return self();
  }
}