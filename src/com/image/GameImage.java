package com.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class GameImage {
	public static BufferedImage up_Image;
	public static BufferedImage down_Image;
	public static BufferedImage background_Image;
	public static BufferedImage Dialog_background;
	public static BufferedImage help1;
	public static BufferedImage help2;
	public static ImageIcon icon;
	public static BufferedImage help_background;
	public static BufferedImage exit_background;
	
	public static void initialize(){
		try {
			up_Image = ImageIO.read(new File("src\\com\\image\\upon.png"));   //上面的墙体
			down_Image = ImageIO.read(new File("src\\com\\image\\below.png"));   //底部的墙体
			background_Image = ImageIO.read(new File("src\\com\\image\\background2.jpg"));  //背景
			icon = new ImageIcon("src\\com\\image\\bird.gif");
			Dialog_background = ImageIO.read(new File("src\\com\\image\\Dialog_background.png"));
			help1 =ImageIO.read(new File("src\\com\\image\\help1.png"));
			help2 = ImageIO.read(new File("src\\com\\image\\help2.png"));
			help_background = ImageIO.read(new File("src\\com\\image\\help_background.png"));
			exit_background = ImageIO.read(new File("src\\com\\image\\exit_background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

