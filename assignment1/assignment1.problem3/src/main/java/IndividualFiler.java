/**
 * Represents	an individual filer who is a tax filer, with more detail : filer status
 * filer status is an object from enum class FilerStatus
 *
 * @author ccliu
 */
public class IndividualFiler extends TaxFiler {
  private FilerStatus filerStatus;
  private double tax;
  final private double RH_SAVING_RATE = 0.7;
  final private double CHECK_TAX_AMOUNT = 55000;
  final private double LOW_TAX_RATE = 0.15;
  final private double HIGH_TAX_RATE = 0.19;

  /**
   * Create a new IndividualFiler, given the [ id, contactInfo, lastYearEarning, totalIncomeTaxPaid,
   *           mortgageInterestPaid, propertyTaxPaid, studentLoanAndTuitionPaid, retirementSavingAccount,
   *           healthSavingAccount, charitableDonation, filerStatus ]
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
   * @param filerStatus of the filer's status
   */
  public IndividualFiler(String id, ContactInfo contactInfo, double lastYearEarning, double totalIncomeTaxPaid,
      double mortgageInterestPaid, double propertyTaxPaid, double studentLoanAndTuitionPaid,
      double retirementSavingAccount, double healthSavingAccount, double charitableDonation, FilerStatus filerStatus) {
    super(id, contactInfo, lastYearEarning, totalIncomeTaxPaid, mortgageInterestPaid, propertyTaxPaid,
        studentLoanAndTuitionPaid, retirementSavingAccount, healthSavingAccount, charitableDonation);
    this.filerStatus = filerStatus;
  }

  /**
   *
   * @return filer status
   */
  public FilerStatus getFilerStatus() {
    return filerStatus;
  }

  /**
   * Check if this individual tax filer can use the retirement and health savings deduction.
   * Calculate the taxable income after applying the retirement and health savings deduction.
   *
   * @param input, basic taxable income
   * @return taxable income after applying retirement and health savings
   */
  private double applyRHDeduction(double input){
    double save = this.getRetirementSavingAccount() + this.getHealthSavingAccount();
    input = input - (save * RH_SAVING_RATE);
    if(input < 0){
      input = 0;
    }
    return input;
  }

  /**
   * Calculate the final tax amount
   *
   * @param input, resulting taxable income
   * @return tax amount
   */
  private double checkTaxAmount(double input){
    if(input <= CHECK_TAX_AMOUNT){
      input *= LOW_TAX_RATE;
    }
    else{
      input *= HIGH_TAX_RATE;
    }
    return input;
  }

  /**
   * Calculate this individual tax filer's final tax amount.
   *
   * @return final tax amount
   */
  @Override
  public double calculateTaxes(){
    // basic taxable income
    this.tax = super.calBasicTax();
    // retirement and health saving deduction
    this.tax = this.applyRHDeduction(this.tax);
    // mortgage interest and property deduction
    this.tax = super.applyMPDeduction(this.tax);
    //
    this.tax = this.checkTaxAmount(this.tax);
    return tax;
  }

}
