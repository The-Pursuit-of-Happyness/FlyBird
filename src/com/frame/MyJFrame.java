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
	BufferedImage background;  //����ͼƬ����
	BufferedImage StartButtonImage;
	BufferedImage helpButtonImage;
	BufferedImage exitButtonImage;
	private boolean isStart = true;
	public MyJFrame(){
		super("����С��");
		//���뱳��
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
		//Ϊ�������������¼�
		this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if((e.getX() > 340 && e.getX() < 460)&&(e.getY() > 180 && e.getY() < 260)){
						MyJFrame.this.dispose();//�ر�ԭ���Ĵ���
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
		//Ϊ���������������¼�
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
		//���ô���
		this.setSize(800,500);	
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	//���Ʊ���ͼƬ
	public void paint(Graphics g){
		//˫���弼������ͼƬ
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
