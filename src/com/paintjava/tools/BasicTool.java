package com.paintjava.tools;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 * Created by jajcek on 21.12.13.
 */
public abstract class BasicTool {
	protected Canvas canvas;

    protected String toolName = "";

	protected Color color = Color.BLACK;
	protected int width = 1;

	public BasicTool(Canvas canvas) {
		this.canvas = canvas;
	}

	public void draw(int xStart, int yStart, int xEnd, int yEnd){
		useTool(xStart, yStart,xEnd,yEnd);
		
	}
	
	protected abstract void useTool(int xStart, int yStart, int xEnd, int yEnd);

    public void stopDrawing() {}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

    @Override
    public String toString() {
        return toolName;
    }
}
