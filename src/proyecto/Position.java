package proyecto;

class Position {
    public int x;
    public int y;
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Position(Position pos){
        pos.x = x;
        pos.y = y;
    }
}
