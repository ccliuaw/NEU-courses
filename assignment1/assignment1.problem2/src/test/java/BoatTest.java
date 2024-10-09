import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoatTest {
  private Boat b1;
  @BeforeEach
  void setUp() {
    b1 = new Boat("boat1", 2023, new MakeModel("YACHT","YACHT11"), 50000.0, VesselType.boat, 49, 4, PropulsionType.jetPropulsion);
  }

  @Test
  void getLength() {
    assertEquals(49, b1.getLength());
  }

  @Test
  void getNumOfPassenger() {
    assertEquals(4, b1.getNumOfPassenger());
  }

  @Test
  void getPropulsionType() {
    assertEquals(PropulsionType.jetPropulsion, b1.getPropulsionType());
  }

  @Test
  void testToString() {
    String res = "Vehicle ID: boat1\n"
        + "ManufactureYear: 2023\n"
        + "Make and Model: YACHT, YACHT11\n"
        + "MSRP: 50000.0\n"
        + "Vessel Type: boat\n"
        + "Length: 49.0\n"
        + "Num of Passenger: 4\n"
        + "Propulsion Type: jetPropulsion\n";
    assertEquals(res, b1.toString());
  }
}