/*
 * Copyright (c) 2018 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package jdraw.std;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import jdraw.framework.DrawCommandHandler;
import jdraw.framework.DrawModel;
import jdraw.framework.DrawModelEvent;
import jdraw.framework.DrawModelListener;
import jdraw.framework.Figure;
import jdraw.framework.FigureEvent;
import jdraw.framework.FigureListener;

/**
 * Provide a standard behavior for the drawing model. This class initially does not implement the methods
 * in a proper way.
 * It is part of the course assignments to do so.
 * @author TODO add your name here
 *
 */
public class StdDrawModel implements DrawModel, FigureListener {
	private final List<Figure> figures = new ArrayList<Figure>();
	private final List<DrawModelListener> modelChangeListeners = new ArrayList<DrawModelListener>();
	
	@Override
	public void addFigure(Figure f) {
		registerFigureListener(f);
		figures.add(f);
	}

	@Override
	public Stream<Figure> getFigures() { 
		return figures.stream();
	}

	@Override
	public void removeFigure(Figure f) {
		unregisterFigureListener(f);
		figures.remove(f);
	}
	
	@Override
	public void addModelChangeListener(DrawModelListener listener) {
		modelChangeListeners.add(listener);
	}

	@Override
	public void removeModelChangeListener(DrawModelListener listener) {
		modelChangeListeners.remove(listener);
	}

	/** The draw command handler. Initialized here with a dummy implementation. */
	// TODO initialize with your implementation of the undo/redo-assignment.
	private DrawCommandHandler handler = new EmptyDrawCommandHandler();

	/**
	 * Retrieve the draw command handler in use.
	 * @return the draw command handler.
	 */
	@Override
	public DrawCommandHandler getDrawCommandHandler() {
		return handler;
	}

	@Override
	public void setFigureIndex(Figure f, int index) {
		// TODO to be implemented  
		System.out.println("StdDrawModel.setFigureIndex has to be implemented");
	}

	@Override
	public void removeAllFigures() { 
		for (var iterator = figures.iterator(); iterator.hasNext();) {
		    var figure = iterator.next(); 
		    unregisterFigureListener(figure);
		    iterator.remove();
		} 
	}

	@Override
	public void figureChanged(FigureEvent e) { 
		handleFigureChanged(e.getFigure());
	}

	private void handleFigureChanged(Figure f) {
		notifyDrawModelListeners(new DrawModelEvent(this,f , DrawModelEvent.Type.FIGURE_CHANGED )); 
	}

	private void handleFigureAdd(Figure f) {
		notifyDrawModelListeners(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_ADDED )); 
	}

	private void handleFigureRemoved(Figure f) {
		notifyDrawModelListeners(new DrawModelEvent(this, f, DrawModelEvent.Type.FIGURE_REMOVED )); 
	}
	
	private void notifyDrawModelListeners(DrawModelEvent e) {
		for(var listener: modelChangeListeners ) {
			listener.modelChanged(e);
		}
	}
	
	private void unregisterFigureListener(Figure f) { 
		f.removeFigureListener(this);
		handleFigureRemoved(f);
	}

	
	private void registerFigureListener(Figure f) {
		f.addFigureListener(this);
		handleFigureAdd(f); 
	}

}
