import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Client {
  private int id;
  private String name;
  private String details;

  public Client(String name, String details) {
    this.name = name;
    this.details = details;
  }

  public String getName() {
    return name;
  }

  public String getDetails() {
    return details;
  }

  public int getClientId() {
    return id;
  }
}
