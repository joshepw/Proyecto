/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

//import java.util.ArrayList;

import java.util.ArrayList;


/**
 *
 * @author joxhe
 */
public abstract class Pieza {
    protected int LP;
    protected Position posPieza;
    protected ArrayList<Position> moves;
    protected boolean nPlayer;
    protected piezaTipo tipo;
    
    public Pieza(int points,int pos_x,int pos_y,boolean player){
        LP = points;
        posPieza = new Position(pos_x,pos_y);
        nPlayer = player;
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
    
    public abstract int attackZombie();    
    public abstract int attackWolf();    
    public abstract int attackVampire();
    public abstract int attackDeath();
    
    public abstract ArrayList<Position> movesPieza();
    
    @Override
    public String toString(){
        return "Pieza:"+tipo.name()+" / Posicion X:"+posPieza.x+" Y:"+posPieza.y+" / LP:"+LP;
    }
}
