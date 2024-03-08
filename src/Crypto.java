import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Crypto{

    static protected String Cesar(String data,int shift){
        StringBuilder output = new StringBuilder(data.length());
        for(char singleChar : data.toCharArray()){
            int shiftedChar =(int) (singleChar + shift)%256;
            output.append((char)shiftedChar);
        }

        return output.toString();
    }


    static private String xorAlgo(String data, String key){
        StringBuilder acc = new StringBuilder();

        for(int i=0; i<data.length(); i++){
            char d=data.charAt(i);
            char k= key.charAt(i % key.length());

            char xorChar = (char) (d^k);
            acc.append(xorChar);
        }

        return acc.toString();
    }

    public static void cripta(String fileName,int shift,String key){
        try{
            BufferedReader reader= new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder content = new StringBuilder();
            while((line=reader.readLine())!= null) {
                content.append(line);
            }
            reader.close();

            String xorEncrypted = xorAlgo(content.toString(), key);
            String cesarEncrypted= Cesar(xorEncrypted, shift);

            FileWriter writer= new FileWriter(fileName);
            writer.write(cesarEncrypted);
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void decripta(String fileName, int shift, String key){
        try{
            BufferedReader reader= new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder content = new StringBuilder();
            while((line=reader.readLine())!= null) {
                content.append(line);
            }
            reader.close();

            String cesarDecrypted= Cesar(content.toString(), -shift);
            String xorDecrypted = xorAlgo(cesarDecrypted, key);

            FileWriter writer= new FileWriter(fileName);
            writer.write(xorDecrypted);
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void stampa(String fileName, int shift, String key){
        try{
            BufferedReader reader= new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder content = new StringBuilder();
            while ((line= reader.readLine())!=null){
                content.append(line);
            }
            reader.close();

            String cesarDecrypted = Cesar(content.toString(), - shift);
            String xorDecrypted = xorAlgo(cesarDecrypted, key);

            System.out.println(xorDecrypted);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

