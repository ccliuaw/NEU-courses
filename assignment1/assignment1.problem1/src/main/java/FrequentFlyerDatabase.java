import java.util.HashMap;
import java.util.Map;

/**
 * Represent a database storing all the FrequentFlyer info, with details: member list
 *
 * @author ccliu
 */
public class FrequentFlyerDatabase {
  private static FrequentFlyerDatabase instance;
  private  Map<String, FrequentFlyer> memberList = new HashMap<>();

  /**
   *
   * @return FrequentFlyerDatabase
   */
  public static FrequentFlyerDatabase getInstance() {
    if (FrequentFlyerDatabase.instance == null) {
      FrequentFlyerDatabase.instance = new FrequentFlyerDatabase();
    }

    return FrequentFlyerDatabase.instance;
  }

  /**
   *
   * @return member list, key is flyer's id, value is FrequentFlyer object
   */
  public Map<String, FrequentFlyer> getMemberList() {
    return this.memberList;
  }

  /**
   * adding members into database
   * @param member is the FrequentFlyer we want to add into the database
   */
  public void addMember(FrequentFlyer member) {
    this.memberList.put(member.getUserID(), member);
  }

}
