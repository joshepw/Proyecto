package proyecto;

public class nextData{
    public int dataInt(String data,int defaultInt){
        int i = 0;
        try{
            i = Integer.parseInt(data.replaceAll(" ", ""));
            return i;
        }catch(NumberFormatException ex){
            return defaultInt;
        }        
    }
	
    public double dataDouble(String data,double defaultDouble){
        double i = 0.0;
        try{
            i = Double.parseDouble(data.replaceAll(" ", "").replaceAll(",", ""));
            return i;
        }catch(NumberFormatException ex){
            return defaultDouble;
        }        
    }
	
    public String dataText(String data){
        String charText = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_", text = "";
        for ( int i = 0; i < data.length(); i++ ) {
            if ( charText.indexOf(data.charAt(i)) >= 0 )
                text += data.charAt(i);
        }
        return text;
    }

    public String dataTextEmail(String data){
        String charText = " @.abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_", text = "";
        for ( int i = 0; i < data.length(); i++ ) {
            if ( charText.indexOf(data.charAt(i)) >= 0 )
                text += data.charAt(i);
        }
        return text;
    }

    public String dataSoloText(String data){
        String charText = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", text = "";
        for ( int i = 0; i < data.length(); i++ ) {
            if ( charText.indexOf(data.charAt(i)) >= 0 )
                text += data.charAt(i);
        }
        return text;
    }
        
    public String dataChar(char[] data){
        String text = "";
        for(int i=0;i<data.length;i++){
            text = text + data[i];
        }
        return text;
    }
}
