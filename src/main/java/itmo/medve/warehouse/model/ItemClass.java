package itmo.medve.warehouse.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ItemClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    String name;

    Integer amount;
    Double price;

    public ItemClass() {
    }

    public ItemClass(String name, Integer amount, Double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemClass)) return false;
        ItemClass itemClass = (ItemClass) o;
        return Objects.equals(id, itemClass.id) &&
                Objects.equals(name, itemClass.name) &&
                Objects.equals(amount, itemClass.amount) &&
                Objects.equals(price, itemClass.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amount, price);
    }
}
