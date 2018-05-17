package othello;

/**
 *
 * @author shirdav18
 */
public class Piece {
    
    private enum Color {WHITE, BLACK}
    
    public Piece(String s) {
        Color c = Color.valueOf(s);
    }
}
