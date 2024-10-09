/**
 * Represent a new car extends from class Car, with details: within miles
 *
 * @author ccliu
 */
public class NewCar extends Car {
  private boolean withinMiles;
  private CarDatabase carDatabase;

  /**
   * Create a new NewCar with following inputs
   * @param id is the unique id of the NewCar
   * @param manufactureYear is the NewCar's year of manufacture
   * @param makeAndModel is the NewCar's make and model
   * @param MSRP is the NewCar's manufacturer suggested retail price
   * @param mileage is the NewCar's mileage
   */
  public NewCar(String id, int manufactureYear, MakeModel makeAndModel, double MSRP, int mileage) {
    super(id, manufactureYear, makeAndModel, MSRP, mileage);
    if (this.getMileage() <= super.getMILE_RANGE()) {
      this.withinMiles = true;
      this.carDatabase = CarDatabase.getInstance();
      this.carDatabase.addNewCar();
    }
    else{
      System.out.println("This car '" + id + "' is not a NEW CAR, the mileage "+ mileage+" is over limit: " + super.getMILE_RANGE() + ".");
      System.out.println("This car will not be added into the database.");
      this.withinMiles = false;
    }
  }

  /**
   *
   * @return this car is within the new car mile range or not
   */
  public boolean isWithinMiles() {
    return withinMiles;
  }

  /**
   * Override the toString()
   * @return the info of the NewCar
   */
  @Override
  public String toString() {
    String res = "This object is a new car.\n";
    res += super.toString();
    return res;
  }
}
