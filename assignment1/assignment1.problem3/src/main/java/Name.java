/**
 * Represents	a name, with : first name and last name
 *
 * @author ccliu
 */
public class Name {
  private String firstName;
  private String lastName;

  /**
   * create a new Name given the firstName and lastName
   * @param firstName of the filer
   * @param lastName of the filer
   */
  public Name(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   *
   * @return first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   *
   * @return last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   *
   * @return full name, first name + last name
   */
  public String getFullName() {
    return firstName + " " + lastName;
  }
}
