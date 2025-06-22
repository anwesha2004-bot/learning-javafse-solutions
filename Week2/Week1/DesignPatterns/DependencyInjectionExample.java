package Week1.DesignPatterns;

interface CustomerRepository {
    String findCustomerById(String id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {

        return "Customer ID: " + id + ", Name: Anwesha Mitra";
    }
}

class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomerDetails(String id) {
        String customer = repository.findCustomerById(id);
        System.out.println(" Found: " + customer);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {

        CustomerRepository repo = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repo);

        service.getCustomerDetails("C102");
    }
}
