import org.sql2o.*;
import org.junit.*;
import java.util.List;
import static org.junit.Assert.*;

public class StylistTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon", null, null);
  }
 //
 // @After
 // public void tearDown() {
 //   try (Connection con = DB.sql2o.open()) {
 //     String sql = "DELETE FROM name_of_your_table *;";
 //     con.createQuery(sql).executeUpdate();
 //   }
 // }
}
