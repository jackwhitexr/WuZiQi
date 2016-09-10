package com.server.ui;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.server.tools.MessageTool;
import com.client.tools.ListTool;
import com.server.net.ServerThread;

/*
 * ��������
 * �������PlayerList����MessagePanel
 * 
 */
public class ServerFrame extends JFrame {
	private static ServerFrame server = null;
	private boolean isConnected = false;
	private MessagePanel messagePanel = MessagePanel.getInstance();
	private PlayerPanel playerPanel = PlayerPanel.getInstance();

	public static ServerFrame getInstance() {
		if (server == null) {
			server = new ServerFrame();
		}
		return server;
	}

	private ServerFrame() {
		setTitle("����������������");
		setSize(600, 700);
		setLocation(100, 200);
		setLayout(new GridLayout());
		add(messagePanel);
		add(playerPanel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		startServer();
	}

	// �������������󶨶˿ڿ�ʼ����
	private void startServer(){
		ServerSocket ss=null;
		try{
			isConnected=true;	//��������������
			ss=new ServerSocket(6666);
			MessageTool.getInstance().addMessage("������������");
			ListTool.getInstance().addPlayer("�ȴ����......");
			//ListTool.getInstance().addPlayer("�ȴ����......");
			while(isConnected){
				Socket socket=ss.accept();
				//System.out.println("�ͻ������ӳɹ�");
				Thread serverThread=new Thread(new ServerThread(socket));
				serverThread.start();
			}
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null,"�˿��Ѿ��󶨣��벻Ҫ����������������",
				     "�˿�ռ�þ���",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
			dispose();
		}
	}
}
