package com.client.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.client.gamedata.GameData;

/**
 * ��������Ϸ�ͻ���
 * 
 * @author Mr.Bubbles
 *
 */
public class ClientFrame extends JFrame {

	private static ClientFrame client = null;
	private GamePanel gamePanel = GamePanel.getInstance();
	private FunctionPanel functionPanel = FunctionPanel.getInstance();

	public static ClientFrame getInstance() {
		if (client == null)
			client = new ClientFrame();
		return client;
	}

	// ���캯�����������
	public ClientFrame() {
		this.setTitle("�������ս�ͻ���");
		this.setSize(GameData.FrameWidth, GameData.FrameHeight);
		this.setLocation(100, 100);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ���������
		this.setLayout(new BorderLayout());

		this.add(gamePanel, BorderLayout.CENTER);
		this.add(PlayerPanel.getInstance(), BorderLayout.WEST);
		this.add(MessagePanel.getInstance(), BorderLayout.EAST);
		this.setVisible(true);

	}
}
