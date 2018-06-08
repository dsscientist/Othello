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
import java.util.List;

/**
 *
 * @author shirdav18
 */
public class Board extends javax.swing.JPanel {

    private Piece[][] gameBoard;
    public static final int SIDE_LENGTH = 8;
    private int whiteCount;
    private int blackCount;
    private int totalCount;
    private Piece.Color turn = Piece.Color.BLACK;
    private javax.swing.JFrame parent;
    //keep track of whose turn it is?
    
    public Board(javax.swing.JFrame jf) {
        initComponents();
        gameBoard = new Piece[SIDE_LENGTH][SIDE_LENGTH];
        initializeStart();
        parent = jf;
        
    }
    
    public String getTurn() {
        if (turn == Piece.Color.BLACK) {
            return "BLACK";
        } else {
            return "WHITE";
        }
    }
    
    private void initializeStart() {
        addPiece(3, 3, "white");
        addPiece(4, 4, "white");
        addPiece(3, 4, "black");
        addPiece(4, 3, "black");
    }
    
    public void addPiece(int x, int y, String color) {
        gameBoard[x][y] = new Piece(color);
        if (color.equals("black")) {
            blackCount++;
        } else {
            whiteCount++;
        }
        totalCount++;
        repaint();
    }
    
    public void addPiece(int x, int y, Piece.Color c) {
        gameBoard[x][y] = new Piece(c);
        if (c == Piece.Color.BLACK) {
            blackCount++;
        } else {
            whiteCount++;
        }
        totalCount++;
        repaint();
    }
    
