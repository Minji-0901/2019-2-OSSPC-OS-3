package com.ok.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

import com.ok.window.TetrisBoard;

public class Block implements Serializable{
	private int size = TetrisBoard.BLOCK_SIZE;
	private int width = size, height = size;
	private int gap = 3;
	private int fixGridX, fixGridY;
	private int posGridX, posGridY;
	private Color color;
	private Color ghostColor;	
	private boolean ghost;
	
	
	/**
	 * 
	 * @param fixGridX : �簢�� ���� X �׸�����ǥ
	 * @param fixGridY : �簢�� ���� Y �׸�����ǥ
	 * @param color : �簢�� ����
	 */
	public Block(int fixGridX, int fixGridY, Color color, Color ghostColor) {
		this.fixGridX = fixGridX;
		this.fixGridY = fixGridY;
		this.color=color;
		this.ghostColor = ghostColor;
	}
	

	/**
	 * �簢���� �׷��ش�.
	 * @param g
	 */
	public void drawColorBlock(Graphics g){
		if(ghost)g.setColor(ghostColor);
		else g.setColor(color);
		g.fillRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y, width, height);
		g.setColor(Color.WHITE);
		g.drawRect((fixGridX+posGridX)*size + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y, width, height);
		g.drawLine((fixGridX+posGridX)*size + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y, (fixGridX+posGridX)*size+width + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size+height + TetrisBoard.BOARD_Y);
		g.drawLine((fixGridX+posGridX)*size + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size+height + TetrisBoard.BOARD_Y, (fixGridX+posGridX)*size+width + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size + TetrisBoard.BOARD_Y);
		if(ghost)g.setColor(ghostColor);
		else g.setColor(color);
		g.fillRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y, width-gap*2, height-gap*2);
		g.setColor(Color.WHITE);
		g.drawRect((fixGridX+posGridX)*size+gap + TetrisBoard.BOARD_X, (fixGridY+posGridY)*size+gap + TetrisBoard.BOARD_Y, width-gap*2, height-gap*2);
	}
	
	public void drawEnemyBlock(Graphics g, int x, int y){
		g.setColor(color);
		g.fillRect(x*size, y*size, width, height);
		g.setColor(Color.WHITE);
		g.drawRect(x*size, y*size, width, height);
		g.drawLine(x*size, y*size, x*size+width, y*size+height);
		g.drawLine(x*size, y*size+height, x*size+width, y*size);
		g.setColor(color);
		g.fillRect(x*size+gap, y*size+gap, width-gap*2, height-gap*2);
		g.setColor(Color.WHITE);
		g.drawRect(x*size+gap, y*size+gap, width-gap*2, height-gap*2);
	}
	
	/**
	 * ���� ������ ������ǥ�� �����ش�.
	 * @return ��������� X������ǥ
	 */
	public int getX(){return posGridX + fixGridX;}	
	
	
	/**
	 * ���� ������ ������ǥ�� �����ش�.
	 * @return ��������� Y������ǥ
	 */
	public int getY(){return posGridY + fixGridY;}

	public Color getC() {return color;}
	/**
	 * Getter Setter
	 */
	public int getPosGridX(){return this.posGridX;}
	public int getPosGridY(){return this.posGridY;}
	public void setPosGridX(int posGridX) {this.posGridX = posGridX;}
	public void setPosGridY(int posGridY) {this.posGridY = posGridY;}
	public void setPosGridXY(int posGridX, int posGridY){this.posGridX = posGridX;this.posGridY = posGridY;}
	public void setFixGridX(int fixGridX) {this.fixGridX = fixGridX;}
	public void setFixGridY(int fixGridY) {this.fixGridY = fixGridY;}
	public void setFixGridXY(int fixGridX, int fixGridY){this.fixGridX = fixGridX;this.fixGridY = fixGridY;}
	public void setGhostView(boolean b){this.ghost = b;}
}