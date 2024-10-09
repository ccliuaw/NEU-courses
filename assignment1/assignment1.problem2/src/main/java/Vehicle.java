/**
 * Represent a vehicle, with details: id, manufacture year, make and model, manufacturer suggested retail price
 * make and model is an object of class MakeModel
 *
 * @author ccliu
 */
public class Vehicle {
  private String id;
  private int manufactureYear;
  private MakeModel makeAndModel;
  private double MSRP;  // manufacturer suggested retail price

  /**
   * Create a new Vehicle
   * @param id is the unique id of the vehicle
   * @param manufactureYear is the vehicle's year of manufacture
   * @param makeAndModel is the vehicle's make and model
   * @param MSRP is the vehicle's manufacturer suggested retail price
   */
  public Vehicle(String id, int manufactureYear, MakeModel makeAndModel, double MSRP) {
    this.id = id;
    this.manufactureYear = manufactureYear;
    this.makeAndModel = makeAndModel;
    this.MSRP = MSRP;
  }

  /**
   *
   * @return id of the vehicle
   */
  public String getId() {
    return id;
  }

  /**
   *
   * @return vehicle's year of manufacture
   */
  public int getManufactureYear() {
    return manufactureYear;
  }

  /**
   *
   * @return the vehicle's make and model
   */
  public MakeModel getMakeAndModel() {
    return makeAndModel;
  }

  /**
   *
   * @return the vehicle's manufacturer suggested retail price
   */
  public double getMSRP() {
    return MSRP;
  }

  /**
   * Override the toString()
   * @return the info of the vehicle
   */
  @Override
  public String toString() {
    String res = new String();
    res += "Vehicle ID: " + this.getId() + "\n";
    res += "ManufactureYear: " + this.getManufactureYear() + "\n";
    res += this.getMakeAndModel().toString() + "\n";
    res += "MSRP: " + this.getMSRP() + "\n";
    return res;
  }
}
