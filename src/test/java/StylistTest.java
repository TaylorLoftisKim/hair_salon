import org.sql2o.*;
import org.junit.*;
import java.util.List;
import static org.junit.Assert.*;

public class StylistTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }
  //
  // @After
  // public void tearDown() {
  //   try (Connection con = DB.sql2o.open()) {
  //     String sql = "DELETE FROM name_of_your_table *;";
  //     con.createQuery(sql).executeUpdate();
  //   }
  // }
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

  // @Test
  // public void stylist_instantiatesWithDetails_String() {
  //   Stylist testStylist = new Stylist("Cathy", "Womens Hair Stylist");
  //   assertEquals("")
  // }

}
