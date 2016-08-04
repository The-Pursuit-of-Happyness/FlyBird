package com.dialog;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import com.frame.MyJFrame;
import com.image.GameImage;

public class Dialog extends JDialog {
	private JFrame f;
	private int score;
	//定义并初始化按钮
	private JButton b1 = new JButton("退出游戏");
	private JButton b2 = new JButton("重新开始");

	public Dialog(int x,JFrame f) {
		//设置Dialog窗体必须先关闭
		super(f,"疯狂的小鸟",true);
		//设置父窗体
		this.f = f;
		//设置分数
		this.score = x;
		//this.setTitle("疯狂的小鸟");
		Container c = getContentPane();
		c.setLayout(null);
		
		//为两个按钮添加鼠标事件
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//当获取的來源是窗体，并且未发生碰撞
				if (e.getSource() == b1) {
					Dialog.this.f.dispose();//关闭MyFrame窗口
					Dialog.this.dispose();//关闭Dialog窗口
			}
		}
		});
		
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//当获取的來源是窗体，并且未发生碰撞
				if (e.getSource() == b2) {
					Dialog.this.f.dispose();//关闭MyFrame窗口
					Dialog.this.dispose();//关闭Dialog窗口
					new MyJFrame();
			}
		}
		});

		b1.setSize(100,30);
		b2.setSize(100,30);
		b1.setLocation(100, 150);
		b2.setLocation(220, 150);

		c.add(b1);
		c.add(b2);
		setSize(400, 240);
		this.setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	//添加弹窗组件
	 public void paint(Graphics g){
		g.drawImage(GameImage.Dialog_background,0,0,this);
		g.setFont(new java.awt.Font("Dialog",1,45));
		g.setColor(Color.red);
		if(score == 50)
		{
			g.drawString("恭喜你赢了!",80,90);
		}
		else
		{
		g.drawString("游戏结束!",100,90);
		}
		g.setFont(new java.awt.Font("Dialog",1,25));
		g.setColor(Color.blue);
		g.drawString("分数:"+score+" 分", 130, 150);
	}
}
