package com.paintjava.List;

public class Point {
	public float x;
	public float y;

	public Point() {
	// TODO Auto-generated constructor stub
	x=y=0;
	}
	public Point(float a,float b) {
		// TODO Auto-generated constructor stub
		x=a;
		y=b;
	}

	public void Tinhtien(Point t)
	{
		x+=t.x;
		y+=t.y;
	}
	public void Tinhtien(Point t,Point r)
	{
		x+=r.x-t.x;
		y+=r.y-t.y;
	}
	public void Zoom(float k) {
		// TODO Auto-generated method stub
		x*=k;
		y*=k;
	}
	public Point am()
	{
		x*=-1;
		y*=-1;
		return this;
	}
	public Point trungdiem(Point t)
	{
		return new Point((this.x+t.x)/2,(this.y+t.y)/2);
	}
	public float dodai(Point t)
	{
		
		return (float)Math.sqrt((x-t.x)*(x-t.x)+(y-t.y)*(y-t.y));
	}

	
	
}
