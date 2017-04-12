import org.sql2o.*;
import org.junit.*;
import java.util.List;
import static org.junit.Assert.*;

public class ClientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  // @After
  // public void tearDown() {
  //   try (Connection con = DB.sql2o.open()) {
  //   String sql = "DELETE FROM hair_salon_test *;";
  //   con.createQuery(sql).executeUpdate();
  // }
  // }

  @Test
  public void client_instantiates_correctly(){
    Client testClient = new Client(" ", " ");
    assertTrue(testClient instanceof Client);
  }

  @Test
  public void client_instantiatesWithName_String() {
    Client testClient = new Client("Client", "");
    assertEquals("Client", testClient.getClientName());
  }

  @Test
  public void client_instantiatesWithDetails_String() {
    Client testClient = new Client("Client", "Short Hair");
    assertEquals("Short Hair", testClient.getClientDetail());
  }

  // @Test
  // public void client_savesToDatabase() {
  //   Client testClient = new Client("Client", "Short Hair");
  //   testClient.save();
  //   assertTrue(testClient.save() instanceof List<?>);
  // }
}
