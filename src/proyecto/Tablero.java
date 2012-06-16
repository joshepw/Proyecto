package proyecto;
import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    
    private static final Position posOneMove[] = {new Position(1,-1),new Position(1,0),new Position(1,1),new Position(0,-1),new Position(0,1),new Position(-1,-1),new Position(-1,0),new Position(-1,1)};
    private static final Position posTwoMoves[] = {new Position(2,-2),new Position(2,0),new Position(2,2),new Position(0,-2),new Position(0,2),new Position(-2,-2),new Position(-2,0),new Position(-2,2)};
    private static final Position posLMove[] = {new Position(1,-2),new Position(2,-1),new Position(2,1),new Position(1,2),new Position(-1,-2),new Position(-2,-1),new Position(-2,1),new Position(-1,2)};
    
    public Pieza Piezas[][];
    Random suffle = new Random();
    String player1P,player2P;
    
    public Tablero(String playerA,String playerB){
        Piezas = new Pieza[6][6];
        if(suffle.nextBoolean()){
            player1P = playerA;
            player2P = playerB;
        }else{
            player1P = playerB;
            player2P = playerA;
        }
        
        Piezas[0][0] = new piezaWolf(0,0,"1P","WHITE");
        Piezas[0][1] = new piezaVampire(0,1,"1P","WHITE");
        Piezas[0][2] = new piezaDeath(0,2,"1P","WHITE");
        Piezas[0][3] = new piezaDeath(0,3,"1P","WHITE");
        Piezas[0][4] = new piezaVampire(0,4,"1P","WHITE");
        Piezas[0][5] = new piezaWolf(0,5,"1P","WHITE");
        
        Piezas[5][0] = new piezaWolf(5,0,"2P","BLACK");
        Piezas[5][1] = new piezaVampire(5,1,"2P","BLACK");
        Piezas[5][2] = new piezaDeath(5,2,"2P","BLACK");
        Piezas[5][3] = new piezaDeath(5,3,"2P","BLACK");
        Piezas[5][4] = new piezaVampire(5,4,"2P","BLACK");
        Piezas[5][5] = new piezaWolf(5,5,"2P","BLACK");
        
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
        if(piezaAttack.getLP()<=0)
            piezaAttack = null;
        return false;
    }
    
    public String runDice(){
        int tipe = suffle.nextInt(3);
        if(tipe==0)
            return "WOLF";
        if(tipe==1)
            return "VAMPIRE";
        else
            return "DEATH";
    }
    
    public int nroPiezas(String player){
        int i = 0;
        for(int x=0;x<6;x++){
            for(int y=0;y<6;y++){
               if(Piezas[x][y].getPlayer().equals(player))
                i++;
            }
        }
        return i;
    }
    
}
