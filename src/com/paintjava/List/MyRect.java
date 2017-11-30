package com.paintjava.List;

public class MyRect {
	//theo kim dong ho 
	public Point p1; //(x;y)
	public Point p2; //(X;y)
	public Point p3; //(X;Y)
	public Point p4; //(x;Y)
	
	public MyRect() {
	// TODO Auto-generated constructor stub
		p1=p2=p3=p4=new Point(0,0);
	}
	public MyRect(Point traitren, Point phaitren, Point phaiduoi, Point traiduoi) {
		// TODO Auto-generated constructor stub
			this.p1=traitren;
			this.p2=phaitren;
			this.p3=phaiduoi;
			this.p4=traiduoi;
	}
	public void Tinhtien(Point t,Point r)
	{
		p1.Tinhtien(t,r);
		p2.Tinhtien(t,r);
		p3.Tinhtien(t,r);
		p4.Tinhtien(t,r);
	}
	public void Zoom(float k)
	{
		p1.Zoom(k);
		p2.Zoom(k);
		p3.Zoom(k);
		p4.Zoom(k);
	}
	public Point Tam()
	{
		return p1.trungdiem(p3);
	}
}
