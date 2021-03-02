public class Ship {
    private Position pos;
    private boolean shipFound = false;
    
    public void setPos(Position pos) {this.pos = pos;}
    
    public Position getPos(){return pos;}

    public boolean isFound() {return shipFound;}

    public void setShipFound(boolean shipFound) {this.shipFound = shipFound;}
}
