import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String csvFile = "./src/LadeStationen.csv";
        Task1.read(csvFile);

        ArrayList<ChargingStations> chargingStations = new ArrayList<>();

        for (ChargingStations c:Task1.chargingStationsArrayList) {
            if (c.getLatitude() > 1000 || c.getLongitude() > 1000){
                chargingStations.add(c);
            }
        }

        Collections.sort(chargingStations);


        System.out.println("Program call with the arguments: ");
        int p1;
        int p2;

        p1= scanner.nextInt();
        p2= scanner.nextInt();

        if (p1 < 0 || p2 < 0){
            System.out.println("wrong");
        }

        System.out.println("Load data from file: ./src/res/ChargingStations.csv");

        System.out.println("Construct graph with max distance of "+p2);


        LinkedList list = new LinkedList();
        int remove = 0;
        for (int i = 0; i < chargingStations.size(); i++) {
            for (int j = 0; j < chargingStations.size(); j++) {

                if (i != j){

                    int result = distance_from(chargingStations.get(i),chargingStations.get(j));
                    if (result <= p1){
                        list.insertNode(chargingStations.get(i));
                        remove++;
                    }
                }

            }
        }

        list.printNodes();

    }
    public static int distance_from(ChargingStations c1, ChargingStations c2){
        return (int) Math.sqrt(Math.pow(c1.getLatitude() - c2.getLatitude(),2) +
                Math.pow(c1.getLongitude() - c2.getLongitude(),2));
    }
}

 class Node {
    public ChargingStations item;
    public Node next;
}


class LinkedList {
    private int size;
    private Node head;

    public LinkedList() {
        this.size = 0;
        this.head = null;
    }

    /**
     * Inserting new node at the end of the linked list
     *
     * @param item - represent the node item to be added to the linked list
     */
    public void insertNode(ChargingStations item) {
        Node node = new Node();
        node.item = item;
        Node current = this.head;

        if (this.head == null) {
            this.head = node;
            this.head.next = null;
            this.size = 1;
            System.out.println(this.head.toString());
        } else {

            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.next = null;
            this.size += 1;
        }
    }

    /**
     * Adding node at the first location of the linked list
     *
     * @param item - represent item of the node to be added to LL
     */
    public void insertFirst(ChargingStations item){
        Node node = new Node();
        node.item = item;
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    public boolean findNode(int code) {
        Node node = this.head;
        boolean found = false;
        for(int i=0;i<size; i++){
            if(node.item.getZip_code() == code){
//                System.out.println("Item "+item+" was found at location "+i+" in the linked list");
                return true;
            }
            node = node.next;
        }

        return false;
//           System.out.println("Item "+item+" was not found in the Linked list");
    }

    public void printNodes() {
        if (this.size < 1)
            System.out.println("There are no nodes in the linked list");
        else {
            Node current = this.head;
            for (int i = 0; i < this.size; i++) {
                System.out.println(current.item.chargingStationInfos());
                current = current.next;
            }
        }
    }
}

