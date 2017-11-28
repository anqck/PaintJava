package com.paintjava.gui;

import com.paintjava.devices.MouseController;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;




public class MainFrame {
	@FXML
	public Canvas canvas;
	@FXML
	public TextField width;
	@FXML
	public ColorPicker color;
	@FXML
	public Slider sldwidth;
	@FXML
	public ListView listview;

	private MouseController mouseControll;
	
	@FXML
	public void onClear()
	{
		GraphicsContext gc = canvas.getGraphicsContext2D();
	    gc.setFill(Color.WHITE);
	    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}
	@FXML
	public void onExit()
	{
		 Platform.exit();
	}
	
	public void initialize() {
			onClear();
			mouseControll=new MouseController(canvas,width,color,sldwidth,listview);
			
		        
	}
	
}
