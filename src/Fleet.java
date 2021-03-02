import java.util.Random;

class Fleet {
    final static char SHIP = 'X';
    final static int MAXSHIP = 6;

    private Ship ship[] = new Ship[MAXSHIP];

    public Fleet() {
        // prepare ships
        ship = new Ship[MAXSHIP];
        // setup ships
        Random rand = new Random();
        for(int i = 0; i < MAXSHIP; i++) {
            ship[i] = new Ship();
            boolean collide = false;
            do {
                Position pos = new Position(
                        Math.abs(rand.nextInt()) % Playfield.MaxX,
                        Math.abs(rand.nextInt()) % Playfield.MaxY);
                ship[i].setPos(pos);
                collide = false;
                for(int j=0; j < i; j++) {
                    if(ship[j].getPos().equals(pos)) {
                        collide = true;
                    }
                }
            }while(collide);
        }
    }

    public char search(Position searchPos) {
        final int DIRECTIONS = 8;
        int[] direction = new int[DIRECTIONS];
        for(int i=0; i < MAXSHIP; i++) {
            Position pos = ship[i].getPos();
            if(pos.equals(searchPos)) {
                ship[i].setShipFound(true);
                return SHIP;
            } else {
                int dir = searchPos.getDirection(pos);
                if(dir >= 0) {
                    direction[dir] = 1;
                }
            }
        }
        int count = 0;
        for(int i=0; i < DIRECTIONS; i++) {
            count += direction[i];
        }
        char result = (char) ('0' + count);
        return result;
    }

    public boolean allShipsFound() {
        boolean found = true;
        for(int i = 0; i < MAXSHIP; i++) {
            if(!ship[i].isFound()) {
                found = false;
            }
        }
        return found;
    }

    public Position getShipPos(int i) {return ship[i].getPos();}
}
