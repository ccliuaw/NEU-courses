/**
 * Represents	a group filer which is a tax filer, with more detail : filer status, numOfDependents,
 *  numOfChild, childcareExpense, dependentcareExpense
 * filer status is an object from enum class FilerStatus
 *
 * @author ccliu
 */
public class GroupFiler extends TaxFiler {
  private FilerStatus filerStatus;
  private int numOfDependents;
  private int numOfChild;
  private double childcareExpense;
  private double dependentcareExpense;
  private double tax;
  final private double RH_SAVING_RATE = 0.65;
  final private double RH_CEILING = 17500;
  final private double CHILD_CHECK_LEST_YEAR_EARN = 200000;
  final private double CHILDCARE_EXP_CHECK_AMOUNT = 5000;
  final private double CHILD_DEDUCTION_AMOUNT = 1250;
  final private double CHECK_TAX_AMOUNT = 90000;
  final private double LOW_TAX_RATE = 0.145;
  final private double HIGH_TAX_RATE = 0.185;

  /**
   * Create a new GroupFiler, given the [ id, contactInfo, lastYearEarning, totalIncomeTaxPaid,
   *           mortgageInterestPaid, propertyTaxPaid, studentLoanAndTuitionPaid, retirementSavingAccount,
   *           healthSavingAccount, charitableDonation, filerStatus, numOfDependents, numOfChild, childcareExpense]
   * Default value of dependentcareExpense is 0.
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
   * @param numOfDependents is the filer's number of dependents
   * @param numOfChild is the filer's number of child
   * @param childcareExpense is the filer's childcare expense
   */
  public GroupFiler(String id, ContactInfo contactInfo, double lastYearEarning, double totalIncomeTaxPaid,
      double mortgageInterestPaid, double propertyTaxPaid, double studentLoanAndTuitionPaid,
      double retirementSavingAccount, double healthSavingAccount, double charitableDonation, FilerStatus filerStatus,
      int numOfDependents, int numOfChild, double childcareExpense) {
    super(id, contactInfo, lastYearEarning, totalIncomeTaxPaid, mortgageInterestPaid, propertyTaxPaid,
        studentLoanAndTuitionPaid, retirementSavingAccount, healthSavingAccount, charitableDonation);
    this.filerStatus = filerStatus;
    this.numOfDependents = numOfDependents;
    this.numOfChild = numOfChild;
    this.childcareExpense = childcareExpense;
    this.dependentcareExpense = 0;
  }

  /**
   * Check if this group tax filer can use the retirement and health savings deduction.
   * Calculate the taxable income after applying the retirement and health savings deduction.
   *
   * @param input, basic taxable income
   * @return taxable income after applying retirement and health savings
   */
  private double applyRHDeduction(double input){
    double save = this.getRetirementSavingAccount() + this.getHealthSavingAccount();
    if(save > RH_CEILING){
      save = RH_CEILING;
    }
    input = input - (save * RH_SAVING_RATE);
    if(input < 0){
      input = 0;
    }
    return input;
  }

  /**
   * Check if this group tax filer can use the childcare deduction.
   * Calculate the taxable income after applying the childcare deduction.
   *
   * @param input, basic taxable income
   * @return taxable income after applying childcare deduction
   */
  private double applyChildcareDeduction(double input){
    if(super.getLastYearEarning() <= CHILD_CHECK_LEST_YEAR_EARN && this.childcareExpense >= CHILDCARE_EXP_CHECK_AMOUNT){
      input -= CHILD_DEDUCTION_AMOUNT;
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
    tax = super.calBasicTax();
    // retirement and health saving deduction
    this.tax = this.applyRHDeduction(this.tax);
    // mortgage interest and property deduction
    this.tax = super.applyMPDeduction(this.tax);
    // childcare deduction
    this.tax = this.applyChildcareDeduction(this.tax);
    // check final tax amount
    this.tax = this.checkTaxAmount(this.tax);

    return tax;
  }

}
