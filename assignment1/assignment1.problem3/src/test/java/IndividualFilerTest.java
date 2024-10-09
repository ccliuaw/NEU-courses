import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IndividualFilerTest {
  IndividualFiler if1;
  IndividualFiler if2_RH_negative;
  IndividualFiler if3_text_amount;
  @BeforeEach
  void setUp() {
     if1 = new IndividualFiler("IF1", new ContactInfo(new Name("Jack","Paul"),"11234","206000123","@email"),
        300000, 1000,1500,3000,0,8000,5000,
        3000,FilerStatus.Employee);
     if2_RH_negative = new IndividualFiler("IF2", new ContactInfo(new Name("Jack","Paul"),"11234","206000123","@email"),
         10000, 1000,1500,3000,0,20000,5000,
         3000,FilerStatus.Employee);
     if3_text_amount = new IndividualFiler("IF3", new ContactInfo(new Name("Jack","Paul"),"11234","206000123","@email"),
         10000, 0,0,0,0,0,0,
         0,FilerStatus.Employee);
  }

  @Test
  void getFilerStatus() {
    assertEquals(FilerStatus.Employee, if1.getFilerStatus());
  }

  @Test
  void calculateTaxes() {
    assertEquals(55081, if1.calculateTaxes());
    assertEquals(0, if2_RH_negative.calculateTaxes());
    assertEquals(1500, if3_text_amount.calculateTaxes());
  }
}