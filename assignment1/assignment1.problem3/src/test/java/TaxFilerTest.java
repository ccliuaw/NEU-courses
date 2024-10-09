import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaxFilerTest {
  TaxFiler taxFiler;
  @BeforeEach
  void setUp() {
    taxFiler = new TaxFiler("tf1", new ContactInfo(new Name("Jack","Paul"),"11234","206000123","@email"),
        300000, 1000);
  }

  @Test
  void getId() {
    assertEquals("tf1", taxFiler.getId());
  }

  @Test
  void getContactInfo() {
    assertEquals("Jack Paul", taxFiler.getContactInfo().getName().getFullName());
    assertEquals("11234", taxFiler.getContactInfo().getAddress());
    assertEquals("206000123", taxFiler.getContactInfo().getPhone());
    assertEquals("@email", taxFiler.getContactInfo().getEmail());
  }

  @Test
  void getLastYearEarning() {
    assertEquals(300000, taxFiler.getLastYearEarning());
  }

  @Test
  void getTotalIncomeTaxPaid() {
    assertEquals(1000, taxFiler.getTotalIncomeTaxPaid());
  }

  @Test
  void getMortgageInterestPaid() {
    assertEquals(0, taxFiler.getMortgageInterestPaid());
  }

  @Test
  void getPropertyTaxPaid() {
    assertEquals(0, taxFiler.getPropertyTaxPaid());
  }

  @Test
  void getStudentLoanAndTuitionPaid() {
    assertEquals(0, taxFiler.getStudentLoanAndTuitionPaid());
  }

  @Test
  void getRetirementSavingAccount() {
    assertEquals(0, taxFiler.getRetirementSavingAccount());
  }

  @Test
  void getHealthSavingAccount() {
    assertEquals(0, taxFiler.getHealthSavingAccount());
  }

  @Test
  void getCharitableDonation() {
    assertEquals(0, taxFiler.getCharitableDonation());
  }

  @Test
  void calBasicTax() {
    assertEquals(299000, taxFiler.calBasicTax());
  }

  @Test
  void calculateTaxes() {
    assertEquals(299000, taxFiler.calculateTaxes());
  }
}