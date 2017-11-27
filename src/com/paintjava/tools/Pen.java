package com.paintjava.tools;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;

/**
 * Created by jajcek on 21.12.13.
 */
public class Pen extends BasicTool {
	public Pen(Canvas canvas) {
		super(canvas);
        toolName = "Pen";
        color = Color.BLACK;
        width = 3;
	}

	@Override
	public void useTool(int xStart, int yStart, int xEnd, int yEnd) {
		
		 GraphicsContext g2 = canvas.getGraphicsContext2D();
		//Graphics2D image = (Graphics2D) canvas.getImage().getGraphics();
		
		//image.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		//		RenderingHints.VALUE_ANTIALIAS_ON);

	//	image.setColor(getColor());
	//	image.setStroke(new BasicStroke(1)); //damy na pen zawsze jeden, pędzel będzie miał możliwość zmiany
		//image.drawLine(xStart, yStart, xEnd, yEnd);
		 
		g2.setStroke(getColor()); //mau
     	g2.setLineWidth(getWidth());//kich thuoc
     	g2.setLineCap(StrokeLineCap.ROUND); //lam MIN
     	
     	 g2.strokeLine(xStart, yStart, xEnd, yEnd);
		 
		 
     	// g2.strokeOval(oldX, oldY, 9, 9);
     	     	
		 
  		
	}
}
