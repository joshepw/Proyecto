package proyecto;

public class piezaWolf extends Pieza{
    public piezaWolf(int lp,int pos_x,int pos_y,String player, String color){
        super(lp,pos_x,pos_y,player,color);
        tipo = piezaTipo.WOLF;
    }
    
    public piezaWolf(int pos_x,int pos_y,String player, String color){
        super(10,pos_x,pos_y,player,color);
        tipo = piezaTipo.WOLF;
    }

    @Override
    public int attackZombie() {
        return -2;
    }

    @Override
    public int attackWolf() {
        return -3;
    }

    @Override
    public int attackVampire() {
        return -2;
    }

    @Override
    public int attackDeath() {
        return -1;
    }   
}
