/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author shirdav18
 */
public class Board extends javax.swing.JPanel {

    private Piece[][] gameBoard;
    public static final int SIDE_LENGTH = 8;
    private static int whiteCount;
    private static int blackCount;
    private Piece.Color turn = Piece.Color.BLACK;
    //keep track of whose turn it is?
    
    public Board() {
        initComponents();
        gameBoard = new Piece[SIDE_LENGTH][SIDE_LENGTH];
        initializeStart();
    }
    
    private void initializeStart() {
        gameBoard[3][3] = new Piece("white");
        gameBoard[4][4] = new Piece("white");
        gameBoard[3][4] = new Piece("black");
        gameBoard[4][3] = new Piece("black");
        whiteCount += 2;
        blackCount += 2;
    }
    
    public void addPiece(int x, int y, String color) {
        gameBoard[x][y] = new Piece(color);
        
    }
    
    public boolean spaceEmpty(int x, int y) {
        return gameBoard[x][y] == null;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < Board.SIDE_LENGTH; i++) {
            g.drawLine(125 * i, 0, 125 * i, MainFrame.SIDE_LENGTH);
            g.drawLine(0, 125 * i, MainFrame.SIDE_LENGTH, 125 * i);
        }
        drawPieces(g);
    }
    
    public void drawPieces(Graphics g) {
        for (int i=0; i<gameBoard.length; i++){
            for(int j=0; j<gameBoard[i].length;j++){
                Piece temp = gameBoard[i][j];
                if(temp!=null){
                    if(temp.getColor()==Piece.Color.BLACK){
                        g.setColor(Color.black);
                    }
                    else{
                        g.setColor(Color.white);
                    }
                    g.fillOval(125*i + 2, 125*j + 2, 120, 120);
                }
               
            }
        }
    }
    
    public Point[] getEndPoints(int x, int y) {
        Piece.Color c = turn;
        if (spaceEmpty(x, y)) {
            ArrayList<Point> arr = new ArrayList<>();
            boolean isOpposite = false;
            for (int i = x - 1; i >= 0; i--) { //left
                if (gameBoard[i][y].getColor()==c) {
                    isOpposite = true;
                } else if (gameBoard[i][y].getColor()==c){ //same found
                    if (isOpposite) {
                        arr.add(new Point(i, y));
                    } else { //no opposite pieces between
                        break;
                    }
                } else {
                    break;
                }
            }
            for (int i = x + 1; i < SIDE_LENGTH; i++) { //right
                //put if for if null
                if (gameBoard[i][y].getColor()==c) {
                    isOpposite = true;
                } else { //same found
                    if (isOpposite) {
                        arr.add(new Point(i, y));
                    } else { //no opposite pieces between
                        break;
                    }
                }
            }
            for (int j = y - 1; j >= 0; j--) { //up
                if (gameBoard[x][j].getColor()==c) {
                    isOpposite = true;
                } else if (gameBoard[x][j].getColor()==c){ //same found
                    if (isOpposite) {
                        arr.add(new Point(x, j));
                    } else { //no opposite pieces between
                        break;
                    }
                } else {
                    break;
                }
            }
            for (int j = y + 1; j < SIDE_LENGTH; j++) { //down
                if (gameBoard[x][j].getColor()==c) {
                    isOpposite = true;
                } else if (gameBoard[x][j].getColor()==c){ //same found
                    if (isOpposite) {
                        arr.add(new Point(x, j));
                    } else { //no opposite pieces between
                        break;
                    }
                } else {
                    break;
                }
            }
            for (int i = 1; i <= Math.min(x, y); i++) { //up left
                if (gameBoard[x-i][y-i].getColor()==c) {
                    isOpposite = true;
                } else if (gameBoard[x-i][y-i].getColor()==c){ //same found
                    if (isOpposite) {
                        arr.add(new Point(x-i, y-i));
                    } else { //no opposite pieces between
                        break;
                    }
                } else {
                    break;
                }
            }
            for (int i = 1; i < SIDE_LENGTH - Math.min(x, y); i++) { //down right
                if (gameBoard[x+i][y+i].getColor()==c) {
                    isOpposite = true;
                } else if (gameBoard[x+i][y+i].getColor()==c){ //same found
                    if (isOpposite) {
                        arr.add(new Point(x+i, y+i));
                    } else { //no opposite pieces between
                        break;
                    }
                } else {
                    break;
                }
            }
            for (int i = 1; i <= Math.min(x, y); i++) { //up right
                if (gameBoard[x+i][y-i].getColor()==c) {
                    isOpposite = true;
                } else if (gameBoard[x+i][y-i].getColor()==c){ //same found
                    if (isOpposite) {
                        arr.add(new Point(x+i, y-i));
                    } else { //no opposite pieces between
                        break;
                    }
                } else {
                    break;
                }
            }
            for (int i = 1; i < SIDE_LENGTH - Math.min(x, y); i++) { //down left
                if (gameBoard[x-i][y+i].getColor()==c) {
                    isOpposite = true;
                } else if (gameBoard[x-i][y+i].getColor()==c){ //same found
                    if (isOpposite) {
                        arr.add(new Point(x-i, y+i));
                    } else { //no opposite pieces between
                        break;
                    }
                } else {
                    break;
                }
            }
            return ((Point[])arr.toArray());
        } else {
            //return empty and maybe have popup
            return new Point[0];
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(0, 153, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        int x = evt.getX() / 125;
        int y = evt.getY() / 125;
        System.out.printf("%d %d", x, y);
        if (spaceEmpty(x, y)) { // && valid spot to put piece
            Point[] endPoints = getEndPoints(x, y);
            if (endPoints.length == 0) {
                //popup or message saying invalid location
            } else {
                
            }
        }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