    public boolean spaceEmpty(int x, int y) {
        return gameBoard[x][y] == null;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <= Board.SIDE_LENGTH; i++) {
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
    
    public ArrayList<Point> getEndPoints(int x, int y) {
        Piece.Color c = turn;
        if (spaceEmpty(x, y)) {
            ArrayList<Point> arr = new ArrayList<>();
            boolean isOpposite = false;
            left:
            for (int i = x - 1; i >= 0; i--) { //left
                if (spaceEmpty(i, y)) {
                    break left;
                } else {
                    if (gameBoard[i][y].getColor()!=c) {
                        isOpposite = true;
                    } else { //same found
                        if (isOpposite) {
                            arr.add(new Point(i, y));
                            break left;
                        } else { //no opposite pieces between
                            break left;
                        }
                    }
                }
            }
            isOpposite = false;
            right:
            for (int i = x + 1; i < SIDE_LENGTH; i++) { //right
                if (spaceEmpty(i, y)) {
                    break right;
                } else {
                    if (gameBoard[i][y].getColor()!=c) {
                        isOpposite = true;
                    } else { //same found
                        if (isOpposite) {
                            arr.add(new Point(i, y));
                            break right;
                        } else { //no opposite pieces between
                            break right;
                        }
                    }
                }
            }
            isOpposite = false;
            up:
            for (int j = y - 1; j >= 0; j--) { //up
                if (spaceEmpty(x, j)) {
                    break up;
                } else {
                    if (gameBoard[x][j].getColor()!=c) {
                        isOpposite = true;
                    } else { //same found
                        if (isOpposite) {
                            arr.add(new Point(x, j));
                            break up;
                        } else { //no opposite pieces between
                            break up;
                        }
                    }
                }
            }
            isOpposite = false;
            down:
            for (int j = y + 1; j < SIDE_LENGTH; j++) { //down
                if (spaceEmpty(x, j)) {
                    break down;
                } else {
                    if (gameBoard[x][j].getColor()!=c) {
                        isOpposite = true;
                    } else { //same found
                        if (isOpposite) {
                            arr.add(new Point(x, j));
                            break down;
                        } else { //no opposite pieces between
                            break down;
                        }
                    }
                }
            }
            isOpposite = false;
            upLeft:
            for (int i = 1; x - i >= 0 && y - i >= 0; i++) { //up left
                if (spaceEmpty(x-i, y-i)) {
                    break upLeft;
                } else {
                    if (gameBoard[x-i][y-i].getColor()!=c) {
                        isOpposite = true;
                    } else { //same found
                        if (isOpposite) {
                            arr.add(new Point(x-i, y-i));
                            break upLeft;
                        } else { //no opposite pieces between
                            break upLeft;
                        }
                    }
                }
            }
            isOpposite = false;
            downRight:
            for (int i = 1; i < SIDE_LENGTH - Math.max(x, y); i++) { //down right
                if (spaceEmpty(x+i, y+i)) {
                    break downRight;
                } else {
                    if (gameBoard[x+i][y+i].getColor()!=c) {
                        isOpposite = true;
                    } else { //same found
                        if (isOpposite) {
                            arr.add(new Point(x+i, y+i));
                            break downRight;
                        } else { //no opposite pieces between
                            break downRight;
                        }
                    }
                }
            }
            isOpposite = false;
            upRight:
            for (int i = 1; x + i < SIDE_LENGTH && y - i >= 0; i++) { //up right
                if (spaceEmpty(x+i, y-i)) {
                    break upRight;
                } else {
                    if (gameBoard[x+i][y-i].getColor()!=c) {
                        isOpposite = true;
                    } else { //same found
                        if (isOpposite) {
                            arr.add(new Point(x+i, y-i));
                            break upRight;
                        } else { //no opposite pieces between
                            break upRight;
                        }
                    }
                }
            }
            isOpposite = false;
            downLeft:
            for (int i = 1; x - i >= 0 && y + i < SIDE_LENGTH; i++) { //down left
                if (spaceEmpty(x-i, y+i)) {
                    break downLeft;
                } else {
                    if (gameBoard[x-i][y+i].getColor()!=c) {
                        isOpposite = true;
                    } else { //same found
                        if (isOpposite) {
                            arr.add(new Point(x-i, y+i));
                            break downLeft;
                        } else { //no opposite pieces between
                            break downLeft;
                        }
                    }
                }
            }
            return arr;
        } else {
            //return empty and maybe have popup
            return new ArrayList<>();
        }
    }
    
    private void flipPieces(List<Point> l, Point clicked) {
        for (Point p : l) {
            int xDif = Math.abs(p.x - clicked.x);
            int yDif = Math.abs(p.y - clicked.y);
            if (xDif > yDif) {
                int minX = Math.min(p.x, clicked.x);
                int minY = Math.min(p.y, clicked.y);
                //horizontal row
                for (int i = minX + 1; i < Math.max(p.x, clicked.x); i++) {
                    gameBoard[i][clicked.y].flip();
                }
            } else {
                int minX = Math.min(p.x, clicked.x);
                int minY = Math.min(p.y, clicked.y);
                if (xDif == 0) { //vertical column               
                    for (int j = minY + 1; j < Math.max(p.y, clicked.y); j++) {
                        gameBoard[clicked.x][j].flip();
                    }
                } else { //diagonal
                    boolean downLeft = clicked.x - p.x < 0 && clicked.y - p.y > 0;
                    boolean upRight = clicked.x - p.x > 0 && clicked.y - p.y < 0;
                    if (downLeft || upRight) {
                        int maxY = Math.max(p.y, clicked.y);
                        for (int j = 1; j < yDif; j++) {
                            gameBoard[minX + j][maxY - j].flip();
                        }
                    } else {
                        for (int j = 1; j < yDif; j++) {
                            gameBoard[minX + j][minY + j].flip();
                        }
                    }
                }
            }
        }
        repaint();
    }
    
    private void updateCount() {
        whiteCount = 0;
        blackCount = 0;
        for (int i = 0; i < SIDE_LENGTH; i++) {
            for (int j = 0; j < SIDE_LENGTH; j++) {
                if (gameBoard[i][j] != null) {
                    if (gameBoard[i][j].getColor() == Piece.Color.BLACK) {
                        blackCount++;
                    } else {
                        whiteCount++;
                    }
                }
            }
        }
        if (totalCount == Math.pow(SIDE_LENGTH, 2)) {
            //end game
        }
        System.out.printf("white: %d\nblack: %d\n", whiteCount, blackCount);
    }
    
    private void changeTurns() {
        if (turn == Piece.Color.BLACK) {
            turn = Piece.Color.WHITE;
        } else {
            turn = Piece.Color.BLACK;
        }
        ((MainFrame)parent).updateTurn(getTurn());
    }
    
    public boolean checkBoard(){
        ArrayList<Point> points = new ArrayList<Point>();
        for(int i=0; i<gameBoard.length; i++){
            for(int j=0; j<gameBoard[i].length; j++){
                if(gameBoard[i][j]==null && getEndPoints(i,j).size()!=0){
                    points.add(new Point(i,j));
                }
            }
        }
        return points.isEmpty();
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
        System.out.printf("clicked: %d %d\n", x, y);
        if (spaceEmpty(x, y)) { // && valid spot to put piece
            List<Point> endPoints = getEndPoints(x, y);
            if (endPoints.size() == 0) {
                //popup or message saying invalid location
                System.out.println("invalid");
            } else {
                for (Point p : endPoints) {
                    System.out.println("end: " + p);
                }
                addPiece(x, y, turn);
                flipPieces(endPoints, new Point(x, y));
                updateCount();
                changeTurns();
                if(totalCount >= 55 && totalCount < 64){
                    if(checkBoard()==true){
                      PopUp InvalidPlay = new PopUp("Invalid Play", false, (MainFrame) parent);
                      InvalidPlay.setVisible(true);
                        System.out.println("no possible moves, change turns");
                      changeTurns();
                    }
                }
                else if(totalCount==64){
                    PopUp endGame = new PopUp(turn.toString(),true,(MainFrame) parent);
                }
            }
        } //otherwise, do nothing
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
