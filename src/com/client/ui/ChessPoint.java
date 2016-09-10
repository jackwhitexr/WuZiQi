package com.client.ui;

import java.awt.Color;

public class ChessPoint {
	/**
	 * ������ 
	 * һ�����ӵ����԰���X���꣬Y�������ɫ
	 */
	public static final int HAS_POINT = 1;
	public static final int NO_POINT = 0;
	private int x;
	private int y;
	private int hasPoint = NO_POINT;
	private Color color;

	public ChessPoint(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public int getCPX() {
		return x;
	}

	public int getCPY() {
		return y;
	}

	public int hasPoint() {
		return hasPoint;
	}

	public Color getCPColor() {
		return color;
	}
}