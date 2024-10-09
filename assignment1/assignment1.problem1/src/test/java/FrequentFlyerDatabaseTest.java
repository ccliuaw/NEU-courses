import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FrequentFlyerDatabaseTest {
  private FrequentFlyerDatabase database;
  @Test
  void getInstance() {
    FrequentFlyerDatabase temp = FrequentFlyerDatabase.getInstance();
    assertNotNull(temp);
  }

  @Test
  void getMemberList() {
    FrequentFlyer a1 = new FrequentFlyer("DD0123456789", "a1", "m", "L", "A1");
    FrequentFlyer a2 = new FrequentFlyer("EE0123456789", "a2", "m", "L", "A2");

    FrequentFlyerDatabase temp = FrequentFlyerDatabase.getInstance();
    assertEquals(2, temp.getMemberList().size());
  }

  @Test
  void addMember() {
    FrequentFlyer a3 = new FrequentFlyer("CC0123456789", "a1", "m", "L", "A1");

    FrequentFlyerDatabase temp = FrequentFlyerDatabase.getInstance();
    temp.addMember(a3);
    assertEquals(3, temp.getMemberList().size());
  }
}