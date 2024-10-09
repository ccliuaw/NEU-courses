import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarDatabaseTest {
  private CarDatabase carDatabase;
  private Car c0;
  private NewCar c1;
  private UsedCar c5;
  @BeforeEach
  void setUp() {
     c0 = new Car("car0", 2020, new MakeModel("nissan","GTR"), 100000.0, 20);
     c1 = new NewCar("car1", 2024, new MakeModel("toyota","camary"), 40000.0, 10);
     c5 = new UsedCar("car5", 2022, new MakeModel("toyota","camary"), 36000.0, 100, 1, 0);
    carDatabase = c1.getCarDatabase();
  }

  @Test
  void getInstance() {
    assertNotNull(carDatabase);
    assertEquals(carDatabase, carDatabase.getInstance());
  }

  @Test
  void getCarList() {
    assertEquals(carDatabase.getCarList().size(), 3);
    Map<String, Car> map = c5.getCarDatabase().getCarList();
    String res = "CarDatabase :\n";
    for(String s : map.keySet()) {
      res += s + ", ";
    }
    assertEquals(res+"\n", c1.getCarDatabase().toString());
  }

  @Test
  void getNewCarNum() {
    assertEquals(carDatabase.getNewCarNum(), c1.getAvailableNewCarNumber());
  }

  @Test
  void testToString() {
    assertEquals(carDatabase.toString(), c0.getCarDatabase().toString());
  }
}