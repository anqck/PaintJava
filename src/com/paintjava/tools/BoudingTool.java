package com.paintjava.tools;

import com.paintjava.List.Point;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

public class BoudingTool extends BasicTool {
	
	public BoudingTool(Canvas canvas) {
		super(canvas);
        toolName = "BoudingTool";
        color = Color.RED;
        width = 1;
	}
	public void drawbouding(Point p1,Point p2,Point p3,Point p4)
	{
		GraphicsContext g2 = canvas.getGraphicsContext2D();
		
		g2.setStroke(getColor()); //mau
     	g2.setLineWidth(getWidth());//kich thuoc
     	g2.setLineCap(StrokeLineCap.ROUND); //lam MIN
     	g2.setLineDashes(7);
     	
     	g2.strokeLine(p1.x, p1.y, p2.x, p2.y);
     	g2.strokeLine(p3.x, p3.y, p2.x, p2.y);
     	g2.strokeLine(p3.x, p3.y, p4.x, p4.y);
     	g2.strokeLine(p1.x, p1.y, p4.x, p4.y);
     	
		g2.setLineDashes(null);
	}
	@Override
	public void useTool(int xStart, int yStart, int xEnd, int yEnd) {
		
//		 GraphicsContext g2 = canvas.getGraphicsContext2D();
//		//Graphics2D image = (Graphics2D) canvas.getImage().getGraphics();
//		
//		//image.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//		//		RenderingHints.VALUE_ANTIALIAS_ON);
//
//	//	image.setColor(getColor());
//	//	image.setStroke(new BasicStroke(1)); //damy na pen zawsze jeden, pędzel będzie miał możliwość zmiany
//		//image.drawLine(xStart, yStart, xEnd, yEnd);
//		 
//		g2.setStroke(getColor()); //mau
//     	g2.setLineWidth(getWidth());//kich thuoc
//     	g2.setLineCap(StrokeLineCap.ROUND); //lam MIN
//     	
//     	 g2.strokeLine(xStart, yStart, xEnd, yEnd);
		 
		 
     	// g2.strokeOval(oldX, oldY, 9, 9);
     
	}
}
