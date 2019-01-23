
/**
 * Service Provider Framework
 * 
 *    There are essential components of a service provider framework:
 *        - Service interface - available methods in service
 *        - Service provider  - implementation of service interface
 *        - Provider registration API - system uses to register implementations.
 *        - Service Access API - allows client to specify some criteria.   <-----"static factory"
 *        - (Optional) Servie Provider Interface
 */ 

// Service
public interface Service {
	// Service-specific methods
}

// Provider
public interface Provider {
	Service newService();
}

// Noninstantiable class for service registration and access
public class Services {
	private Services() { }  // Prevents instantiation Item 4

	// Map service names to services
  private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();
  public static final String DEFAULT_PROVIDER_NAME = "<def>";

  // Provider registration API
  public static void registerDefaultProvider(Provider p) {
    registerProvider(DEFAULT_PROVIDER_NAME, p);
  }
  public static void registerProvider(String name, Provider p) {
    providers.put(name, p);
  }

  // Service access API
  public static Service newInstance() {
    return newInstance(DEFAULT_PROVIDER_NAME);
  }

  public static Service newInstance(String name) {
    Provider p = providers.get(name);
    if (p == null)
      throw new IllegalArgumentException(
        "No provider registered with name: " + name);
    return p.newService();
  }
}