package proyecto;

public class piezaVampire extends Pieza{
    public piezaVampire(int lp,int pos_x,int pos_y,String player, String color){
        super(lp,pos_x,pos_y,player,color);
        tipo = piezaTipo.VAMPIRE;
    }
    
    public piezaVampire(int pos_x,int pos_y,String player, String color){
        super(12,pos_x,pos_y,player,color);
        tipo = piezaTipo.VAMPIRE;
    }

    @Override
    public int attackZombie() {
        return 0;
    }

    @Override
    public int attackWolf() {
        setLP(1);
        return -2;
    }

    @Override
    public int attackVampire() {
        setLP(2);
        return -3;
    }

    @Override
    public int attackDeath() {
        return -2;
    }
}
