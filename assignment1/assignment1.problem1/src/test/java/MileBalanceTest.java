import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MileBalanceTest {
  private MileBalance mileBalance;
  private MileBalance mileBalance2;

  @BeforeEach
  void setUp() {
    mileBalance = new MileBalance();
    mileBalance2 = new MileBalance(10000, 500, 500);
  }

  @Test
  void getTotalMile() {
    assertEquals(0, this.mileBalance.getTotalMile());
  }

  @Test
  void getMileThisYear() {
    assertEquals(0, this.mileBalance.getMileThisYear());
  }

  @Test
  void getExpThisYear() {
    assertEquals(0, this.mileBalance.getExpThisYear());
  }

  @Test
  void setTotalMile() {
    this.mileBalance.setTotalMile(340);
    assertEquals(340, this.mileBalance.getTotalMile());
  }

  @Test
  void addMile() {
    this.mileBalance.addMile(2000);
    assertEquals(2000, this.mileBalance.getMileThisYear());
  }

  @Test
  void subtractMile() {
    this.mileBalance.addMile(2000);
    this.mileBalance.subtractMile(2000);
    assertEquals(2000, this.mileBalance.getMileThisYear());
  }

}