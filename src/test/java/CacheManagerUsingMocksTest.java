import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CacheManagerUsingMocksTest {

  @Mock
  private Cache cache;

  @Mock
  private EmployeeTable employeeTable;

  @InjectMocks
  private CacheManager cacheManager;

  @Test
  public void readFromCache() {
    String givenEmpId = "1";
    String expectedName = "Amol";

    //Cache cache = new MyCache();
    when(cache.get(givenEmpId)).thenReturn(expectedName);

    //EmployeeTable employeeTable = mock(EmployeeTable.class);

    //CacheManager cacheManager = new CacheManager(cache, employeeTable); //Mocks
    final String actualName = cacheManager.get(givenEmpId);

    //verification state - cache manager
    Assertions.assertEquals(expectedName, actualName);

    //verification verification - collaborators - cache
    verify(cache, times(1)).get(givenEmpId);
  }
}