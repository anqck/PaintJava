package com.paintjava.tools;

import java.util.List;

import com.paintjava.List.MyRect;
import com.paintjava.List.Point;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

/**
 * Created by jajcek on 21.12.13.
 */
public abstract class BasicTool {
	protected Canvas canvas;

    protected String toolName = "";

	protected Color color = Color.BLACK;
	protected int width = 3;

	public BasicTool(Canvas canvas) {
		this.canvas = canvas;
	}

	public void draw(int xStart, int yStart, int xEnd, int yEnd){
		useTool(xStart, yStart,xEnd,yEnd);
		
	}
	public void draw(List<Point> list,Color co,int width){
		 GraphicsContext g2 = canvas.getGraphicsContext2D();
						 
			g2.setStroke(co); //mau
			g2.setLineWidth(width);//kich thuoc
	     	g2.setLineCap(StrokeLineCap.ROUND); //lam MIN
	     	
	     	g2.strokeLine(list.get(0).x, list.get(0).y, list.get(0).x, list.get(0).y);
	     	for (int i = 0; i < list.size()-1; i++) {
	     		g2.strokeLine(list.get(i).x, list.get(i).y, list.get(i+1).x, list.get(i+1).y);
			}
		
	}
	public void draw(MyRect rect){
		GraphicsContext g2 = canvas.getGraphicsContext2D();
		
		g2.setStroke(Color.RED); //mau
	 	g2.setLineWidth(1);//kich thuoc
	 	g2.setLineCap(StrokeLineCap.ROUND); //lam MIN
	 	g2.setLineDashes(7);
	 	
	 	g2.strokeLine(rect.p1.x, rect.p1.y, rect. p2.x, rect. p2.y);
	 	g2.strokeLine(rect.p3.x, rect.p3.y, rect.p2.x, rect.p2.y);
	 	g2.strokeLine(rect.p3.x, rect.p3.y, rect. p4.x, rect.p4.y);
	 	g2.strokeLine(rect.p1.x, rect.p1.y, rect.p4.x, rect.p4.y);
	 	
		g2.setLineDashes(null);
		
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
