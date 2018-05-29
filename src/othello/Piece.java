package othello;

/**
 *
 * @author shirdav18
 */
public class Piece {
    
    public enum Color {WHITE, BLACK}
    private Color color;
    
    public Piece(String s) {
        color = Color.valueOf(s.toUpperCase());
    }
    
    public Piece(Color c) {
        color = c;
    }
    
    public Color getColor() {
        return color;
    }
    
    public void flip() {
        if (color==Color.BLACK) {
            color = Color.WHITE;
        } else {
            color = Color.BLACK;
        }
    }
}
