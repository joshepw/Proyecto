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
public class piezaVampire extends Pieza{
    public piezaVampire(int pos_x,int pos_y,boolean player){
        super(12,pos_x,pos_y,player);
        tipo = piezaTipo.VAMPIRE;
    }

    @Override
    public int attackZombie() {
        return 0;
    }

    @Override
    public int attackWolf() {
        setLP(1);
        return -2;
    }

    @Override
    public int attackVampire() {
        setLP(2);
        return -3;
    }

    @Override
    public int attackDeath() {
        return -2;
    }

    @Override
    public ArrayList<Position> movePieza() {
        return moves;
    }
}
