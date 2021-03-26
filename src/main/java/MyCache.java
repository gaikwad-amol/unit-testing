import java.util.HashMap;
import java.util.Map;

public class MyCache implements Cache {

  private final Map<String, String> map = new HashMap<>();

  @Override
  public String get(String key) {
    return map.get(key);
  }

  @Override
  public void put(String key, String value) {
    map.put(key, value);
  }
}
