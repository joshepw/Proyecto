/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;

/**
 *
 * @author JoXhe
 */


//PARTE DE TABLERO - CLASS TEMPORAL
public class piezaMoves {
    public static final Position posOneMove[] = {new Position(1,-1),new Position(1,0),new Position(1,1),new Position(0,-1),new Position(0,1),new Position(-1,-1),new Position(-1,0),new Position(-1,1)};
    public static final Position posTwoMoves[] = {new Position(2,-2),new Position(2,0),new Position(2,2),new Position(0,-2),new Position(0,2),new Position(-2,-2),new Position(-2,0),new Position(-2,2)};
    public static final Position posLMove[] = {new Position(1,-2),new Position(2,-1),new Position(2,1),new Position(1,2),new Position(-1,-2),new Position(-2,-1),new Position(-2,1),new Position(-1,2)};
    
    public ArrayList<Position> getMoves(Pieza p,char tipo){
        ArrayList<Position> temp = new ArrayList();
        int x,y;
        switch(tipo){
            
            case '1':
                for(Position i: posOneMove){
                    x = i.x + p.getPosition().x;
                    y = i.y + p.getPosition().y;
                    if(x >= 0 && x <= 5 && y >= 0 && y <= 5)
                        temp.add(new Position(x,y));
                }
            break;
            
            case '2':
                for(Position i: posTwoMoves){
                    x = i.x + p.getPosition().x;
                    y = i.y + p.getPosition().y;
                    if(x >= 0 && x <= 5 && y >= 0 && y <= 5)
                        temp.add(new Position(x,y));
                }
            break;
            
            case 'L':
                for(Position i: posLMove){
                    x = i.x + p.getPosition().x;
                    y = i.y + p.getPosition().y;
                    if(x >= 0 && x <= 5 && y >= 0 && y <= 5)
                        temp.add(new Position(x,y));
                }
            break;
                
        }
        return temp;
    }
    
}
