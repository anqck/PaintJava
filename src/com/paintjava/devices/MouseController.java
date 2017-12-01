package com.paintjava.devices;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.util.ArrayList;
import java.util.List;

import com.paintjava.tools.BasicTool;
import com.paintjava.tools.BoudingTool;
import com.paintjava.tools.Pen;
import com.sun.javafx.geom.Rectangle;
import com.paintjava.List.MyRect;
import com.paintjava.List.Point;
import com.paintjava.List.mImage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListView;
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
	public Color toolColor; 
	private TextField width;
	private ColorPicker colorpicker;
	private Slider sldwidth;
	private mImage mimage ;
	private List<mImage> listlayer = new ArrayList<>();
	private ListView listview;
	private Button edit;
	public Button delete;
	public boolean allowedit;
	public boolean allowhandle;
	
	private int curIma;
	private float xPos;
	private float yPos;
	private int buttonIdPressed;

	public MouseController (Canvas canvas,TextField width,ColorPicker picker,Slider sldwidth,ListView listview,Button edit,Button delete) {
		this.canvas = canvas;
		this.width = width;
		this.colorpicker=picker;
		this.sldwidth=sldwidth;
		this.listview=listview;
		this.edit=edit;
		this.delete=delete;
		init();
		
	}
	public void listviewupdate()
	{
		int i=1;
		ObservableList<String> items =FXCollections.observableArrayList ();
		for (mImage img : listlayer) {
			items.add(img.name);
		}
		listview.setItems(items);
	}
	public void repaint()
	{

		GraphicsContext g2 = canvas.getGraphicsContext2D();
		g2.clearRect(0, 0, canvas.getWidth(),canvas.getHeight());
		g2.setFill(Color.WHITE);
		
		g2.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		for (mImage mImage : listlayer) {
				if(mImage.allowShow) 
					tool.draw(mImage.listpoint,mImage.color,mImage.width);
				
				if(mImage.allowBounding)
					tool.draw(mImage.boundingbox);
				
			}
		}
		
	
	public void vebox(mImage img) {
		BoudingTool bt= new BoudingTool(canvas);
		//for (mImage img : listlayer) {
					
			bt.drawbouding(img.boundingbox.p1, img.boundingbox.p2, img.boundingbox.p3, img.boundingbox.p4);
		//}
				 
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
//		if (e.getButton() == MouseEvent.BUTTON1) {
//			buttonIdPressed = 1;
//		}
//		xPos = e.getX();
//		yPos = e.getY();
//		if (tool != null && buttonIdPressed == 1) {
//			draw(e);
//		}
		      
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		buttonIdPressed = -1;
		if (tool != null) // leciał null pointer ;/
			tool.stopDrawing();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
//		if (tool != null && buttonIdPressed == 1) {
//			draw(e);
//		}
//
//		xPos = e.getX();
//		yPos = e.getY();
//	}
//
//    private void draw(MouseEvent e) {
//        tool.setColor(toolColor);
//        tool.draw(xPos, yPos, e.getX(), e.getY());
   }

	@Override
	public void mouseMoved(MouseEvent e) {
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
//	@FXML public void initialize() {
//		// TODO Auto-generated method stub
//		System.out.println("data loanding..............");
//	}
	public void init()
	{
		this.colorpicker.setValue(Color.CADETBLUE);
		this.width.setText("3");
		this.sldwidth.setValue(3);
		curIma=0;
		allowedit=false;
		allowhandle=false;
		tool = new Pen(canvas);
		tool.setColor(colorpicker.getValue());
		tool.setWidth(Integer.valueOf(width.getText()));
			
					
		
		canvas.setOnMousePressed(e->{
			if (e.getButton()==MouseButton.PRIMARY)
			{
				if(!allowhandle)
				{
				mimage=new mImage(tool.getColor(),tool.getWidth());
				mimage.name(Integer.toString(listlayer.size()+1));
				
				xPos = (float)e.getX();
				yPos = (float)e.getY();
	            tool.draw(xPos, yPos,xPos, yPos);
	            mimage.add(new Point(xPos,yPos));
	            System.out.println("point"+ mimage.size());
	                        
				}
				else
				{
					//edithandle
					xPos = (float)e.getX();
					yPos = (float)e.getY();
					
				}
	         
	            	         
			}
			else
			{
				xPos = (float)e.getX();
				yPos = (float)e.getY();
				if(allowhandle)
				{
					GraphicsContext g2 = canvas.getGraphicsContext2D();
            		MyRect rect= listlayer.get(curIma).boundingbox;
            		g2.fillRect(rect.neo1.x-rect.neo1.width/2,rect.neo1.y-rect.neo1.width/2,rect.neo1.width,rect.neo1.height);
            		g2.fillRect(rect.neo2.x-rect.neo2.width/2,rect.neo2.y-rect.neo2.width/2,rect.neo2.width,rect.neo2.height);
            		g2.fillRect(rect.neo3.x-rect.neo3.width/2,rect.neo3.y-rect.neo3.width/2,rect.neo3.width,rect.neo3.height);
            		g2.fillRect(rect.neo4.x-rect.neo4.width/2,rect.neo4.y-rect.neo4.width/2,rect.neo4.width,rect.neo4.height);
				}
			}
			
			
				
		});
		canvas.setOnMouseDragged(e -> {
			if (e.getButton()==MouseButton.PRIMARY)
			{
				if(!allowhandle)
				{
					float currentX = (float)e.getX();
					float currentY = (float)e.getY();
		           tool.draw(xPos, yPos,currentX , currentY);
			         xPos = currentX;
			         yPos = currentY;
			         mimage.add(new Point(xPos,yPos));
			         System.out.println("point"+ mimage.size());
				}
				else
				{
					//edithandle
					float currentX = (float)e.getX();
					float currentY = (float)e.getY();
			        float moi=listlayer.get(curIma).boundingbox.Tam().dodai(new Point(currentX,currentY));
			        float chuan=listlayer.get(curIma).boundingbox.Tam().dodai(listlayer.get(curIma).boundingbox.p1);
//			        if(moi<chuan)
//					listlayer.get(curIma).Zoom(moi/chuan);
//			        else
			        listlayer.get(curIma).Zoom(moi/chuan);	
					repaint();
					GraphicsContext g2 = canvas.getGraphicsContext2D();
            		MyRect rect= listlayer.get(curIma).boundingbox;
            		g2.fillRect(rect.neo1.x-rect.neo1.width/2,rect.neo1.y-rect.neo1.width/2,rect.neo1.width,rect.neo1.height);
            		g2.fillRect(rect.neo2.x-rect.neo2.width/2,rect.neo2.y-rect.neo2.width/2,rect.neo2.width,rect.neo2.height);
            		g2.fillRect(rect.neo3.x-rect.neo3.width/2,rect.neo3.y-rect.neo3.width/2,rect.neo3.width,rect.neo3.height);
            		g2.fillRect(rect.neo4.x-rect.neo4.width/2,rect.neo4.y-rect.neo4.width/2,rect.neo4.width,rect.neo4.height);
										
					xPos = currentX;
			         yPos = currentY;
					
				}
			}
			else {
				int a =listview.getSelectionModel().getSelectedIndex();
				if (a!=-1)
				{
					float currentX = (float)e.getX();
					float currentY = (float)e.getY();
					listlayer.get(a).Tinhtien(new Point(xPos,yPos),new Point(currentX,currentY));
					
				 repaint();
				 xPos = currentX;
		         yPos = currentY;
				}
				
			};
        
       });
		canvas.setOnMouseReleased(e->{
			
			if (e.getButton()==MouseButton.PRIMARY)
			{	
				if(!allowhandle)
				{				
				listlayer.add(mimage);
				System.out.println("layer" + listlayer.size());
				mimage.setBoundingBox();
				listviewupdate();
				
				curIma=listlayer.size()-1;
				listview.getSelectionModel().select(curIma);
				listview.getOnMouseClicked().handle(e);;
				}
				else
				{
					//edithandle
					allowhandle=false;
					repaint();
				}
			}
			
			
			
		});
		canvas.setOnMouseMoved(e->{
			//System.out.println(e.getX());
			if(listlayer.size()!=0)
            {
            	if(listlayer.get(curIma).boundingbox.neo1.contains((int)e.getX(),(int) e.getY()) 
            			||listlayer.get(curIma).boundingbox.neo2.contains((int)e.getX(),(int) e.getY())
            			||listlayer.get(curIma).boundingbox.neo3.contains((int)e.getX(),(int) e.getY())
            			||listlayer.get(curIma).boundingbox.neo4.contains((int)e.getX(),(int) e.getY()))
            	{
            		System.out.println("cho phep edit");
            		allowhandle=true;
            		GraphicsContext g2 = canvas.getGraphicsContext2D();
            		MyRect rect= listlayer.get(curIma).boundingbox;
            		g2.fillRect(rect.neo1.x-rect.neo1.width/2,rect.neo1.y-rect.neo1.width/2,rect.neo1.width,rect.neo1.height);
            		g2.fillRect(rect.neo2.x-rect.neo2.width/2,rect.neo2.y-rect.neo2.width/2,rect.neo2.width,rect.neo2.height);
            		g2.fillRect(rect.neo3.x-rect.neo3.width/2,rect.neo3.y-rect.neo3.width/2,rect.neo3.width,rect.neo3.height);
            		g2.fillRect(rect.neo4.x-rect.neo4.width/2,rect.neo4.y-rect.neo4.width/2,rect.neo4.width,rect.neo4.height);
            		
            	}
            	else
            	{
            		allowhandle=false;
            		repaint();
            	}
            
            }
			
		});
		canvas.setOnScroll(e->{
			
			if(!listlayer.isEmpty())
			{
			if(e.getDeltaY()>0)
			{
			listlayer.get(curIma).Zoom((float)0.9);
			}
			else
			{
			listlayer.get(curIma).Zoom((float)1.1);
			}
			repaint();
			}
			System.out.println(e.getDeltaY());
		});
		
		width.textProperty().addListener((e) -> {
		    tool.setWidth(Integer.valueOf(width.getText()));
		    if(width.getText()!="")
		    	sldwidth.setValue(Integer.parseInt(width.getText()));
		    if(allowedit)
			{
		    listlayer.get(listview.getSelectionModel().getSelectedIndex()).width=tool.getWidth();
		    listlayer.get(listview.getSelectionModel().getSelectedIndex()).setBoundingBox();
		    repaint();
			}
		    		    	
		});
		
		sldwidth.valueProperty().addListener((e)->{
			width.setText(Integer.toString((int)sldwidth.getValue()));
		});
		
		this.colorpicker.setOnAction(ActionEvent -> {
			tool.setColor(colorpicker.getValue());	 
			if(allowedit)
			{
			listlayer.get(listview.getSelectionModel().getSelectedIndex()).color=tool.getColor();
		    repaint();
			}
		    });
		
		listview.setOnMouseClicked(e->{
			System.out.println("da click chuot"+ listview.getSelectionModel().getSelectedIndex());
			if(listview.getSelectionModel().getSelectedIndex() !=-1)
			{
//				if(listview.getSelectionModel().getSelectedIndex()!= curIma)
//				{
//					listlayer.get(curIma).allowBounding=false;
//					listlayer.get(listview.getSelectionModel().getSelectedIndex()).allowBounding=true;
//					curIma=listview.getSelectionModel().getSelectedIndex();
//				}
//				else
//				{listlayer.get(listview.getSelectionModel().getSelectedIndex()).allowBounding=true;}
			
				curIma=listview.getSelectionModel().getSelectedIndex();
				for (int i = 0; i < listlayer.size(); i++) {
					if(i!=curIma)
					{
						listlayer.get(i).allowBounding=false;
					}
				}
				listlayer.get(curIma).allowBounding=true;
			}
			repaint();
			//listlayer.get(listview.getSelectionModel().getSelectedIndex()).allowBounding=false;
		});
		edit.setOnAction(e->{
			
			if(!allowedit)
			{
				edit.setText("Edit:ON");
				allowedit=true;
			}
			else
			{
				edit.setText("Edit:OFF");
				allowedit=false;
			}
		});
		delete.setOnAction(e->{
			//listlayer.remove(curIma);
		//	listview.getItems().remove(listview.getSelectionModel().getSelectedIndex());
			
		});
		
	}
	

}
