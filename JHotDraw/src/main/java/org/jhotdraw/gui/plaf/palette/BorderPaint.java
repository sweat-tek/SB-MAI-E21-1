package org.jhotdraw.gui.plaf.palette;

import java.awt.*;
import org.jhotdraw.geom.Dimensions2D;
import org.jhotdraw.geom.Position2D;

import javax.swing.*;
import java.awt.geom.Point2D;
import org.apache.batik.ext.awt.LinearGradientPaint;
import org.apache.batik.ext.awt.MultipleGradientPaint;

public abstract class BorderPaint {
  public void paintBorderImplementation(Component c, Graphics gr, Position2D pos, Dimensions2D dim,
      float[] enabledStops, Color[] enabledStopColors, int borderColor, float[] stops, Color[] stopColors) {

    Graphics2D g = (Graphics2D) gr;
    int width = dim.getWidth();
    int height = dim.getHeight();

    String segmentPosition = getSegmentPosition(c);
    if (segmentPosition == "first" || segmentPosition == "middle") {
      width += 1;
    }
    g.setColor(new Color(borderColor, true));
    g.drawRect(pos.getX(), pos.getY(), width - 1, height - 1);

    LinearGradientPaint lgp = new LinearGradientPaint(
        new Point2D.Float(pos.getX(), pos.getY()), new Point2D.Float(pos.getX(), pos.getY() + height - 1),
        stops, stopColors,
        MultipleGradientPaint.REPEAT,
        MultipleGradientPaint.LINEAR_RGB);
    g.setPaint(lgp);
    g.fillRect(pos.getX() + 1, pos.getY() + 1, width - 2, height - 2);
  }

  public String getSegmentPosition(Component c) {
    String segmentPosition = null;
    if (c instanceof JComponent) {
      segmentPosition = (String) ((JComponent) c).getClientProperty("Palette.Component.segmentPosition");
    }
    return (segmentPosition == null) ? "only" : segmentPosition;
  }

  public Insets getBorderInsets(Component c) {
    Insets insets;
    String segmentPosition = getSegmentPosition(c);
    if (segmentPosition == "first" ||
        segmentPosition == "middle") {
      insets = new Insets(3, 3, 3, 2);
    } else {
      insets = new Insets(3, 3, 3, 3);
    }
    return insets;
  }

  public boolean isBorderOpaque() {
    return true;
  }
}
