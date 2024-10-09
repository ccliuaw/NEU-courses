import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DepositTest {
  private Deposit deposit;
  @BeforeEach
  void setUp() {
    this.deposit = new Deposit(3000,"GG0123456789", "FN",
        "MN","LN");
  }

  @Test
  void getAmount() {
    assertEquals(3000,deposit.getAmount());
  }

  @Test
  void getRecipientID() {
    assertEquals("GG0123456789",deposit.getRecipientID());
  }

  @Test
  void getRecipientFirstName() {
    assertEquals("FN",deposit.getRecipientFirstName());
  }

  @Test
  void getRecipientMiddleName() {
    assertEquals("MN",deposit.getRecipientMiddleName());
  }

  @Test
  void getRecipientLastName() {
    assertEquals("LN",deposit.getRecipientLastName());
  }

  @Test
  void checkAmount() {
    assertEquals(3000,deposit.getAmount());
  }
}