import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private int id;
  private String name;
  private String details;

  public Stylist(String name, String details) {
    this.name = name;
    this.details = details;
  }

  public String getStylistName() {
    return name;
  }

  public String getStylistDetails() {
    return details;
  }

  public int getStylistId() {
    return id;
  }

  public static List<Stylist> all() {
    String sql = "SELECT id, description FROM stylists";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .executeAndFetch(Stylist.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name, details) VALUES (:name, :details)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("specialty", this.details)
      .executeUpdate()
      .getKey();
    }
  }
}
