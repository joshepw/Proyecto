package proyecto;

public abstract class Pieza {
    protected int LP;
    protected Position posPieza;
    protected String Player;
    protected piezaTipo tipo;
    protected String Color; 
    
    public Pieza(int points,int pos_x,int pos_y,String player,String color){
        LP = points;
        posPieza = new Position(pos_x,pos_y);
        Player = player;
        Color = color;
    }
    
    public boolean setLP(int i){
        if(LP > 0){
            LP += i;
            return true;
        }
        return false;
    }
    
    public int getLP(){
        return LP;
    }
    
    public Position getPosition(){
        return posPieza;
    }
    
    public void setPostion(Position pos){
        posPieza = pos;
    }
    
    public String getPlayer(){
        return Player;
    }
    
    public String getColor(){
        return Color;
    }
    
    public abstract int attackZombie();
    public abstract int attackWolf();
    public abstract int attackVampire();
    public abstract int attackDeath();
    
}
