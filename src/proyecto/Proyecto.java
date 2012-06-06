/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

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
        
        System.out.println(pW);
        System.out.println(pV);
        if(pW.setLP(pV.attackWolf())){
            System.out.println("VAMPIRE ATTACK");
            System.out.println(pW);
            System.out.println(pV);    
        }
    }
}
