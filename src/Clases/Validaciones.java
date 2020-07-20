package Clases;

public class Validaciones {
    
    public boolean ValidarNums(String Cadena){
        int nums=0;
        for(int i=0;i<Cadena.length();i++){
            switch(Cadena.charAt(i)){
                case '1':
                    nums+=1;
                    break;
                case '2':
                    nums+=1;
                    break;
                case '3':
                    nums+=1;
                    break;
                case '4':
                    nums+=1;
                    break;
                case '5':
                    nums+=1;
                    break;
                case '6':
                    nums+=1;
                    break;
                case '7':
                    nums+=1;
                    break;
                case '8':
                    nums+=1;
                    break;
                case '9':
                    nums+=1;
                    break;
                case '0':
                    nums+=1;
                    break;
                default:
                    
            }
        }
        return nums == (Cadena.length());
    }
    
    public boolean ValidarCaracts(String Cadena){
        int nums=0;
        for(int i=0;i<Cadena.length();i++){
            switch(Cadena.charAt(i)){
                case '1':
                    nums+=1;
                    break;
                case '2':
                    nums+=1;
                    break;
                case '3':
                    nums+=1;
                    break;
                case '4':
                    nums+=1;
                    break;
                case '5':
                    nums+=1;
                    break;
                case '6':
                    nums+=1;
                    break;
                case '7':
                    nums+=1;
                    break;
                case '8':
                    nums+=1;
                    break;
                case '9':
                    nums+=1;
                    break;
                case '0':
                    nums+=1;
                    break;
                default:
                    
            }
        }
        return nums <= 0;
    }
    
    public boolean ValidarLongitud(String Cadena,int Long){
        return Cadena.length() <= Long;
    }
    
    public boolean ValidarContenido(String Cadena){
        String Resultado="";
        for(int i=0;i<Cadena.length();i++){
            switch(Cadena.charAt(i)){
                case ' ':
                    break;
                default:
                    Resultado+=""+Cadena.charAt(i);
                    
            }
        }
        return Resultado.length() != 0;
    }
    
    public boolean ValidarFloat(String Cadena){
        boolean flag = true;
        try{
        float val = Float.parseFloat(Cadena);
        }
        catch(Exception e){
            flag = false;
        }
       return flag;
    }
    
    public boolean ValidarInt(String Cadena){
        boolean flag = true;
        try{
        int val = Integer.parseInt(Cadena);
        }
        catch(Exception e){
            flag = false;
        }
       return flag;
    }
    
}
