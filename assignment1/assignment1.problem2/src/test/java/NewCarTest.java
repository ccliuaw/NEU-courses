import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NewCarTest {
  private NewCar newCar;
  private NewCar newCar_fake;
  @BeforeEach
  void setUp() {
    newCar = new NewCar("car1", 2024, new MakeModel("toyota","camary"), 40000.0, 10);
    newCar_fake = new NewCar("car2_fake", 2023, new MakeModel("honda","city"), 38000, 160);
  }

  @Test
  void isWithinMiles() {
    assertEquals(true, newCar.isWithinMiles());
    assertEquals(false, newCar_fake.isWithinMiles());
  }

  @Test
  void testToString() {
    String actual = "This object is a new car.\n"+
        "Vehicle ID: car1\n"+
        "ManufactureYear: 2024\n"+
        "Make and Model: toyota, camary\n"+
        "MSRP: 40000.0\n"+"Mileage: 10\n";
    assertEquals(actual, newCar.toString());
  }

}