/**
 * Represents	a contact info of the tax filer
 * with details : name, physical address, phone and email
 * the name is a object of class Name{}
 *
 * @author ccliu
 */
public class ContactInfo {
  private Name name;
  private String address;
  private String phone;
  private String email;

  /**
   * Create a new ContactInfo given the tax filer's name, address, phone and email.
   *
   * @param name of the filer
   * @param address of the filer
   * @param phone of the filer
   * @param email of the filer
   */
  public ContactInfo(Name name, String address, String phone, String email) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    this.email = email;
  }

  /**
   *
   * @return the name object, type Name, an object of class Name{}
   */
  public Name getName() {
    return name;
  }

  /**
   *
   * @return the address, type String
   */
  public String getAddress() {
    return address;
  }

  /**
   *
   * @return the phone number, type String
   */
  public String getPhone() {
    return phone;
  }

  /**
   *
   * @return the email, type String
   */
  public String getEmail() {
    return email;
  }

}
