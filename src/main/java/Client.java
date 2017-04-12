import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Client {
  private int id;
  private int stylistId;
  private String name;
  private String detail;

  public Client(String name, String detail) {
    this.name = name;
    this.detail = detail;
    this.stylistId = stylistId;
  }

  public int getStylistId() {
    return stylistId;
  }

  public String getClientName() {
    return name;
  }

  public String getClientDetail() {
    return detail;
  }

  public int getClientId() {
    return id;
  }

  public static List<Client> all() {
    String sql = "SELECT id, detail FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql)
      .executeAndFetch(Client.class);
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM clients where id=:id";
    return con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Client.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, detail) VALUES (:name, :detail)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("detail", this.detail)
      .executeUpdate()
      .getKey();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM clients WHERE id = :id;";
    con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }
}
