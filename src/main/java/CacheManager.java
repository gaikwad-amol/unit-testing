public class CacheManager {

  private final Cache cache;
  private final EmployeeTable employeeTable;

  public CacheManager(Cache cache, EmployeeTable employeeTable) {

    this.cache = cache;
    this.employeeTable = employeeTable;
  }

  public String get(String givenEmpId) {
    String value = cache.get(givenEmpId);
    if (value == null) {
      value = employeeTable.get(givenEmpId);
      cache.put(givenEmpId, value);
    }
    return value;
  }
}
