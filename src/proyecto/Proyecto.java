package proyecto;

public class Proyecto {

    static Tablero mv = new Tablero("Jose","Carlos");
    
    public static void main(String[] args) {      
        
        System.out.println(mv.Piezas[0][4]);
        System.out.println(mv.Piezas[5][0]);
        if(mv.piezaAttack(mv.Piezas[0][4], mv.Piezas[5][0]))
            System.out.println("\n VAMPIRE ATTACK \n"+mv.Piezas[0][4]+"\n"+mv.Piezas[5][0]);
        
        System.out.println("\n VAMPIRE CAN MOVES");
        for(Position i: mv.getMoves(mv.Piezas[0][4], '1')){
            if(mv.Piezas[i.x][i.y]==null)
                System.out.println("X : "+i.x+" / Y : "+i.y);
        }
        
        System.out.println("\n VAMPIRE CAN ATTACK");
        for(Position i: mv.getMoves(mv.Piezas[0][4], '1')){
            if(mv.Piezas[i.x][i.y]!=null)
                System.out.println("X : "+i.x+" / Y : "+i.y);
        }
        
        System.out.println("\n WOLF CAN MOVES");
        for(Position i: mv.getMoves(mv.Piezas[5][0], '2')){
            if(mv.Piezas[i.x][i.y]==null)
                System.out.println("X : "+i.x+" / Y : "+i.y);
        }
        
        System.out.println("\n WOLF CAN ATTACK");
        for(Position i: mv.getMoves(mv.Piezas[5][0], '2')){
            if(mv.Piezas[i.x][i.y]!=null)
                System.out.println("X : "+i.x+" / Y : "+i.y);
        }
        
        if(mv.piezaAttack(mv.Piezas[0][4], mv.Piezas[5][0]))
            System.out.println("\n VAMPIRE ATTACK \n"+mv.Piezas[0][4]+"\n"+mv.Piezas[5][0]);
        
        mv.movePieza(5, 3, 3, 2);
        
        imprimirTablero();
        
        System.out.println(mv.Piezas[3][2]);
    }
    
    public static void imprimirTablero(){
        System.out.println("\n TABLERO \n    --Y0-- --Y1-- --Y2-- --Y3-- --Y4-- --Y5--\n");
        for(int x=0;x<6;x++){
            System.out.print("X"+x+"  ");
            for(int y=0;y<6;y++){
                if(mv.Piezas[x][y]!=null){
                    String p = "";
                    if(mv.Piezas[x][y].tipo.equals(piezaTipo.DEATH))
                        p = "D";
                    if(mv.Piezas[x][y].tipo.equals(piezaTipo.VAMPIRE))
                        p = "V";
                    if(mv.Piezas[x][y].tipo.equals(piezaTipo.WOLF))
                        p = "W";
                    if(mv.Piezas[x][y].tipo.equals(piezaTipo.ZOMBIE))
                        p = "Z";
                    p = p+":"+((mv.Piezas[x][y].isPlayer1P())? "1P " : "2P ");
                    
                    System.out.print((mv.Piezas[x][y].getLP()<10)? "0"+mv.Piezas[x][y].getLP()+p : mv.Piezas[x][y].getLP()+p);
                }else{
                    System.out.print("------ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
