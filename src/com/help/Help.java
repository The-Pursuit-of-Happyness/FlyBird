package com.help;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import com.image.GameImage;

public class Help extends JDialog{
	private JButton exit_button;
	public JFrame owner;
	public Help(JFrame owner){
		super(owner,"帮助",true);
		Container c = getContentPane();
		c.setLayout(null);

		GameImage.initialize();
		exit_button = new JButton("退出帮助");
		//为按钮添加鼠标事件
		exit_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//当获取的來源是窗体，并且未发生碰撞
				if (e.getSource() == exit_button) {
					Help.this.dispose();//关闭Dialog窗口
				}
			}
		});
		exit_button.setSize(100,30);
		exit_button.setLocation(250, 405);
		c.add(exit_button);
		this.setSize(400, 490);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);				
	}
	public void paint(Graphics g){
		g.drawImage(GameImage.help_background,0,30,this);
		g.setFont(new java.awt.Font("Dialog",1,35));
		g.setColor(Color.blue);
		g.drawString("游戏帮助", 120,100);
		g.setFont(new java.awt.Font("Dialog",1,25));
		g.setColor(Color.red);
		g.drawString("基本操作：", 60,150);
		g.drawString("版本信息：", 60,360);
		g.setFont(new java.awt.Font("Dialog",1,15));
		g.setColor(Color.black);
		g.drawString("1.鼠标点击操作,鼠标点击后,小鸟会向上", 80,180);
		g.drawString("  运动,否则小鸟向下运动.",80,200);
		g.drawString("2.小鸟上下运动,避开障碍物,从障碍物", 80,220);
		g.drawString("  的孔之间通过.", 80, 240);
		g.drawString("3.当小鸟碰到碍物或者小鸟飞出边界,", 80,260);
		g.drawString("  游戏结束.",80,280);
		g.drawString("4.小鸟上下运动,顺利避开所有障碍物,", 80,300);
		g.drawString("  游戏胜利.", 80, 320);
		g.drawString("开发团队：夏文齐   冉瑞龙  徐文丽.", 80, 400);
	}
}
