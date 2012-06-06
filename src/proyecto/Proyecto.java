/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Random;

/**
 *
 * @author joxhe
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pieza pZ = new piezaZombie(1,1,true);
        Pieza pW = new piezaWolf(1,2,false);
        Pieza pV = new piezaVampire(5,2,false);
        Tablero mv = new Tablero("Jose","Carlos");
        Random suffle = new Random();
        
        for(int i=0;i<10;i++){
            System.out.println(suffle.nextBoolean());
        }
        
        System.out.println(pW);
        System.out.println(pV);
        if(mv.piezaAttack(pV, pW))
            System.out.println("\n VAMPIRE ATTACK \n"+pW+"\n"+pV);
        
        System.out.println("\n ZOMBIE MOVES");
        for(Position i: mv.getMoves(pZ, 'L')){
            System.out.println("X : "+i.x+" / Y : "+i.y);
        }
        
        System.out.println("\n WOLF MOVES");
        for(Position i: mv.getMoves(pW, '2')){
            System.out.println("X : "+i.x+" / Y : "+i.y);
        }
        
        System.out.println("\n VAMPIRE MOVES");
        for(Position i: mv.getMoves(pV, '1')){
            System.out.println("X : "+i.x+" / Y : "+i.y);
        }
        
        if(mv.piezaAttack(pV, pW))
            System.out.println("\n VAMPIRE ATTACK \n"+pW+"\n"+pV);
    }
}
