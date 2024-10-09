/**
 * Represent a Car, which extends from class Vehicle, with more details: mileage, carDatabase
 * carDatabase is an object of class CarDatabase
 *
 * @author ccliu
 */
public class Car extends Vehicle {
  private int mileage;
  private CarDatabase carDatabase;
  final private int MILE_RANGE = 50;

  /**
   * Create a new Car
   * @param id is the unique id of the car
   * @param manufactureYear is the car's year of manufacture
   * @param makeAndModel is the car's make and model
   * @param MSRP is the car's manufacturer suggested retail price
   * @param mileage is the car's mileage
   */
  public Car(String id, int manufactureYear, MakeModel makeAndModel, double MSRP, int mileage) {
    super(id, manufactureYear, makeAndModel, MSRP);
    this.mileage = mileage;
    carDatabase = CarDatabase.getInstance();
    carDatabase.addMember(this);
  }

  /**
   *
   * @return the car's mileage
   */
  public int getMileage() {
    return mileage;
  }

  /**
   *
   * @return how many new car in the car database
   */
  public int getAvailableNewCarNumber() {
    return this.carDatabase.getNewCarNum();
  }

  /**
   *
   * @return the mile we decide this is a new car or a used car
   */
  public int getMILE_RANGE() {
    return MILE_RANGE;
  }

  /**
   *
   * @return the car database that we store all cars in it
   */
  public CarDatabase getCarDatabase() {
    return carDatabase;
  }

  /**
   * Override the toString()
   * @return the info of the car
   */
  @Override
  public String toString() {
    String res = super.toString();
    res += "Mileage: " + this.mileage + "\n";
    return res;
  }

}
