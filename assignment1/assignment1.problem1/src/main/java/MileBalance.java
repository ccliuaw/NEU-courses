/**
 * Represent the mile balance of a FrequentFlyer, one FrequentFlyer only have one mile balance
 * with details: total miles, miles earned this year and miles expired this year
 *
 * @author ccliu
 */
public class MileBalance {

  private int totalMile;
  private int mileThisYear;
  private int expThisYear;

  /**
   * Create a default MileBalance,
   * 0 is the default value for total miles, miles earned this year and miles expired this year
   */
  public MileBalance() {
    this.totalMile = 0;
    this.mileThisYear = 0;
    this.expThisYear = 0;
  }

  /**
   * Create a new MileBalance, given:
   * @param totalMile is the value of total miles
   * @param mileThisYear is the value of miles earned this year
   * @param expThisYear is the value of miles expired this year
   */
  public MileBalance(int totalMile, int mileThisYear, int expThisYear) {
    this.totalMile = totalMile;
    this.mileThisYear = mileThisYear;
    this.expThisYear = expThisYear;
  }

  /**
   *
   * @return total miles
   */
  public int getTotalMile() {
    return totalMile;
  }

  /**
   *
   * @return the value of miles earned this year
   */
  public int getMileThisYear() {
    return mileThisYear;
  }

  /**
   *
   * @return the value of miles expired this year
   */
  public int getExpThisYear() {
    return expThisYear;
  }

  /**
   * setting the total mile for the user
   * @param totalMile is the desired value we want to set
   */
  public void setTotalMile(int totalMile) {
    this.totalMile = totalMile;
  }

  /**
   * adding miles for the user
   * @param mile is the value we want to add
   */
  public void addMile(int mile) {
    this.totalMile += mile;
    this.mileThisYear += mile;
    this.expThisYear += mile;
  }

  /**
   * minus the value for the user
   * @param mile is the value we want to minus
   */
  public void subtractMile(int mile) {
    if (mile > this.totalMile) {
      throw new IllegalArgumentException(
          "Mile insufficient, your total mile is: " + this.totalMile);
    }
    this.totalMile -= mile;
    this.expThisYear -= mile;
    if (this.expThisYear < 0) {
      this.expThisYear = 0;
    }
  }

  /**
   * override the toString() method
   * @return the mile balance info
   */
  @Override
  public String toString() {
    return "Total miles= " + this.totalMile + ", Miles earned this year: " + this.mileThisYear + ", Miles expiring this year: " + this.expThisYear;
  }
}
