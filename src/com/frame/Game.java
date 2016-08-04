package com.frame;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import com.dialog.Dialog;
import com.image.GameImage;
import com.wall.Wall;

public class Game extends JFrame implements Runnable {
	private int speed;
	private int px;
	private int py;
	private boolean IsNotCollide = true;
	private int index = 0;
	private int count = 0;

	private List<Wall> wall = new ArrayList<Wall>();

	public Game() {
		super("����С��");
		py = (int) this.getSize().getHeight() / 2;
		px = 290;
		speed = 80;
		
		final Container c = getContentPane();
		c.setLayout(null);
		setResizable(false);
		getContentPane().setLayout(null);
		//Ϊ�����������¼�����������ƶ�
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//����ȡ�ā�Դ�Ǵ��壬����δ������ײ
				if (e.getSource() == c && IsNotCollide == true) {
					py -= 40;
			}
		}
		});
		//��ʼ��ͼƬ
		GameImage.initialize();
		//��ʼ�����µ�ǽ��
		this.initaialize();
		new Thread(this).start();		
		this.setSize(800, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	//��ײ��⺯��
	public void collide(Wall obj) {
		if (((obj.getLength()-10 > py) || (obj.getLength() + 65 < py))
				&& (obj.getPositive().x <= px + 55 && obj.getPositive().x + 60 >= px + 55)) {
			IsNotCollide = false;
			// ֹͣ������߳�
			Iterator iter = wall.iterator();
			while (iter.hasNext()) {
				Wall stop = (Wall) iter.next();
				stop.set_isstop(false);
			}
			 if(index<3)index =3;
			Dialog d =new Dialog(index - 3,this);
		}
	}
	public void paint(Graphics g) {
		//˫���弼��
		BufferedImage image = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
		Graphics g2 = image.getGraphics();
		g2.drawImage(GameImage.background_Image, 0, 0,800,500, this);		//��ӱ���
		g2.drawImage(GameImage.icon.getImage(), px, py, 80, 60, this);//�����
		//���ǽ��
		Iterator iter = wall.iterator();
		while (iter.hasNext()) {
			Wall obj = (Wall) iter.next();
			g2.drawImage(obj.getImage_Upon(), obj.getPositive().x,//�����Ϸ���ǽ��
					obj.getPositive().y,60,obj.getLength(), this);
			g2.drawImage(obj.getImage_Below(), obj.getPositive().x,//�����·���ǽ��
					obj.getPositive().y+obj.getLength()+120,60,500-obj.getLength(), this);
		}
		g.drawImage(image, 0, 0, this);
	}
	//����ǽ���ʼ��
	public void initaialize() {
		for (int i = 0; i < 50; i++) {		
			Wall obj = null;
				obj = new Wall(new Point(850, 0),
						new Random().nextInt(250) + 50, GameImage.up_Image,GameImage.down_Image);
			wall.add(obj);
		}
	}

	public void start() {
		Thread t = new Thread(this);
		t.start();
	}

	//��дrun()����
	public void run() {
		while (IsNotCollide) {			
			if (count % 50 == 0) {
				Wall obj = wall.get(index);
				obj.start();
				index++;
				if (index >= 50) {
					Iterator iter = wall.iterator();
					while (iter.hasNext()) {
						Wall stop = (Wall) iter.next();
					stop.set_isstop(false);
					}
				IsNotCollide = false;
				if(index<3)index =3;
				 Dialog d = new Dialog(index -3,this);
					//index = 0;
				}
				count =0;
				}
			//��ײ���
			if(index>=3){
				collide(wall.get(index-3));
			}
			count++;
			try {
				Thread.sleep(speed);
			} catch (Exception e) {
			}
			py += 10;
			this.repaint();
			 if(py >= 500 || py <= 0){
				 //ֹͣǽ����߳�
				 Iterator iter = wall.iterator();
					while (iter.hasNext()) {
						Wall stop = (Wall) iter.next();
					stop.set_isstop(false);
					}
				IsNotCollide = false;
				if(index<3)index =3;
				 Dialog d = new Dialog(index -3,this);
			 }
		}
	}
}
