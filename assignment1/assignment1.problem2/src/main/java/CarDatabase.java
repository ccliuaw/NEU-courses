import java.util.HashMap;
import java.util.Map;

/**
 * Represent a database of cars, include: new car numbers and car list
 *
 * @author ccliu
 */
public class CarDatabase {

  private static CarDatabase instance;
  private int newCarNum;
  private Map<String, Car> carList = new HashMap<>();

  /**
   * using this getter to access the same dataset
   *
   * @return the carDatabase of cars
   */
  public static CarDatabase getInstance() {
    if (CarDatabase.instance == null) {
      CarDatabase.instance = new CarDatabase();
    }

    return CarDatabase.instance;
  }

  /**
   * @return car list, key is car ID, value is car instance
   */
  public Map<String, Car> getCarList() {
    return this.carList;
  }

  /**
   * @return total new car numbers in the car database
   */
  public int getNewCarNum() {
    return this.newCarNum;
  }

  /**
   * adding Car object into database
   *
   * @param car is Car object
   */
  public void addMember(Car car) {
    this.carList.put(car.getId(), car);
  }

  /**
   * if the car is new car, adding the number of new car by one
   */
  public void addNewCar() {
    this.newCarNum++;
  }

  /**
   * Override the toString()
   *
   * @return every car in the car list with their id
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CarDatabase :").append("\n");
    for (Map.Entry<String, Car> entry : this.carList.entrySet()) {
      builder.append(entry.getKey()).append(", ");
    }
    return builder.append("\n").toString();
  }
}

