import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroupFilerTest {
  GroupFiler gf1;
  GroupFiler gf2_RH_high;
  GroupFiler gf3_MP_yes;
  GroupFiler gf4_RH_negative;

  @BeforeEach
  void setUp() {
    gf1 = new GroupFiler("GF1", new ContactInfo(new Name("Jack","Paul"),"11234","206000123","@email"),
        20000, 1000,1500,3000,0,8000,5000,
        3000,FilerStatus.MarriedJointly, 2, 2, 5000);
    gf2_RH_high = new GroupFiler("GF2", new ContactInfo(new Name("Jack","Paul"),"11234","206000123","@email"),
        800000, 1000,1500,3000,0,25000,5000,
        3000,FilerStatus.MarriedJointly, 2, 2, 5000);
    gf3_MP_yes = new GroupFiler("GF3", new ContactInfo(new Name("Jack","Paul"),"11234","206000123","@email"),
        200000, 1000,12500,3000,0,8000,5000,
        3000,FilerStatus.MarriedJointly, 2, 2, 5000);
    gf4_RH_negative = new GroupFiler("GF4", new ContactInfo(new Name("Jack","Paul"),"11234","206000123","@email"),
        10000, 1000,1500,3000,0,25000,5000,
        3000,FilerStatus.MarriedJointly, 2, 2, 5000);
  }

  @Test
  void calculateTaxes() {
    assertEquals(gf1.calculateTaxes(), 1348.5);
    assertEquals(gf2_RH_high.calculateTaxes(), 145710.625);
    assertEquals(gf3_MP_yes.calculateTaxes(), 34558.0);
    assertEquals(gf4_RH_negative.calculateTaxes(), -181.25);
  }
}