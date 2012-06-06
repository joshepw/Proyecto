package proyecto;

public class piezaZombie extends Pieza{
    public piezaZombie(int pos_x,int pos_y,boolean player){
        super(2,pos_x,pos_y,player);
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
