package scjp.com.java.designpatterns.creationaldesignpattern.monostateregistry;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

// A Flavor of Singleton
public class MonostateServiceRegistryTest {

  @Test
  public void addedServiceCanBeRetrieved() throws Exception {
    Service s = new Service();
    MonostateServiceRegistry r1 = new MonostateServiceRegistry();
    MonostateServiceRegistry r2 = new MonostateServiceRegistry();

    r1.register("ServiceName", s);
    assertEquals(s, r2.getService("ServiceName"));
  }
}

class MonostateServiceRegistry {
  private static Map<String, Service> services;
  private static volatile boolean isInitialized = false;

  public MonostateServiceRegistry() {
    if (!isInitialized) {
      synchronized (MonostateServiceRegistry.class) {
        if (!isInitialized) {
          services = new HashMap<>();
          isInitialized = true;
        }
      }
    }
  }

  public void register(String name, Service service) {
    services.put(name, service);
  }

  public Service getService(String name) {
    return services.get(name);
  }
}

class Service {
}