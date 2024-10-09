/**
 * Represent a Vessel extends from Vehicle, with more details: vessel type
 *
 * @author ccliu
 */
public class Vessel extends Vehicle {
  private VesselType vesselType;

  /**
   * Create a new Vessel given [ id, year of manufacture, make and model, MSRP, vessel type ]
   * @param id is the unique id of the vessel
   * @param manufactureYear is the vessel's year of manufacture
   * @param makeAndModel is the vessel's make and model
   * @param MSRP is the vessel's manufacturer suggested retail price
   * @param vesselType is the vessel's type
   */
  public Vessel(String id, int manufactureYear, MakeModel makeAndModel, double MSRP, VesselType vesselType) {
    super(id, manufactureYear, makeAndModel, MSRP);
    this.vesselType = vesselType;
  }

  /**
   *
   * @return the vessel's type
   */
  public VesselType getVesselType() {
    return vesselType;
  }

  /**
   * Override the toString()
   * @return the info of the vessel
   */
  @Override
  public String toString() {
    String res = super.toString();
    res += "Vessel Type: " + this.vesselType + "\n";
    return res;
  }
}
