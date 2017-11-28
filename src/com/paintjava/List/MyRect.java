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
}
