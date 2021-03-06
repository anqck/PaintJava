package com.paintjava.tools;

import javafx.scene.canvas.Canvas;

public enum PaintTool {
	PEN,
    SPRAY,
    ERASER,
    BRUSH,
    DRAG,
	BOUDINGTOOL;
    
    public static BasicTool getBasicTool(PaintTool t, Canvas canvas) {
        switch(t){
            case PEN:
                return new Pen(canvas);
            case SPRAY:
       //         return new Spray(canvas);
            case ERASER:
        //        return new Eraser(canvas);
            case BRUSH:
        //        return new Brush(canvas);
            case DRAG:
        //        return new Drag(canvas);
            case BOUDINGTOOL:
            	return new BoudingTool(canvas);
            default:
                return null;
        }
    }
}
