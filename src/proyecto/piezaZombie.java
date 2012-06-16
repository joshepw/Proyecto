package proyecto;

public class piezaZombie extends Pieza{
    public piezaZombie(int lp,int pos_x,int pos_y,String player, String color){
        super(lp,pos_x,pos_y,player,color);
        tipo = piezaTipo.ZOMBIE;
    }
    
    public piezaZombie(int pos_x,int pos_y,String player, String color){
        super(2,pos_x,pos_y,player,color);
        tipo = piezaTipo.ZOMBIE;
    }

    @Override
    public int attackZombie() {
        return 0;
    }

    @Override
    public int attackWolf() {
        return 0;
    }

    @Override
    public int attackVampire() {
        return 0;
    }

    @Override
    public int attackDeath() {
        return 0;
    }
}
