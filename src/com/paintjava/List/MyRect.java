package com.paintjava.List;

import com.sun.javafx.geom.Rectangle;

public class MyRect {
	//theo kim dong ho 
	public Point p1; //(x;y)
	public Point p2; //(X;y)
	public Point p3; //(X;Y)
	public Point p4; //(x;Y)
	public Rectangle neo1;
	public Rectangle neo2;
	public Rectangle neo3;
	public Rectangle neo4;
	
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
			neo1=new Rectangle((int)p1.x,(int)p1.y,10,10);
			neo2=new Rectangle((int)p2.x,(int)p2.y,10,10);
			neo3=new Rectangle((int)p3.x,(int)p3.y,10,10);
			neo4=new Rectangle((int)p4.x,(int)p4.y,10,10);
	}
	public void Tinhtien(Point t,Point r)
	{
		p1.Tinhtien(t,r);
		p2.Tinhtien(t,r);
		p3.Tinhtien(t,r);
		p4.Tinhtien(t,r);
		neo1=new Rectangle((int)p1.x,(int)p1.y,10,10);
		neo2=new Rectangle((int)p2.x,(int)p2.y,10,10);
		neo3=new Rectangle((int)p3.x,(int)p3.y,10,10);
		neo4=new Rectangle((int)p4.x,(int)p4.y,10,10);
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
