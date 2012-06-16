/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Date;

/**
 *
 * @author JoXhe
 */
public class partida {
    private String nick1P;
    private String nick2P;
    private int sec;
    private int min;
    private int hora;
    private long fechaInicio;
    private long fechaFin;
    private String turn;
    private int turnNro;
    private Pieza tablero[][];
    private String winner;
    private boolean activa;
    
    public partida(String p1,String p2){
        nick1P = p1;
        sec = 0;
        min = 0;
        hora = 0;
        fechaInicio = new Date().getTime();
        turn = "1P";
        turnNro = 1;
        tablero = new Pieza[6][6];
        winner = "";
        activa = true;
    }
    
    public void salvarPartida(int sec,int min,int hora,String turn,int turnNro){
       this.sec = sec;
       this.min = min;
       this.hora = hora;
       this.turn = turn;
       this.turnNro = turnNro;
    }
    
    public Pieza[][] getTablero(){
        return tablero;
    }
    
    public void setTablero(Pieza[][] tablero){
        this.tablero = tablero;
    }
    
    public void setPieza(String tipo,int lp,int x,int y,String player,String color){
        if(tipo.equals("ZOMBIE"))
            this.tablero[x][y] = new piezaZombie(lp,x,y,player,color);
        if(tipo.equals("WOLF"))
            this.tablero[x][y] = new piezaWolf(lp,x,y,player,color);
        if(tipo.equals("VAMPIRE"))
            this.tablero[x][y] = new piezaVampire(lp,x,y,player,color);
        if(tipo.equals("DEATH"))
            this.tablero[x][y] = new piezaDeath(lp,x,y,player,color);
        if(tipo.equals("NONE"))
            this.tablero[x][y] = null;
    }
    
    public String getPiezaTipo(int x,int y){
        return ""+tablero[x][y].tipo;
    }
    
    public int getPiezaLP(int x,int y){
        return tablero[x][y].getLP();
    }
    
    public String getPiezaPlayer(int x,int y){
        return tablero[x][y].getPlayer();
    }
    
    public String getPiezaColor(int x,int y){
        return tablero[x][y].getColor();
    }

    public long getFechaInicio() {
        return fechaInicio;
    }

    public int getHora() {
        return hora;
    }

    public int getMin() {
        return min;
    }

    public String getNick1P() {
        return nick1P;
    }

    public String getNick2P() {
        return nick2P;
    }

    public int getSec() {
        return sec;
    }

    public String getTurn() {
        return turn;
    }

    public int getTurnNro() {
        return turnNro;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setFechaInicio(long fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public void setTurnNro(int turnNro) {
        this.turnNro = turnNro;
    }

    public long getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(long fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
