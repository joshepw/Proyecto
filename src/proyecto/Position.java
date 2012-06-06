/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author joxhe
 */
class Position {
    private int x;
    private int y;
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public Position(Position pos){
        pos.x = x;
        pos.y = y;
    }
}
