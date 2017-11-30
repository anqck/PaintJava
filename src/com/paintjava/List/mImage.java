package com.paintjava.List;

import java.util.LinkedList;
import java.util.List;

import com.paintjava.tools.BasicTool;

import javafx.scene.paint.Color;



public class mImage {
	
	public List<Point> listpoint ;
	public String name;
	public MyRect boundingbox ;
	public boolean allowShow;
	public boolean allowBounding;
	public Color color;
	public int width;

	
	public void show()
	{
		
	}
	
	public mImage(Color color,int width)
	{
	
		this.width=width;
		this.color=color;
		listpoint = new LinkedList<Point>();
		boundingbox = new MyRect();
		name="";
		allowShow= true;
		allowBounding=false;
	}
	
	
	public void setBoundingBox()
	{
			int minx = listpoint.get(0).x;
			int miny = listpoint.get(0).y;
			int maxx = listpoint.get(0).x;
			int maxy = listpoint.get(0).y;
			for (Point _point : listpoint) {
				if(_point.x<minx) minx=_point.x;
				if(_point.y<miny) miny=_point.y;
				if(_point.x>maxx) maxx=_point.x;
				if(_point.y>maxy) maxy=_point.y;
			}
			minx-=this.width/2;
			miny-=this.width/2;
			maxx+=this.width/2;
			maxy+=this.width/2;
			boundingbox= new MyRect(new Point(minx,miny),new Point(maxx,miny),new Point(maxx,maxy),new Point(minx,maxy));
	}
	public void Tinhtien(Point t,Point r)
	{
		for (Point p : listpoint) {
			p.Tinhtien(t,r);
			}
		boundingbox.Tinhtien(t, r);
		
	}
	public void add(Point t)
	{
		listpoint.add(t);
	}
	public int size()
	{
		return listpoint.size();
	}
	public void clear()
	{
		listpoint.clear();
		this.name="";
		this.boundingbox= new MyRect();
	}
	public void name(String t)
	{
		this.name=t;
	}
	
	


}
