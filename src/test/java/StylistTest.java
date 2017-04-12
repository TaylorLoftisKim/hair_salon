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
  public void save_savesToDatabase_true() {
    Stylist testStylist = new Stylist("Cathy", "Womens Hair Stylist");
    testStylist.save();
    assertTrue(Stylist.all() instanceof List<?>);
  }



}
