package model;


public class User {
    private String name;
    private String email;
    private String city;
    private String country;
    public User() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry( ){return country;}
    public void setCountry(String country) { this.country = country; }

    @Override
    public String toString() {
        return String.format(
                "User Detail [Name: %s | Email: %s | Location: %s, %s]",
                name, email, city, country
        );
    }

}