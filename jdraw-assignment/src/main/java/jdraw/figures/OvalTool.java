/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved.
 */

package jdraw.figures;

import jdraw.framework.DrawContext;

import java.awt.*;

/**
 * This tool defines a mode for drawing circles.
 *
 * @author Christoph Denzler
 * @see jdraw.framework.Figure
 */
public class OvalTool extends RectangularShapeTool {

	/**
	 * Create a new rectangle tool for the given context.
	 *
	 * @param context a context to use this tool in.
	 */
	public OvalTool(DrawContext context) {
		super("Oval", context);
	}


	@Override
	public FigureRectangularShape createFigure(int x, int y) {
		return new Oval(x, y, 0, 0);
	}

	@Override
	public void updateFigure(int x, int y) {
		newShape.setBounds(anchor, new Point(x,y));
	}
}
