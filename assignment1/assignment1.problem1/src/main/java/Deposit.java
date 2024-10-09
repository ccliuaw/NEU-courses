/**
 * Represent a Deposit, with details: amount, recipient id, recipient first name, recipient middle name, recipient last name
 *
 * @author ccliu
 */
public class Deposit {

  private int amount;
  private String recipientID;
  private String recipientFirstName;
  private String recipientMiddleName;
  private String recipientLastName;
  final private int DEPOSIT_MIN_VALUE = 1000;
  final private int DEPOSIT_MAX_VALUE = 10000;

  /**
   * Create a new Deposit, given:
   * @param amount is the amount of miles
   * @param recipientID is recipient's id
   * @param recipientFirstName is recipient's first name
   * @param recipientMiddleName is recipient's middle name
   * @param recipientLastName is recipient's last name
   */
  public Deposit(int amount, String recipientID, String recipientFirstName,
      String recipientMiddleName, String recipientLastName) {
    checkAmount(amount);
    this.amount = amount;
    this.recipientID = recipientID;
    this.recipientFirstName = recipientFirstName;
    this.recipientMiddleName = recipientMiddleName;
    this.recipientLastName = recipientLastName;
  }

  /**
   *
   * @return amount of the deposit
   */
  public int getAmount() {
    return amount;
  }

  /**
   *
   * @return recipient's id of the deposit
   */
  public String getRecipientID() {
    return recipientID;
  }

  /**
   *
   * @return recipient's first name of the deposit
   */
  public String getRecipientFirstName() {
    return recipientFirstName;
  }

  /**
   *
   * @return recipient's middle name of the deposit
   */
  public String getRecipientMiddleName() {
    return recipientMiddleName;
  }

  /**
   *
   * @return recipient's last name of the deposit
   */
  public String getRecipientLastName() {
    return recipientLastName;
  }

  /**
   * checking the amount is in the valid range
   * @param amount is the amount of this deposit
   */
  private void checkAmount(int amount) {
    // check the amount is in the desired range
    if (amount < DEPOSIT_MIN_VALUE || amount > DEPOSIT_MAX_VALUE) {
      throw new IllegalArgumentException(
          "Invalid deposit amount, must between " + DEPOSIT_MIN_VALUE + " and "
              + DEPOSIT_MAX_VALUE);
    }
  }

  @Override
  public String toString() {
    return "Deposit [amount=" + amount + ", recipientID=" + recipientID;
  }
}
