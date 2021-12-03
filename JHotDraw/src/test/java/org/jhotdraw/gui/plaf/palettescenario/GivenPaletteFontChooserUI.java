package org.jhotdraw.gui.plaf.palettescenario;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;

import org.jhotdraw.gui.JFontChooser;
import org.jhotdraw.gui.plaf.palette.PaletteFontChooserUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ActionListenerImplementation implements ActionListener {
  private boolean fontHasBeenChosen = false;

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == JFontChooser.APPROVE_SELECTION) {
      fontHasBeenChosen = true;
    }
  }

  public boolean getFontHasBeenChosen() {
    return this.fontHasBeenChosen;
  }
}

public class GivenPaletteFontChooserUI extends Stage<GivenPaletteFontChooserUI> {
  @ProvidedScenarioState
  protected JFontChooser fontChooser;

  @ProvidedScenarioState
  protected ActionListenerImplementation actionListenerImplementation;

  @ProvidedScenarioState
  protected PaletteFontChooserUI paletteFontChooserUI;

  public GivenPaletteFontChooserUI fontSelectionUnitCreated() {
    fontChooser = new JFontChooser();
    actionListenerImplementation = new ActionListenerImplementation();
    fontChooser.addActionListener(actionListenerImplementation);
    paletteFontChooserUI = new PaletteFontChooserUI(fontChooser);
    return self();
  }

}
