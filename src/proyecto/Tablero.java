package proyecto;
import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    public static final Position posOneMove[] = {new Position(1,-1),new Position(1,0),new Position(1,1),new Position(0,-1),new Position(0,1),new Position(-1,-1),new Position(-1,0),new Position(-1,1)};
    public static final Position posTwoMoves[] = {new Position(2,-2),new Position(2,0),new Position(2,2),new Position(0,-2),new Position(0,2),new Position(-2,-2),new Position(-2,0),new Position(-2,2)};
    public static final Position posLMove[] = {new Position(1,-2),new Position(2,-1),new Position(2,1),new Position(1,2),new Position(-1,-2),new Position(-2,-1),new Position(-2,1),new Position(-1,2)};
    private ArrayList<Pieza> Piezas;
    Random suffle = new Random();
    String player1P,player2P;
    
    public Tablero(String playerA,String playerB){
        Piezas = new ArrayList();
        boolean playerBlanco = suffle.nextBoolean();
        boolean playerNegro = (playerBlanco)? false : true;
        if(playerBlanco){
            player1P = playerA;
            player2P = playerB;
        }else{
            player1P = playerB;
            player2P = playerA;
        }
        Piezas.add(new piezaWolf(0,0,playerBlanco));
        Piezas.add(new piezaVampire(0,1,playerBlanco));
        Piezas.add(new piezaDeath(0,2,playerBlanco));
        Piezas.add(new piezaDeath(0,3,playerBlanco));
        Piezas.add(new piezaVampire(0,4,playerBlanco));
        Piezas.add(new piezaWolf(0,5,playerBlanco));
        
        Piezas.add(new piezaWolf(5,0,playerNegro));
        Piezas.add(new piezaVampire(5,1,playerNegro));
        Piezas.add(new piezaDeath(5,2,playerNegro));
        Piezas.add(new piezaDeath(5,3,playerNegro));
        Piezas.add(new piezaVampire(5,4,playerNegro));
        Piezas.add(new piezaWolf(5,5,playerNegro));
    }
    
    public String getPlayer1P(){
        return player1P;
    }
    
    public String getPlayer2P(){
        return player2P;
    }
    
    public ArrayList<Position> getMoves(Pieza p,char tipo){
        ArrayList<Position> temp = new ArrayList();
        int x,y;
        Position move[];
        if(tipo=='1')
            move = posOneMove;
        else if(tipo=='2')
            move = posTwoMoves;
        else if(tipo=='L')
            move = posLMove;
        else
            move = null;
        
        for(Position i: move){
            x = i.x + p.getPosition().x;
            y = i.y + p.getPosition().y;
            if(x >= 0 && x <= 5 && y >= 0 && y <= 5)
                temp.add(new Position(x,y));
        }
        return temp;
    }
    
    public boolean piezaAttack(Pieza miPieza, Pieza piezaAttack){
        if(piezaAttack.tipo.equals(piezaTipo.ZOMBIE))
            return piezaAttack.setLP(miPieza.attackZombie());
        if(piezaAttack.tipo.equals(piezaTipo.WOLF))
            return piezaAttack.setLP(miPieza.attackWolf());
        if(piezaAttack.tipo.equals(piezaTipo.VAMPIRE))
            return piezaAttack.setLP(miPieza.attackVampire());
        if(piezaAttack.tipo.equals(piezaTipo.DEATH))
            return piezaAttack.setLP(miPieza.attackDeath());
        return false;
    }
    
}
