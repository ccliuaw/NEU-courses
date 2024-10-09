import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsedCarTest {
  UsedCar c5;
  UsedCar c6;

  @BeforeEach
  void setUp() {
    c5 = new UsedCar("car5", 2022, new MakeModel("toyota","camary"), 36000.0, 100, 1, 0);
    c6 = new UsedCar("car6", 2016, new MakeModel("toyota","camary"), 10000.0, 10080, 2, 2);
  }

  @Test
  void getNumOfPreOwner() {
    assertEquals(1, c5.getNumOfPreOwner());
    assertEquals(2, c6.getNumOfPreOwner());
  }

  @Test
  void getNumOfMinorAccident() {
    assertEquals(0, c5.getNumOfMinorAccident());
    assertEquals(2, c6.getNumOfMinorAccident());
  }

  @Test
  void testToString() {
    String res = "This object is a used car. \n"
        + "Vehicle ID: car6\n"
        + "ManufactureYear: 2016\n"
        + "Make and Model: toyota, camary\n"
        + "MSRP: 10000.0\n"
        + "Mileage: 10080\n"
        + "Number of Pre Owner: 2\n"
        + "Number of Minor Accident: 2\n";
    assertEquals(res, c6.toString());
  }
}