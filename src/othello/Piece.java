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
    
    public Color getColor() {
        return color;
    }
}
