import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist {
  private int id;
  private String name;
  private String detail;

  public Stylist(String name, String detail) {
    this.name = name;
    this.detail = detail;
  }

  public String getStylistName() {
    return name;
  }

  public String getStylistDetail() {
    return detail;
  }

  public int getStylistId() {
    return id;
  }

  public static List<Stylist> all() {
    String sql = "SELECT id, detail FROM stylists";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .executeAndFetch(Stylist.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name, detail) VALUES (:name, :detail)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("detail", this.detail)
      .executeUpdate()
      .getKey();
    }
  }

  public static Stylist find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists where id=:id";
      return con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
    }
  }

  public List<Client> getStylistClients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE stylistid=:stylistid";
      return con.createQuery(sql)
        .addParameter("stylistid", this.id)
        .executeAndFetch(Client.class);
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM stylists WHERE id = :id;";
    con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  // @Override
  // public boolean equals(Object otherStylist) {
  //   if (!(otherStylist instanceof Stylist)) {
  //     return false;
  //   } else {
  //     Stylist newStylist = (Stylist) otherStylist;
  //     return this.getName().equals(newStylist.getName()) &&
  //            this.getDetail().equals(newStylist.getDetail()) &&
  //            this.getId() == newStylist.getId();
  //   }
  // }
}
