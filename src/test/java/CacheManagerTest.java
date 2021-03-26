import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CacheManagerTest {

  //SUT - CacheManager
  // Collaborators - cache, employeeTable

  @Test
  public void shouldReadFromCacheInsteadOfDB() {
    String givenEmpId = "1";
    String expectedName = "Amol";

    //setup
    Cache cache = new MyCache();
    cache.put("1", "Amol");

    //exercise

    CacheManager cacheManager = new CacheManager(cache, null); // Dummy
    String actualName = cacheManager.get(givenEmpId);

    //verification - State
    Assertions.assertEquals(expectedName, actualName);
  }

  @Test
  public void shouldReadFromDBInsteadOfCache() {
    String givenEmpId = "2";
    String expectedName = "Rishabh";

    //setup
    Cache cache = new MyCache();
    cache.put("1", "Amol");

    //exercise
    CacheManager cacheManager = new CacheManager(cache, new StubTable()); // Stub
    String actualName = cacheManager.get(givenEmpId);

    //verification - State
    Assertions.assertEquals(expectedName, actualName);
  }

}

class StubTable implements EmployeeTable {

  @Override
  public String get(String id) {
    return "Rishabh";
  }

  @Override
  public void save(String employeeId, String employeeName) {

  }
}