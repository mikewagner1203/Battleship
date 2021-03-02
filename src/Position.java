public class Position {
    final int NORTH = 0;
    final int SOUTH = 1;
    final int EAST = 2;
    final int WEST = 3;
    final int NORTHEAST = 4;
    final int NORTHWEST = 5;
    final int SOUTHEAST = 6;
    final int SOUTHWEST = 7;

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection(Position chk) {
        int direction = -1;
        if (x == chk.x && y < chk.y) {
            direction = NORTH;
        } else if (x == chk.x && y > chk.y) {
            direction = SOUTH;
        } else if (x < chk.x && y == chk.y) {
            direction = EAST;
        } else if (x > chk.x && y == chk.y) {
            direction = WEST;
        }

        //Diagonal calculation
        int diffx = x - chk.x;
        int diffy = y - chk.y;
        if (diffx == diffy && x < chk.x) {
            direction = NORTHEAST;
        } else if (diffx == diffy && x > chk.x) {
            direction = SOUTHWEST;
        } else if (diffx == -diffy && x < chk.x) {
            direction = SOUTHEAST;
        } else if (diffx == -diffy && x > chk.x) {
            direction = NORTHWEST;
        }
        return direction;
    }
    
    @Override
    public boolean equals(Object obj) {
        Position pos = (Position) obj;
        return this.x == pos.x && this.y == pos.y;
    }
}
