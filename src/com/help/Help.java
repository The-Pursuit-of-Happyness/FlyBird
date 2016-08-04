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
		super(owner,"����",true);
		Container c = getContentPane();
		c.setLayout(null);

		GameImage.initialize();
		exit_button = new JButton("�˳�����");
		//Ϊ��ť�������¼�
		exit_button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//����ȡ�ā�Դ�Ǵ��壬����δ������ײ
				if (e.getSource() == exit_button) {
					Help.this.dispose();//�ر�Dialog����
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
		g.drawString("��Ϸ����", 120,100);
		g.setFont(new java.awt.Font("Dialog",1,25));
		g.setColor(Color.red);
		g.drawString("����������", 60,150);
		g.drawString("�汾��Ϣ��", 60,360);
		g.setFont(new java.awt.Font("Dialog",1,15));
		g.setColor(Color.black);
		g.drawString("1.���������,�������,С�������", 80,180);
		g.drawString("  �˶�,����С�������˶�.",80,200);
		g.drawString("2.С�������˶�,�ܿ��ϰ���,���ϰ���", 80,220);
		g.drawString("  �Ŀ�֮��ͨ��.", 80, 240);
		g.drawString("3.��С�������������С��ɳ��߽�,", 80,260);
		g.drawString("  ��Ϸ����.",80,280);
		g.drawString("4.С�������˶�,˳���ܿ������ϰ���,", 80,300);
		g.drawString("  ��Ϸʤ��.", 80, 320);
		g.drawString("�����Ŷӣ�������   Ƚ����  ������.", 80, 400);
	}
}
