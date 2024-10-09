/**
 * Represent a Boar extends from class Vessel, with details: length, num of passenger and propulsion type
 *
 * @author ccliu
 */
public class Boat extends Vessel {
  private float length;
  private int numOfPassenger;
  private PropulsionType propulsionType;

  /**
   * Create a new Boat with given:
   * @param id is the unique id of the Boat
   * @param manufactureYear is the Boat's year of manufacture
   * @param makeAndModel is the Boat's make and model
   * @param MSRP is the Boat's manufacturer suggested retail price
   * @param vesselType is the vessel's type, in this class, it's boat
   * @param length is the Boat's length
   * @param numOfPassenger is the Boat's num of passenger
   * @param propulsionType is the Boat's propulsion type
   */
  public Boat(String id, int manufactureYear, MakeModel makeAndModel, double MSRP, VesselType vesselType,
      float length, int numOfPassenger, PropulsionType propulsionType) {
    super(id, manufactureYear, makeAndModel, MSRP, vesselType);
    this.length = length;
    this.numOfPassenger = numOfPassenger;
    this.propulsionType = propulsionType;
  }

  /**
   *
   * @return the length of the boat
   */
  public float getLength() {
    return length;
  }

  /**
   *
   * @return the Boat's num of passenger
   */
  public int getNumOfPassenger() {
    return numOfPassenger;
  }

  /**
   *
   * @return the Boat's propulsion type
   */
  public PropulsionType getPropulsionType() {
    return propulsionType;
  }

  /**
   * Override the toString()
   * @return the info of the Boat
   */
  @Override
  public String toString() {
    String res = super.toString();
    res += "Length: " + length + "\n";
    res += "Num of Passenger: " + numOfPassenger + "\n";
    res += "Propulsion Type: " + propulsionType + "\n";
    return res;
  }
}
