import org.sql2o.*;
import org.junit.*;
import java.util.List;
import static org.junit.Assert.*;

public class ClientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @After
  public void tearDown() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients *;";
      con.createQuery(sql).executeUpdate();
    }
  }

  @Rule
  public DatabaseRule database = new DatabaseRule();

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

  @Test
  public void client_FindAllClients(){
    Client testClient = new Client("Client", "Short Hair");
    testClient.save();
    assertEquals(true, testClient.find(testClient.getClientId()) instanceof Client );
  }

  @Test
  public void client_DeleteAllClients() {
    Client testClient = new Client("Client", "Short Hair");
    testClient.save();
    int clientId = testClient.getClientId();
    testClient.delete();
    assertEquals(null, testClient.find(clientId));
  }
}
