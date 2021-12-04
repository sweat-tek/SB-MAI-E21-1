package org.jhotdraw.gui.plaf.palette;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.swing.JComponent;

import org.junit.Before;
import org.junit.Test;
import java.awt.Insets;

public class BorderPaintTest {

  JComponent jComponent;
  BorderPaint borderPaint;

  @Before
  public void testInit() {
    // Create instances of abstract classes used by different unit tests
    jComponent = new JComponent() {

    };

    borderPaint = new BorderPaint() {

    };
  }

  @Test
  public void testGetSegmentPosition() {
    // Assert it's segment position is only since segmentposition == null
    assertEquals(borderPaint.getSegmentPosition(jComponent), "only");
  }

  // Get border insets
  @Test
  public void testGetBorderInsets() {
    Insets insets = borderPaint.getBorderInsets(jComponent);

    // Make sure the correct dimensions are returned
    assertEquals(insets.right, 3);
    assertEquals(insets.left, 3);
    assertEquals(insets.top, 3);
    assertEquals(insets.bottom, 3);
  }

  @Test
  public void testIsBorderOpaque() {
    assertTrue(borderPaint.isBorderOpaque());
  }
}