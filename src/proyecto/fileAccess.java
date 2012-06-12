 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JoXhe
 */
public class fileAccess {
    private File file;
    private RandomAccessFile perfiles;
    private RandomAccessFile historial;
    private RandomAccessFile partidas;
    private RandomAccessFile partida;
    
    public fileAccess(){
        try{
            file = new File("partidas/");
            if(!file.exists())
                file.mkdir();
            perfiles = new RandomAccessFile("perfiles.vwg","rw");
            historial = new RandomAccessFile("historialJuegos.vwg","rw");
        }catch(IOException ex){
            //
        }
    }
    
    public boolean newUser(String fullName,String nickName,String password,int edad,String email){
        try {
            perfiles.seek(perfiles.length());
            
            perfiles.writeUTF(fullName);
            perfiles.writeUTF(nickName);
            perfiles.writeUTF(password);
            perfiles.writeInt(edad);
            perfiles.writeUTF(email);
            perfiles.writeInt(0);
            perfiles.writeInt(0);
            perfiles.writeBoolean(true);
                        
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public boolean nickNameExist(String nick){
        try {
            perfiles.seek(0);
            while(perfiles.getFilePointer()<perfiles.length()){
                perfiles.readUTF();
                String nickname = perfiles.readUTF();
                perfiles.readUTF();
                perfiles.readInt();
                perfiles.readUTF();
                perfiles.readInt();
                perfiles.readInt();
                if(perfiles.readBoolean() && nick.equals(nickname))
                    return true;
            }
            return false;
        } catch (IOException ex) { return false; }
    }
    
    public String[][] listStringUsers(){
        try{
            if(cantActiveUsers()!=0){
                String temp[][] = new String[cantActiveUsers()][7];
                int cont = 0;
                perfiles.seek(0);
                while(perfiles.getFilePointer()<perfiles.length()){
                    temp[cont][0] = perfiles.readUTF();
                    temp[cont][1] = perfiles.readUTF();
                    temp[cont][2] = perfiles.readUTF();
                    temp[cont][3] = perfiles.readInt()+"";
                    temp[cont][4] = perfiles.readUTF();
                    temp[cont][5] = perfiles.readInt()+"";
                    temp[cont][6] = perfiles.readInt()+"";
                    if(perfiles.readBoolean())
                        cont++;
                }            
                return temp;
            }
            return null;
        }catch(IOException ex){
            return null;
        } 
    }
    
    public int cantActiveUsers(){
        try {
            int cant = 0;
            perfiles.seek(0);
            while(perfiles.getFilePointer()<perfiles.length()){
                perfiles.readUTF();
                perfiles.readUTF();
                perfiles.readUTF();
                perfiles.readInt();
                perfiles.readUTF();
                perfiles.readInt();
                perfiles.readInt();
                if(perfiles.readBoolean())
                    cant++;
            }
            return cant;
        } catch (IOException ex) {
            return 0;
        }
    }
    
    public boolean disableUser(String nick){
        try {
            perfiles.seek(0);
            while(perfiles.getFilePointer()<perfiles.length()){
                perfiles.readUTF();
                String nickname = perfiles.readUTF();
                perfiles.readUTF();
                perfiles.readInt();
                perfiles.readUTF();
                perfiles.readInt();
                perfiles.readInt();
                if(perfiles.readBoolean() && nick.equals(nickname)){
                    perfiles.seek(perfiles.getFilePointer()-1);
                    perfiles.writeBoolean(false);
                    return true;
                }                    
            }
            return false;
        } catch (IOException ex) {
            return false;
        }
    }
    
    
    public int numPartidas(){
        return numPartidas(0);
    }
    
    private int numPartidas(int nro){
        file = new File("partidas/partidaNro_"+nro);
        if(file.exists()){
            return numPartidas(nro++);
        }else{
            return nro;
        }
    }
    
    public boolean newPartida(partida Partida){
        return setPartida(numPartidas()+1,Partida);
    }
    
    public partida getPartida(int nroFile){
        partida temp;
        file = new File("partidas/partidaNro_"+nroFile);
        if(file.exists()){
            try {
                partida = new RandomAccessFile("partidas/partidaNro_"+nroFile+".vwg","rw");
                partida.seek(0);
                temp = new partida(partida.readUTF(),partida.readUTF());
                temp.setSec(partida.readInt());
                temp.setMin(partida.readInt());
                temp.setHora(partida.readInt());
                temp.setFechaInicio(partida.readLong());
                temp.setFechaFin(partida.readLong());
                temp.setTurn(partida.readUTF());
                temp.setTurnNro(partida.readInt());
                temp.setWinner(partida.readUTF());
                temp.setActiva(partida.readBoolean());
                for(int x=0;x<6;x++){
                    for(int y=0;y<6;y++){
                        temp.setPieza(partida.readUTF(), partida.readInt(), x, y, partida.readBoolean());
                    }
                }
                partida.close();
                return temp;
                
            } catch (IOException ex) {
                return null;
            }
        }
        return null;
    }
    
    public boolean setPartida(int nroFile,partida temp){
        file = new File("partidas/partidaNro_"+nroFile);
        if(file.exists()){
            try{
                partida = new RandomAccessFile("partidas/partidaNro_"+nroFile+".vwg","rw");
                partida.seek(0);
                partida.writeUTF(temp.getNick1P());
                partida.writeUTF(temp.getNick2P());
                partida.writeInt(temp.getSec());
                partida.writeInt(temp.getMin());
                partida.writeInt(temp.getHora());
                partida.writeLong(temp.getFechaInicio());
                partida.writeLong(temp.getFechaFin());
                partida.writeUTF(temp.getTurn());
                partida.writeInt(temp.getTurnNro());
                partida.writeUTF(temp.getWinner());
                partida.writeBoolean(temp.isActiva());
                for(int x=0;x<6;x++){
                    for(int y=0;y<6;y++){
                        partida.writeUTF(temp.getPiezaTipo(x, y));
                        partida.writeInt(temp.getPiezaLP(x, y));
                        partida.writeBoolean(temp.getPiezaPlayer(x, y));                        
                    }
                }
                partida.close();
                return true;
            }catch(IOException ex){
                return false;
            }
        }else
            return false;
    }
}
