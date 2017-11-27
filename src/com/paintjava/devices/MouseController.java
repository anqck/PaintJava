package com.paintjava.devices;


import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.paintjava.tools.BasicTool;
import com.paintjava.tools.Pen;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

/**
 * Created by jajcek on 19.12.13.
 */ 
public class MouseController implements MouseListener, MouseMotionListener,
		ActionListener {

	private Canvas canvas; // view
	private BasicTool tool; // model
	private Color toolColor; 
	private TextField width;
	private ColorPicker colorpicker;
	private Slider sldwidth;
	

	private int xPos;
	private int yPos;
	private int buttonIdPressed;

	public MouseController(Canvas canvas,TextField width,ColorPicker picker,Slider sldwidth) {
		this.canvas = canvas;
		this.width = width;
		this.colorpicker=picker;
		this.sldwidth=sldwidth;
		
		
		this.colorpicker.setValue(Color.CADETBLUE);
		
		
					
		tool = new Pen(canvas);
		tool.setColor(colorpicker.getValue());
			
		
		this.colorpicker.setOnAction(ActionEvent -> {
			tool.setColor(colorpicker.getValue());	      
		    });
		
		
		
		canvas.setOnMousePressed(e->{
			if (e.getButton()==MouseButton.PRIMARY)
			{
				xPos = (int)e.getX();
				yPos = (int)e.getY();
	            tool.draw(xPos, yPos,xPos , yPos);
	           
			}
		});
		canvas.setOnMouseDragged(e -> {
			if (e.getButton()==MouseButton.PRIMARY)
			{
			   int currentX = (int)e.getX();
	           int currentY = (int)e.getY();
	           tool.draw(xPos, yPos,currentX , currentY);
		         xPos = currentX;
		         yPos = currentY;
			}
        
       });
		width.textProperty().addListener((e) -> {
		    tool.setWidth(Integer.valueOf(width.getText()));
		    
		    if(width.getText()!="")
		    	sldwidth.setValue(Integer.parseInt(width.getText()));
		    		    	
		});
		sldwidth.valueProperty().addListener((e)->{
			width.setText(Integer.toString((int)sldwidth.getValue()));
		});


	}
	
	

	public BasicTool getTool() {
		return tool;
	}
	public void setTool(BasicTool tool) {
		this.tool = tool;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			buttonIdPressed = 1;
		}
		xPos = e.getX();
		yPos = e.getY();
		if (tool != null && buttonIdPressed == 1) {
			draw(e);
		}
		      
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttonIdPressed = -1;
		if (tool != null) // leciał null pointer ;/
			tool.stopDrawing();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (tool != null && buttonIdPressed == 1) {
			draw(e);
		}

		xPos = e.getX();
		yPos = e.getY();
	}

    private void draw(MouseEvent e) {
        tool.setColor(toolColor);
        tool.draw(xPos, yPos, e.getX(), e.getY());
   }

	@Override
	public void mouseMoved(MouseEvent e) {
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}


}
