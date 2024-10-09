import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MakeModelTest {
  private MakeModel makeModel;
  private MakeModel makeModel_null;
  @BeforeEach
  void setUp() {
    makeModel = new MakeModel("ford", "mustang");
    makeModel_null = new MakeModel();
  }

  @Test
  void getMake() {
    assertEquals("ford", makeModel.getMake());
    assertEquals("", makeModel_null.getMake());
  }

  @Test
  void getModel() {
    assertEquals("mustang", makeModel.getModel());
    assertEquals("", makeModel_null.getModel());
  }
}