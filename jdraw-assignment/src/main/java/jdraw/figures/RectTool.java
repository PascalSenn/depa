/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.figures;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import jdraw.framework.DrawContext;
import jdraw.framework.DrawTool;
import jdraw.framework.DrawView;

/**
 * This tool defines a mode for drawing rectangles.
 *
 * @author Christoph Denzler
 * @see jdraw.framework.Figure
 */
public class RectTool extends RectangularShapeTool {


    /**
     * Create a new rectangle tool for the given context.
     *
     * @param context a context to use this tool in.
     */
    public RectTool(DrawContext context) {
        super("Rectangle", context);
    }


    @Override
    public FigureRectangularShape createFigure(int x, int y) {
        return new Rect(x, y, 0, 0);
    }

    @Override
    public void updateFigure(int x, int y) {
        newShape.setBounds(anchor, new Point(x, y));
    }
}
