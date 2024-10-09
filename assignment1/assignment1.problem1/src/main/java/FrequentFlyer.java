

/**
 * Represent a FrequentFlyer, with details: user id, first name, middle name, last name, email, mile balance
 *
 * @author ccliu
 */
public class FrequentFlyer {

  private FrequentFlyerDatabase database;
  private int totalMember;
  private String userID;
  private String firstName;
  private String middleName;
  private String lastName;
  private String email;
  private MileBalance mileBalance;
  final private int ID_LENGTH = 12;

  /**
   * Create a new FrequentFlyer and store this user into database, given:
   * @param userID is user's unique id
   * @param firstName is user's first name
   * @param middleName is user's middle name
   * @param lastName is user's last name
   * @param email is user's email
   */
  public FrequentFlyer(String userID, String firstName, String middleName, String lastName,
      String email) {
    this.database = FrequentFlyerDatabase.getInstance();
    this.userID = userID;
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.email = email;
    this.mileBalance = new MileBalance();
    checkID(userID);
    this.database.addMember(this);
  }

  /**
   *
   * @return user's unique id
   */
  public String getUserID() {
    return this.userID;
  }

  /**
   *
   * @return user's first name
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   *
   * @return user's middle name
   */
  public String getMiddleName() {
    return this.middleName;
  }

  /**
   *
   * @return user's last name
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   *
   * @return user's emailv
   */
  public String getEmail() {
    return this.email;
  }

  /**
   *
   * @return user's mile balance
   */
  public MileBalance getMileBalance() {
    return this.mileBalance;
  }

  /**
   *
   * @return total user number in the database
   */
  public int getTotalMember() {
    return this.totalMember = this.database.getMemberList().size();
  }

  /**
   * setting the total miles for this user
   * @param totalMiles is desired value of total miles
   */
  public void setTotalMiles(int totalMiles) {
    this.getMileBalance().setTotalMile(totalMiles);
  }

  /**
   * check this user id is valid or not (checking the length and duplication of id)
   * @param userID is the user's id
   */
  private void checkID(String userID) {
    if (userID.length() != ID_LENGTH) {
      throw new IllegalArgumentException("UserID must have length of: " + ID_LENGTH);
    }
    if (!this.database.getMemberList().isEmpty() && this.database.getMemberList().containsKey(userID)) {
      throw new IllegalArgumentException("UserID: " + userID + " already exists");
    }
  }

  /**
   * create a deposit to transfer money into recipient's account
   * @param amount is the amount of deposit
   * @param recipientID is the id of recipient
   * @param recipientFirstName is the first name of recipient
   * @param recipientMiddleName is the middle name of recipient
   * @param recipientLastName is the last name of recipient
   * @return a Deposit contains info above
   */
  public Deposit createDeposit(int amount, String recipientID, String recipientFirstName,
      String recipientMiddleName, String recipientLastName) {
    return new Deposit(amount, recipientID, recipientFirstName, recipientMiddleName,
        recipientLastName);
  }

  /**
   * checking this deposit is valid or not
   * 1. check recipient is in the member list
   * 2. check recipient is valid
   * 3. check recipient's first, middle, last name
   * @param deposit is the deposit we want to check
   */
  private void checkDeposit(Deposit deposit) {
    // check recipient is in the member list
    if (!this.database.getMemberList().containsKey(deposit.getRecipientID())){
      throw new IllegalArgumentException("Recipient ID not found");
    }
    // check recipient is valid
    if (deposit.getRecipientID().equals(this.userID)) {
      throw new IllegalArgumentException("This is your own account");
    }
    // check recipient's first, middle, last name
    FrequentFlyer recipient = this.database.getMemberList().get(deposit.getRecipientID());
    if (!recipient.getFirstName().equals(deposit.getRecipientFirstName())
        || !recipient.getMiddleName().equals(deposit.getRecipientMiddleName())
        || !recipient.getLastName().equals(deposit.getRecipientLastName())) {
      throw new IllegalArgumentException("Invalid recipient first or middle or last name");
    }
  }

  /**
   * transfer miles from sender to recipient
   * @param deposit is the deposit of this transfer
   */
  public void transferMiles(Deposit deposit) {
    checkDeposit(deposit);
    // subtract miles from sender
    this.getMileBalance().subtractMile(deposit.getAmount());
    // add miles for recipient
    FrequentFlyer recipient = this.database.getMemberList().get(deposit.getRecipientID());
    recipient.getMileBalance().addMile(deposit.getAmount());
  }

  /**
   * override the toString() method
   * @return user's id, full name and email
   */
  @Override
  public String toString() {
    return "FrequentFlyer [UserId= " + this.getUserID() + ", FullName= " + this.getFirstName() + ", " +
        this.getMiddleName() + ", " + this.getLastName() + ", Email= " + this.getEmail() + "]";
  }

}
