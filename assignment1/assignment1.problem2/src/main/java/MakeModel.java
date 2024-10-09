/**
 * Represent the make and model of the Vehicle, with details: make and model
 *
 * @author ccliu
 */
public class MakeModel {
  private String make;
  private String model;

  /**
   * create a new MakeModel given no input
   * default make is ""
   * default model is ""
   */
  public MakeModel() {
    this.make = "";
    this.model = "";
  }

  /**
   * create a new MakeModel given make and model
   * @param make is the maker's name
   * @param model is the model's name
   */
  public MakeModel(String make, String model) {
    this.make = make;
    this.model = model;
  }

  /**
   *
   * @return the maker's name
   */
  public String getMake() {
    return make;
  }

  /**
   *
   * @return the model's name
   */
  public String getModel() {
    return model;
  }

  /**
   * Override the toString()
   * @return the make and model of the vehicle
   */
  @Override
  public String toString() {
    return "Make and Model: " + this.make + ", " + this.model;
  }
}
