import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Task2 {

    public static void main(String[] args) {

        String csvFile = "./src/LadeStationen.csv";
        Task1.read(csvFile);

        ArrayList<ChargingStations> chargingStations = new ArrayList<>();

        int total = 21566;
        int counter = 0;
        for (ChargingStations station : Task1.chargingStationsArrayList) {
            if (station.getLatitude() > 90 || station.getLongitude() > 180) {
                //alles was in if schleife jedes mal durchgefuhren wird , wird gezählt


            }else {
                chargingStations.add(station);
                counter++;
            }
        }


        Collections.sort(chargingStations, new ChargingStationComparator());

        for (ChargingStations station : chargingStations) {
            System.out.println(station.chargingStationInfos());
        }
        System.out.println("Number of valid charging stations: " + counter + "  incurrect: " + (total - counter));
    }

        static class ChargingStationComparator implements Comparator<ChargingStations> {
        public int compare(ChargingStations a, ChargingStations b) {
            if (a.getZip_code() != b.getZip_code()) {
                return a.getZip_code() - b.getZip_code();
            }
            return (int) (b.getConnected_load() - a.getConnected_load());

        }

        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

    }
}
