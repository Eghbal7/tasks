/* Das Comparable-Interface ist ein Java-Interface,
das eine Methode namens compareTo definiert, die verwendet wird, um Objekte miteinander zu vergleichen.
 */
public class ChargingStations implements Comparable {
          //Attribute
    private String operator;
    private String street;
    private String houseNumber;
    private int zip_code;
    private String city;
    private String state;
    private double latitude;
    private double longitude;
    private double connected_load;
        //constructor
    public ChargingStations(String operator,String street, String houseNumber, int zip_code, String city, String state, double latitude, double longitude, double connected_load) {
        this.operator = operator;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zip_code = zip_code;
        this.city = city;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
        this.connected_load = connected_load;
    }
    //setter und getter method
    /* die Annotation @SuppressWarnings("unused") wird verwendet,
    um den Java-Compiler daran zu hindern, eine Warnung wegen nicht verwendeter Elemente zu generieren.
     */
    @SuppressWarnings("unused")
    public String getOperator() {
        return operator;
    }
    @SuppressWarnings("unused")
    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    @SuppressWarnings("unused")
    public String getHouseNumber() {
        return houseNumber;
    }
    @SuppressWarnings("unused")
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }


    public int getZip_code() {
        return zip_code;
    }
    @SuppressWarnings("unused")
    public void setZip_code(int zip_code) {
        this.zip_code = zip_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @SuppressWarnings("unused")
    public String getState() {
        return state;
    }
    @SuppressWarnings("unused")
    public void setState(String state) {
        this.state = state;
    }

    public double getLatitude() {
        return latitude;
    }
    @SuppressWarnings("unused")
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    @SuppressWarnings("unused")
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    @SuppressWarnings("unused")
    public double getConnected_load() {
        return connected_load;
    }
    @SuppressWarnings("unused")
    public void setConnected_load(double connected_load) {
        this.connected_load = connected_load;
    }


    @Override
    public String toString() {
        return "ChargingStations{" +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
    public String chargingStationInfos() {
        return "" + "" + operator  +
                ", " + street +
                ", " + houseNumber +
                ", " + zip_code +
                ", " + city +
                ", " + state +
                ", " + connected_load +
                "";
    }
/*hier wird die postleitzahl der Ladestations
 miteinander vergleicht
 */
    @Override
    public int compareTo(Object chargingStations) {
        int compareage=((ChargingStations)chargingStations).getZip_code();
        /* For Ascending order*/
        return this.zip_code-compareage;
    }
}
