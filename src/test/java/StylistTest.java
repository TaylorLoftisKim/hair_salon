import org.sql2o.*;
import org.junit.*;
import java.util.List;
import static org.junit.Assert.*;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void stylist_instantiatesCorrectly() {
    Stylist testStylist = new Stylist("", "");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void stylist_instantiatesWithName_String() {
    Stylist testStylist = new Stylist("Cathy", "");
    assertEquals("Cathy", testStylist.getStylistName());
  }

  @Test
  public void stylist_instantiatesWithDetails_String() {
    Stylist testStylist = new Stylist("Cathy", "Womens Hair Stylist");
    assertEquals("Womens Hair Stylist", testStylist.getStylistDetail());
  }

  @Test
  public void stylist_savesToDatabase_true() {
    Stylist testStylist = new Stylist("Cathy", "Womens Hair Stylist");
    testStylist.save();
    assertTrue(Stylist.all() instanceof List<?>);
  }

  @Test
  public void stylist_findsStylistById() {
    Stylist testStylist = new Stylist("Cathy", "Womens Hair Stylist");
    testStylist.save();
    assertEquals(true, testStylist.find(testStylist.getStylistId()) instanceof Stylist);
  }

  @Test
  public void stylist_DeleteAllStylists() {
    Stylist testStylist = new Stylist("Cathy", "Womens Hair Stylist");
    testStylist.save();
    int stylistId = testStylist.getStylistId();
    testStylist.delete();
    assertEquals(null, Stylist.find(stylistId));
  }

}
