public class Main {
    public static void main(String[] args) {
        String fileName = "data.txt";
        int shift = 3;
        String key = "chiaveSegreta";

        Crypto.cripta(fileName, shift, key);
        System.out.println("Il tuo file è stato criptato correttamente.");

        Crypto.decripta(fileName, shift, key);
        System.out.println("File decriptato correttamente.");
    }
}

class Crypto {
    static protected String Cesar(String data, int shift) {
        StringBuilder output = new StringBuilder(data.length());

        for (char singleChar : data.toCharArray()) {
            int shiftedChar = (int) (singleChar + shift) % 256;
            output.append((char) shiftedChar);
        }
        return output.toString();
    }

    static private String xorAlgo(String data, String key) {
        StringBuilder acc = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char d = data.charAt(i);
            char k = key.charAt(i % key.length());
            char xorChar = (char) (d ^ k);
            acc.append(xorChar);
        }
        return acc.toString();
    }
}



