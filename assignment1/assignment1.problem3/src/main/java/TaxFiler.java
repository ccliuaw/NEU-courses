/**
 *  Represents a tax filer with their details
 *  including: id, contactInfo, lastYearEarning, totalIncomeTaxPaid, mortgageInterestPaid,
 *             propertyTaxPaid, studentLoanAndTuitionPaid, retirementSavingAccount,
 *             healthSavingAccount, charitableDonation
 *
 * @author ccliu
 *
 */
public class TaxFiler {
  private String id;
  private ContactInfo contactInfo;
  private double lastYearEarning;
  private double totalIncomeTaxPaid;
  private double mortgageInterestPaid;
  private double propertyTaxPaid;
  private double studentLoanAndTuitionPaid;
  private double retirementSavingAccount;
  private double healthSavingAccount;
  private double charitableDonation;
  private double tax;
  final private double MP_DEDUCTION_AMOUNT = 2500;
  final private double MP_INTEREST_AMOUNT = 12500;
  final private double MP_CHECK_LEST_YEAR_EARN = 250000;

  /**
   * Create a TaxFiler object, given the id, contactInfo, lastYearEarning, totalIncomeTaxPaid
   * other attributes default as 0.
   *
   * @param id of the filer's id
   * @param contactInfo of the filer's contactInfo
   * @param lastYearEarning of the filer's last year's earning
   * @param totalIncomeTaxPaid of the filer's total income tax already paid
   */
  public TaxFiler(String id, ContactInfo contactInfo, double lastYearEarning, double totalIncomeTaxPaid) {
    this.id = id;
    this.contactInfo = contactInfo;
    this.lastYearEarning = lastYearEarning;
    this.totalIncomeTaxPaid = totalIncomeTaxPaid;
    this.mortgageInterestPaid = 0;
    this.propertyTaxPaid = 0;
    this.studentLoanAndTuitionPaid = 0;
    this.retirementSavingAccount = 0;
    this.healthSavingAccount = 0;
    this.charitableDonation = 0;
  }

  /**
   * Create a TaxFiler object, given the [ id, contactInfo, lastYearEarning, totalIncomeTaxPaid,
   *          mortgageInterestPaid, propertyTaxPaid, studentLoanAndTuitionPaid, retirementSavingAccount,
   *          healthSavingAccount, charitableDonation ]
   *
   * @param id of the filer's id
   * @param contactInfo of the filer's contactInfo
   * @param lastYearEarning of the filer's last year's earning
   * @param totalIncomeTaxPaid of the filer's total income tax already paid
   * @param mortgageInterestPaid of the filer's mortgage interest paid
   * @param propertyTaxPaid of the filer's property taxes paid
   * @param studentLoanAndTuitionPaid of the filer's student loan and tuition paid
   * @param retirementSavingAccount of the filer's contributions made to a retirement savings account
   * @param healthSavingAccount of the filer's contributions made to a health savings account,
   * @param charitableDonation of the filer's charitable donations and contributions
   */
  public TaxFiler(String id, ContactInfo contactInfo, double lastYearEarning, double totalIncomeTaxPaid,
      double mortgageInterestPaid, double propertyTaxPaid, double studentLoanAndTuitionPaid,
      double retirementSavingAccount, double healthSavingAccount, double charitableDonation) {
    this.id = id;
    this.contactInfo = contactInfo;
    this.lastYearEarning = lastYearEarning;
    this.totalIncomeTaxPaid = totalIncomeTaxPaid;
    this.mortgageInterestPaid = mortgageInterestPaid;
    this.propertyTaxPaid = propertyTaxPaid;
    this.studentLoanAndTuitionPaid = studentLoanAndTuitionPaid;
    this.retirementSavingAccount = retirementSavingAccount;
    this.healthSavingAccount = healthSavingAccount;
    this.charitableDonation = charitableDonation;
  }

  /**
   *
   * @return id, type String
   */
  public String getId() {
    return id;
  }

  /**
   *
   * @return contactInfo, type ContactInfo
   */
  public ContactInfo getContactInfo() {
    return contactInfo;
  }

  /**
   *
   * @return last year's earning, type double
   */
  public double getLastYearEarning() {
    return lastYearEarning;
  }

  /**
   *
   * @return total income tax already paid, type double
   */
  public double getTotalIncomeTaxPaid() {
    return totalIncomeTaxPaid;
  }

  /**
   *
   * @return mortgage interest paid, type double
   */
  public double getMortgageInterestPaid() {
    return mortgageInterestPaid;
  }

  /**
   *
   * @return property taxes paid, type double
   */
  public double getPropertyTaxPaid() {
    return propertyTaxPaid;
  }

  /**
   *
   * @return student loan and tuition paid, type double
   */
  public double getStudentLoanAndTuitionPaid() {
    return studentLoanAndTuitionPaid;
  }

  /**
   *
   * @return Contributions made to a retirement savings account, type double
   */
  public double getRetirementSavingAccount() {
    return retirementSavingAccount;
  }

  /**
   *
   * @return Contributions made to a health savings account, type double
   */
  public double getHealthSavingAccount() {
    return healthSavingAccount;
  }

  /**
   *
   * @return Charitable donations and contributions, type double
   */
  public double getCharitableDonation() {
    return charitableDonation;
  }


  /**
   * calculate the basic taxable income
   * @return basic taxable income
   */
  public double calBasicTax(){
    this.tax = lastYearEarning - totalIncomeTaxPaid;
    return this.tax;
  }

  // mortgage interest and property deduction

  /**
   * check if the tax filer can use the mortgage interest and property deduction
   * calculate the taxable income after applying mortgage interest and property deduction
   *
   * @param input, basic taxable income
   * @return taxable income after applying mortgage interest and property deduction
   */
  public double applyMPDeduction(double input){
    double morNpro = this.mortgageInterestPaid + this.propertyTaxPaid;
    if (this.lastYearEarning <= MP_CHECK_LEST_YEAR_EARN && morNpro >= MP_INTEREST_AMOUNT){
      input -= MP_DEDUCTION_AMOUNT;
    }
    return input;
  }

  /**
   * calculate taxable income for this tax filer
   * @return taxable income, type double
   */
  public double calculateTaxes(){
    this.tax = calBasicTax();
    this.tax = this.applyMPDeduction(this.tax);
    return tax;
  }

}
