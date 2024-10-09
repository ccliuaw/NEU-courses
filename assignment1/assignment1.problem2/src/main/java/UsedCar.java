/**
 * Represent a Used car extends from class Car, with details: number of pre owner and number of minor accident
 *
 * @author ccliu
 */
public class UsedCar extends Car {
  private int numOfPreOwner;
  private int numOfMinorAccident;
  private CarDatabase carDatabase;

  /**
   * Create a new UsedCar by given inputs:
   * @param id is the unique id of the UsedCar
   * @param manufactureYear is the UsedCar's year of manufacture
   * @param makeAndModel is the UsedCar's make and model
   * @param MSRP is the UsedCar's manufacturer suggested retail price
   * @param mileage is the UsedCar's mileage
   * @param numOfPreOwner is the UsedCar's number of pre owner
   * @param numOfMinorAccident is the UsedCar's number of minor accident
   */
  public UsedCar(String id, int manufactureYear, MakeModel makeAndModel, double MSRP, int mileage, int numOfPreOwner, int numOfMinorAccident) {
    super(id, manufactureYear, makeAndModel, MSRP, mileage);
    this.numOfPreOwner = numOfPreOwner;
    this.numOfMinorAccident = numOfMinorAccident;
  }

  /**
   *
   * @return the UsedCar's number of pre owner
   */
  public int getNumOfPreOwner() {
    return numOfPreOwner;
  }

  /**
   *
   * @return the UsedCar's number of minor accident
   */
  public int getNumOfMinorAccident() {
    return numOfMinorAccident;
  }

  /**
   * Override the toString()
   * @return the info of the UsedCar
   */
  @Override
  public String toString() {
    String res = "This object is a used car. \n";
    res += super.toString();
    res += "Number of Pre Owner: " + this.numOfPreOwner + "\n";
    res += "Number of Minor Accident: " + this.numOfMinorAccident + "\n";
    return res;
  }
}
