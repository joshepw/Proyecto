package proyecto;
import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    
    public static final Position posOneMove[] = {new Position(1,-1),new Position(1,0),new Position(1,1),new Position(0,-1),new Position(0,1),new Position(-1,-1),new Position(-1,0),new Position(-1,1)};
    public static final Position posTwoMoves[] = {new Position(2,-2),new Position(2,0),new Position(2,2),new Position(0,-2),new Position(0,2),new Position(-2,-2),new Position(-2,0),new Position(-2,2)};
    public static final Position posLMove[] = {new Position(1,-2),new Position(2,-1),new Position(2,1),new Position(1,2),new Position(-1,-2),new Position(-2,-1),new Position(-2,1),new Position(-1,2)};
    
    public Pieza Piezas[][];
    Random suffle = new Random();
    String player1P,player2P;
    
    public Tablero(String playerA,String playerB){
        Piezas = new Pieza[6][6];
        boolean playerBlanco = suffle.nextBoolean();
        boolean playerNegro = (playerBlanco)? false : true;
        if(playerBlanco){
            player1P = playerA;
            player2P = playerB;
        }else{
            player1P = playerB;
            player2P = playerA;
        }
        
        Piezas[0][0] = new piezaWolf(0,0,playerBlanco);
        Piezas[0][1] = new piezaVampire(0,1,playerBlanco);
        Piezas[0][2] = new piezaDeath(0,2,playerBlanco);
        Piezas[0][3] = new piezaDeath(0,3,playerBlanco);
        Piezas[0][4] = new piezaVampire(0,4,playerBlanco);
        Piezas[0][5] = new piezaWolf(0,5,playerBlanco);
        
        Piezas[5][0] = new piezaWolf(5,0,playerNegro);
        Piezas[5][1] = new piezaVampire(5,1,playerNegro);
        Piezas[5][2] = new piezaDeath(5,2,playerNegro);
        Piezas[5][3] = new piezaDeath(5,3,playerNegro);
        Piezas[5][4] = new piezaVampire(5,4,playerNegro);
        Piezas[5][5] = new piezaWolf(5,5,playerNegro);
        
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
    
    public boolean movePieza(int xOld, int yOld, int xNew, int yNew){
        if(xOld >= 0 && xOld <= 5 && yOld >= 0 && yOld <= 5){
            Piezas[xNew][yNew] = Piezas[xOld][yOld];
            Piezas[xNew][yNew].setPostion(new Position(xNew,yNew));
            Piezas[xOld][yOld] = null;
            return true;
        }
        return false;
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
