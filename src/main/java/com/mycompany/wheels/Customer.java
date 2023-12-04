
package com.mycompany.wheels;

public class Customer {
    private String name;
    private String postcode;
    private String telephone;

    public Customer(String name, String postcode, String telephone) {
        this.name = name;
        this.postcode = postcode;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getTelephone() {
        return telephone;
    }
}
