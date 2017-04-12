import org.sql2o.*;
import org.junit.*;
import java.util.List;
import static org.junit.Assert.*;

public class ClientTest {

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

  // @Test
  // public void client_savesToDatabase() {
  //   Client testClient = new Client("Client", "Short Hair");
  //   testClient.save();
  //   assertTrue(testClient.save() instanceof List<?>);
  // }
}
