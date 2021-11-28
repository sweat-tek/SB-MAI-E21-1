/**
 * @(#)PaletteTextComponentBorder.java  1.0  Apr 6, 2008
 *
 * Copyright (c) 2008 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.gui.plaf.palette;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;
import org.jhotdraw.geom.Dimensions2D;
import org.jhotdraw.geom.Position2D;

/**
 * PaletteTextComponentBorder.
 *
 * @author Werner Randelshofer
 *          @version 1.0 Apr 6, 2008 Created.
 */
public class PaletteTextComponentBorder extends BorderPaint implements Border, UIResource {

    private final static float[] enabledStops = new float[] { 0f, 0.2f };
    private final static Color[] enabledStopColors = new Color[] { new Color(0xc8c8c8), new Color(0xffffff) };

    public void paintBorder(Component c, Graphics gr, int x, int y, int width, int height) {
        int borderColor = 0xffa5a5a5;
        float[] stops = enabledStops;
        Color[] stopColors = enabledStopColors;

        if (!c.isEnabled()) {
            borderColor = 0x80a5a5a5;
            stops = enabledStops;
            stopColors = enabledStopColors;
        }

        Position2D pos = new Position2D(x, y);
        Dimensions2D dim = new Dimensions2D(width, height);

        paintBorderImplementation(c, gr, pos, dim, enabledStops, enabledStopColors, borderColor, stops, stopColors);
    }
}
