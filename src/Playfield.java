public class Playfield extends Fleet {
    final static int MaxX = 9;
    final static int MaxY = 7;
    
    private char[][] playfield = new char[MaxX][MaxY];
    
    public Playfield() {
        for(int x = 0; x < MaxX; x++) {
            for(int y = 0; y < MaxY; y++) {
                playfield[x][y] = '+';
            }
        }
    }
    
    void foundShips() {
        for (int i = 0; i < MAXSHIP; i++) {
            Position pos = getShipPos(i);
            set(pos, SHIP);
        }
    }
    
    public char get(Position pos) {return playfield[pos.getX()][pos.getY()];}
    
    public void set(Position pos, char mark) {playfield[pos.getX()][pos.getY()] = mark;}
    
    public boolean isInPlayfield(Position pos) {
        int x = pos.getX();
        int y = pos.getY();
        return x >= 0 && y >= 0 && x < Playfield.MaxX && y < Playfield.MaxY;
    }
    
}
