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
	//���岢��ʼ����ť
	private JButton b1 = new JButton("ȷ��");
	private JButton b2 = new JButton("ȡ��");

	public Exit(JFrame f) {
		//����Dialog��������ȹر�
		super(f,"����С��",true);
		//���ø�����
		this.f = f;
		//���÷���
		//this.setTitle("����С��");
		Container c = getContentPane();
		c.setLayout(null);
		GameImage.initialize();
		//Ϊ������ť�������¼�
		b1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//����ȡ�ā�Դ�Ǵ��壬����δ������ײ
				if (e.getSource() == b1) {
					Exit.this.f.dispose();//�ر�MyFrame����
					Exit.this.dispose();//�ر�Dialog����
			}
		}
		});
		
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//����ȡ�ā�Դ�Ǵ��壬����δ������ײ
				if (e.getSource() == b2) {
					Exit.this.dispose();//�ر�Dialog����
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
	//��ӵ������
	 public void paint(Graphics g){
		g.drawImage(GameImage.exit_background,0,0,this);
		g.setFont(new java.awt.Font("Dialog",1,35));
		g.setColor(Color.red);
		g.drawString("�Ƿ�ȷ���˳���",40,80);
	}
}