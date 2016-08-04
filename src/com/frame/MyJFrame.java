package com.frame;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.dialog.Exit;
import com.help.Help;

public class MyJFrame extends JFrame implements Runnable{
	BufferedImage background;  //背景图片对象
	BufferedImage StartButtonImage;
	BufferedImage helpButtonImage;
	BufferedImage exitButtonImage;
	private boolean isStart = true;
	public MyJFrame(){
		super("疯狂的小鸟");
		//导入背景
		try {
			background = ImageIO.read(new File("src\\com\\image\\background0.jpg"));
			StartButtonImage = ImageIO.read(new File("src\\com\\image\\start1.png"));
			helpButtonImage = ImageIO.read(new File("src\\com\\image\\help1.png"));
			exitButtonImage = ImageIO.read(new File("src\\com\\image\\help1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		new Thread(this).start();
		setLayout(null);
		//为窗体添加鼠标点击事件
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if((e.getX() > 340 && e.getX() < 460)&&(e.getY() > 180 && e.getY() < 260)){
						MyJFrame.this.dispose();//关闭原来的窗口
					isStart = false;
					Game g =new Game();
				}
				else if((e.getX() > 340 && e.getX() < 460)&&(e.getY() > 280 && e.getY() < 360)){
					Help help =new Help(MyJFrame.this);
				}
				else if((e.getX() > 340 && e.getX() < 460)&&(e.getY() > 380 && e.getY() < 460)){
					Exit exit =new Exit(MyJFrame.this);
				}
			}
		});
		//为窗体添加鼠标移入事件
		this.addMouseMotionListener(new MouseMotionListener(){
				public void mouseDragged(MouseEvent arg0) {
				}
				public void mouseMoved(MouseEvent e) {					 
					if((e.getX() > 340 && e.getX() < 460)&&(e.getY() > 180 && e.getY() < 260)){
						 try {
							 StartButtonImage = ImageIO.read(new File("src\\com\\image\\start1.png"));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					else if((e.getX() > 340 && e.getX() < 460)&&(e.getY() > 280 && e.getY() < 360)){
						 try {
							 helpButtonImage = ImageIO.read(new File("src\\com\\image\\help1.png"));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					else if((e.getX() > 340 && e.getX() < 460)&&(e.getY() > 380 && e.getY() < 460)){
						 try {
							 exitButtonImage = ImageIO.read(new File("src\\com\\image\\exit1.png"));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					else{
						 try {
							 StartButtonImage = ImageIO.read(new File("src\\com\\image\\start2.png"));
							 helpButtonImage = ImageIO.read(new File("src\\com\\image\\help2.png"));
							 exitButtonImage = ImageIO.read(new File("src\\com\\image\\exit2.png"));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}					
				}
				});
		//设置窗体
		this.setSize(800,500);	
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	//绘制背景图片
	public void paint(Graphics g){
		//双缓冲技术绘制图片
		BufferedImage image = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
		Graphics g2 = image.getGraphics();
		g2.drawImage(background,0,25,800,500,this);
		g2.drawImage(StartButtonImage,340,180,120,80,this);
		g2.drawImage(helpButtonImage,340,280,120,80,this);
		g2.drawImage(exitButtonImage,340,380,120,80,this);
		g.drawImage(image, 0, 0, this);
	}
	@Override
	public void run() {
		while(isStart){
			this.repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
