package othello;


public class Board {
    
    private Piece[][] gameBoard;
    private static final int SIDE_LENGTH = 8;
    private static int whiteCount;
    private static int blackCount;

    public Board() {
        gameBoard = new Piece[SIDE_LENGTH][SIDE_LENGTH];
    }
}
