package com.wall;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Wall implements Runnable{
	private int length;
	private int width;
	private Point positive;
	private BufferedImage Image_Upon;
	private BufferedImage Image_Below;
	private int speed;	
	private boolean isstop = true;
	
	public Wall(Point p,int length,BufferedImage image_upon,BufferedImage image_below){
		this.width = 80;
		this.positive = p;
		this.length = length;
		this.Image_Upon = image_upon;
		this.Image_Below = image_below;		
		this.speed = 80;
	}
	public void start(){
		Thread t = new Thread(this);
		t.start();
	}
	public void set_isstop(boolean isstop){
		this.isstop = isstop;
	}
	public void run() {
		while(isstop){
		this.positive.x -= 5;	
		if(positive.x<-81){
			isstop = false;
		}
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}	

	public int getLength() {
		return length;
	}
	public Point getPositive() {
		return positive;
	}
	public BufferedImage getImage_Upon() {
		return Image_Upon;
	}
	public BufferedImage getImage_Below() {
		return Image_Below;
	}
}
