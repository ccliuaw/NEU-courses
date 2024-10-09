import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VesselTest {
  Vessel vessel;
  @BeforeEach
  void setUp() {
    vessel = new Vessel("b2", 2015, new MakeModel("YACHT","YACHT11"), 500000, VesselType.boat);
  }

  @Test
  void getVesselType() {
    assertEquals(vessel.getVesselType(), VesselType.boat);
  }

  @Test
  void testToString() {
    String res = "Vehicle ID: b2\n"
        + "ManufactureYear: 2015\n"
        + "Make and Model: YACHT, YACHT11\n"
        + "MSRP: 500000.0\n"
        + "Vessel Type: boat\n";
    assertEquals(vessel.toString(), res);
  }
}