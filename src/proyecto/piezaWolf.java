/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;

/**
 *
 * @author joxhe
 */
public class piezaWolf extends Pieza{
    public piezaWolf(int pos_x,int pos_y,boolean player){
        super(10,pos_x,pos_y,player);
        tipo = piezaTipo.WOLF;
    }

    @Override
    public int attackZombie() {
        return 2;
    }

    @Override
    public int attackWolf() {
        return 3;
    }

    @Override
    public int attackVampire() {
        return 2;
    }

    @Override
    public int attackDeath() {
        return 1;
    }

    @Override
    public ArrayList<Position> movePieza() {
        return moves;
    }
    
}
