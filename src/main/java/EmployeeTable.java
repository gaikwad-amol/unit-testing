public interface EmployeeTable {

  String get(String id);

  void save(String employeeId, String employeeName);
}
