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

public class Exit extends JDialog {
	private JFrame f;
	//定义并初始化按钮
	private JButton b1 = new JButton("确定");
	private JButton b2 = new JButton("取消");

	public Exit(JFrame f) {
		//设置Dialog窗体必须先关闭
		super(f,"疯狂的小鸟",true);
		//设置父窗体
		this.f = f;
		//设置分数
		//this.setTitle("疯狂的小鸟");
		Container c = getContentPane();
		c.setLayout(null);
		GameImage.initialize();
		//为两个按钮添加鼠标事件
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//当获取的來源是窗体，并且未发生碰撞
				if (e.getSource() == b1) {
					Exit.this.f.dispose();//关闭MyFrame窗口
					Exit.this.dispose();//关闭Dialog窗口
			}
		}
		});
		
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//当获取的來源是窗体，并且未发生碰撞
				if (e.getSource() == b2) {
					Exit.this.dispose();//关闭Dialog窗口
					new MyJFrame();
			}
		}
		});
		
		b1.setSize(80,30);
		b2.setSize(80,30);
		b1.setLocation(50, 120);
		b2.setLocation(150, 120);

		c.add(b1);
		c.add(b2);
		setSize(300, 200);
		this.setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	//添加弹窗组件
	 public void paint(Graphics g){
		g.drawImage(GameImage.exit_background,0,0,this);
		g.setFont(new java.awt.Font("Dialog",1,35));
		g.setColor(Color.red);
		g.drawString("是否确定退出？",40,80);
	}
}