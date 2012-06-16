package proyecto;

public class piezaDeath extends Pieza{
    public piezaDeath(int lp,int pos_x,int pos_y,String player, String color){
        super(lp,pos_x,pos_y,player,color);
        tipo = piezaTipo.DEATH;
    }
    
    public piezaDeath(int pos_x,int pos_y,String player, String color){
        super(15,pos_x,pos_y,player,color);
        tipo = piezaTipo.DEATH;
    }

    @Override
    public int attackZombie() {
        return -2;
    }

    @Override
    public int attackWolf() {
        return -4;
    }

    @Override
    public int attackVampire() {
        return -3;
    }

    @Override
    public int attackDeath() {
        return -2;
    }
}
