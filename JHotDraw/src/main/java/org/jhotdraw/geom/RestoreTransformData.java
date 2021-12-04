package org.jhotdraw.geom;

import org.jhotdraw.samples.svg.Gradient;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class RestoreTransformData {
    private Shape shape;
    private AffineTransform transform;
    private Gradient fill, stroke;

    public RestoreTransformData(Shape shape, AffineTransform transform, Gradient fill, Gradient stroke) {
        this.shape = shape;
        this.transform = transform;
        this.fill = fill;
        this.stroke = stroke;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public AffineTransform getTransform() {
        return transform;
    }

    public void setTransform(AffineTransform transform) {
        this.transform = transform;
    }

    public Gradient getFill() {
        return fill;
    }

    public void setFill(Gradient fill) {
        this.fill = fill;
    }

    public Gradient getStroke() {
        return stroke;
    }

    public void setStroke(Gradient stroke) {
        this.stroke = stroke;
    }
}
