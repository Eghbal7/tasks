import java.io.*;
import java.util.ArrayList;



public class Task1 {

    public static ArrayList<ChargingStations>chargingStationsArrayList = new ArrayList<>();
//In diesem Fall wird das Feld delimiter als Trennzeichen verwendet, um die Werte in einer Zeichenfolge zu trennen.
    public static final String delimiter = ";";
    public static void read(String csvFile) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] s;
            while((line = br.readLine()) != null) {
                s = line.split(delimiter);

                chargingStationsArrayList.add(new ChargingStations(s[0],s[1], s[2],Integer.parseInt(s[3]),
                        s[4],s[5],Double.parseDouble(s[6]),Double.parseDouble(s[7]),Double.parseDouble(s[8])));
            }

            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // csv file für lesen
        String csvFile = "./src/LadeStationen.csv";
        long start = System.currentTimeMillis();
        read(csvFile);

        int total = 21566;
        int counter=0;
        /* jedes Element in der chargingStationsArrayList zu durchlaufen.
         Das aktuelle Element wird in der Variablen c gespeichert.
         */
        for (ChargingStations station:chargingStationsArrayList) {
            /*Dieser Code überprüft, ob die Breitengrad- oder Längengradkoordinate einer
            Ladestation größer als 1000 ist. Wenn entweder der Breitengrad oder der Längengrad
            größer als 1000 ist, wird der Code innerhalb der geschweiften Klammern ausgeführt.
             Wenn beide Koordinaten kleiner oder gleich 1000 sind, wird der Code übersprungen.
             */
            if (station.getLatitude() > 1000 || station.getLongitude() > 1000){
                System.out.println("Do not enter charging station. Incorrect latitude or longitude:");
                System.out.println(station.toString());
                counter++;
            }

        }
        System.out.println("Incorrect latitude or longitude:" + counter);
        long end = System.currentTimeMillis();
        System.out.println("Number of valid charging stations: "+(total - counter));
        double elapsedTime = (double)(end - start);
        System.out.println("Die Bearbeitungszeit betrug " + elapsedTime  + " millisekunden.");

    }

    }


