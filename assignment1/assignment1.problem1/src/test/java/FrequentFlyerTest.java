import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FrequentFlyerTest {

  private FrequentFlyer a1;
  private FrequentFlyer a2;
  private Deposit d1;

  @BeforeEach
  void setUp() {
    a1 = new FrequentFlyer("AA1111111111", "a1", "m", "L", "A1");
    a2 = new FrequentFlyer("AA2222222222", "a2", "mm", "LN", "A2");
    a1.setTotalMiles(30000);
    a2.setTotalMiles(400);
    d1 = a1.createDeposit(4000, a2.getUserID(), a2.getFirstName(), a2.getMiddleName(),
        a2.getLastName());
    a1.transferMiles(d1);
  }

  @Test
  void flyer() {
    assertEquals(a1.getUserID(), "AA1111111111");
    assertEquals(a2.getFirstName(), "a2");
    assertEquals(a2.getMiddleName(), "mm");
    assertEquals(a1.getLastName(), "L");
    assertEquals(a1.getEmail(), "A1");
    assertEquals(a1.getMileBalance().getTotalMile(), 26000);
    assertEquals(a1.getTotalMember(), a2.getTotalMember());
    assertEquals(a2.getMileBalance().getTotalMile(), 4400);
    assertEquals(d1.toString(),
        "Deposit [amount=" + d1.getAmount() + ", recipientID=" + d1.getRecipientID());
    assertEquals(a2.getMileBalance().getMileThisYear(), 4000);
    assertEquals(a1.getMileBalance().getTotalMile(), 26000);
    assertEquals(a2.toString(), "FrequentFlyer [UserId= " + a2.getUserID() + ", FullName= " + a2.getFirstName() + ", " +
        a2.getMiddleName() + ", " + a2.getLastName() + ", Email= " + a2.getEmail() + "]");
    // check ID is 12 length
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {new FrequentFlyer("AA11", "a1", "m", "L", "A1");});
    assertEquals(exception.getMessage(), "UserID must have length of: 12");
    // check id existed
    IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {new FrequentFlyer("AA1111111111", "a1", "m", "L", "A1");});
    assertEquals(exception2.getMessage(), "UserID: AA1111111111 already exists");
    // check deposit ID not found
    IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () -> {
      a1.transferMiles(a1.createDeposit(3000,"AA3333333333", "a1", "m", "L"));
    });
    assertEquals(exception3.getMessage(), "Recipient ID not found");
    // check deposit ID is itself
    IllegalArgumentException exception4 = assertThrows(IllegalArgumentException.class, () -> {
      a1.transferMiles(a1.createDeposit(3000,"AA1111111111", "a1", "m", "L"));
    });
    assertEquals(exception4.getMessage(), "This is your own account");
    // check deposit name is not corresponded
    IllegalArgumentException exception5 = assertThrows(IllegalArgumentException.class, () -> {
      a1.transferMiles(a1.createDeposit(3000,"AA2222222222", "a1", "m", "L"));
    });
    assertEquals(exception5.getMessage(), "Invalid recipient first or middle or last name");
    // check deposit name is not corresponded
    IllegalArgumentException exception5_1 = assertThrows(IllegalArgumentException.class, () -> {
      a1.transferMiles(a1.createDeposit(3000,"AA2222222222", "a2", "m", "L"));
    });
    assertEquals(exception5_1.getMessage(), "Invalid recipient first or middle or last name");
    // check insufficient total mile
    a1.setTotalMiles(2000);
    IllegalArgumentException exception6 = assertThrows(IllegalArgumentException.class, () -> {
      a1.transferMiles(a1.createDeposit(3000,"AA2222222222", "a2", "mm", "LN"));
    });
    assertEquals(exception6.getMessage(), "Mile insufficient, your total mile is: " + a1.getMileBalance().getTotalMile());
    // check deposit > range
    a1.setTotalMiles(200000);
    IllegalArgumentException exception7 = assertThrows(IllegalArgumentException.class, () -> {
      a1.transferMiles(a1.createDeposit(30000,"AA2222222222", "a2", "mm", "LN"));
    });
    assertEquals(exception7.getMessage(), "Invalid deposit amount, must between " + 1000 + " and "
        + 10000);
    // check deposit < range
    a1.setTotalMiles(200000);
    IllegalArgumentException exception8 = assertThrows(IllegalArgumentException.class, () -> {
      a1.transferMiles(a1.createDeposit(30,"AA2222222222", "a2", "mm", "LN"));
    });
    assertEquals(exception8.getMessage(), "Invalid deposit amount, must between " + 1000 + " and "
        + 10000);
  }
}
