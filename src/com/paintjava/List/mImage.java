package com.paintjava.List;

import java.util.LinkedList;
import java.util.List;



public class mImage {
	
	private List<Point> listpoint ;
	public String name;
	public MyRect boundingbox ;
	
	
	public mImage()
	{
		listpoint = new LinkedList<Point>();
		boundingbox = new MyRect();
		name="";
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
			boundingbox= new MyRect(new Point(minx,miny),new Point(maxx,miny),new Point(maxx,maxy),new Point(minx,maxy));
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
