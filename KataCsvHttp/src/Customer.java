import java.util.Objects;

public class Customer {
    public String ref; 
    public String name; 
    public String addrLine1; 
    public String addrLine2; 
    public String town; 
    public String county;
    public String country; 
    public String postCode; 
 
    public Customer() {
    }

    public Customer(String ref, String name, String addrLine1, String addrLine2, String town, String county, String country, String postCode) {
        this.ref = ref;
        this.name = name;
        this.addrLine1 = addrLine1;
        this.addrLine2 = addrLine2;
        this.town = town;
        this.county = county;
        this.country = country;
        this.postCode = postCode;
    }

    public String getRef() {
        return this.ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddrline1() {
        return this.addrLine1;
    }

    public void setAddrline1(String addrline1) {
        this.addrLine1 = addrline1;
    }

    public String getAddrine2() {
        return this.addrLine2;
    }

    public void setAddrine2(String addrine2) {
        this.addrLine2 = addrine2;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return this.county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Customer ref(String ref) {
        setRef(ref);
        return this;
    }

    public Customer name(String name) {
        setName(name);
        return this;
    }

    public Customer addrline1(String addrline1) {
        setAddrline1(addrline1);
        return this;
    }

    public Customer addrine2(String addrine2) {
        setAddrine2(addrine2);
        return this;
    }

    public Customer town(String town) {
        setTown(town);
        return this;
    }

    public Customer county(String county) {
        setCounty(county);
        return this;
    }

    public Customer country(String country) {
        setCountry(country);
        return this;
    }

    public Customer postCode(String postCode) {
        setPostCode(postCode);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(ref, customer.ref) && Objects.equals(name, customer.name) && Objects.equals(addrLine1, customer.addrLine1) && Objects.equals(addrLine2, customer.addrLine2) && Objects.equals(town, customer.town) && Objects.equals(county, customer.county) && Objects.equals(country, customer.country) && Objects.equals(postCode, customer.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ref, name, addrLine1, addrLine2, town, county, country, postCode);
    }

    @Override
    public String toString() {
        return "{" +
            " ref='" + getRef() + "'" +
            ", name='" + getName() + "'" +
            ", addrline1='" + getAddrline1() + "'" +
            ", addrine2='" + getAddrine2() + "'" +
            ", town='" + getTown() + "'" +
            ", county='" + getCounty() + "'" +
            ", country='" + getCountry() + "'" +
            ", postCode='" + getPostCode() + "'" +
            "}";
    }
}
