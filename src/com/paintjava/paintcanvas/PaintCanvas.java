package com.paintjava.paintcanvas;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;

public class PaintCanvas {
	@FXML
    protected Canvas canvas;
	

	 public PaintCanvas() {
		 FXMLLoader fxmlLoader = new FXMLLoader(
	                getClass().getResource("PaintCanvas.fxml"));

	        fxmlLoader.setRoot(this);
	        fxmlLoader.setController(this);

	        try {
	            fxmlLoader.load();
	        } catch (IOException exception) {
	            throw new RuntimeException(exception);
	        }

	   }
	 
	 public void  Temp()
	 {
		 
	 }
}
