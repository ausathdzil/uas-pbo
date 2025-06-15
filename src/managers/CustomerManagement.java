package managers;

import entities.Customer;
import java.util.ArrayList;

public class CustomerManagement {
    ArrayList<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customer.setCustomerId(customerList.size() + 1);
        customerList.add(customer);
        System.out.println("Customer added successfully.");
    }

    public ArrayList<Customer> getCustomerList() {
    return customerList;
}


    public boolean updateCustomer(int customerId, String name, String email, String phoneNumber) {
        Customer customer = findCustomerById(customerId);
        if (customer != null) {
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhoneNumber(phoneNumber);
            System.out.println("Customer updated successfully.");
            return true;
        }
        System.out.println("Customer not found.");
        return false;    
    }
        
    public boolean deleteCustomer(int customerId) {
        Customer customer  = findCustomerById(customerId);
        if (customer != null) {
            customerList.remove(customer);
            System.out.println("Customer deleted successfully.");
            return true;
        } else {
            System.out.println("Customer not found.");
            return false;
        }
    }

    public Customer findCustomerById(int customerId) {
        for (Customer customer : customerList) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        System.out.println("Customer not found.");
        return null;
    }

    public void displayAllCustomers() {
        if (customerList.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customerList) {
                customer.displayDetails();
            }
        }
    }

    public int getCustomerCount() {
        return customerList.size();
    }

    public void displayCustomerCount() {
        System.out.println("Total number of customers: " + getCustomerCount());
    }
    
    public boolean isCustomerListEmpty() {
        return customerList.isEmpty();
    }
}
