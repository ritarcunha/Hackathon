package io.codeforall.vimtages.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String Name;

    public List<Facts> getFactsList() {
        return factsList;
    }


    public void addFact(Facts fact){
        this.factsList.add(fact);
    }

    public void addFactCollection(Collection<Facts> collection){
       this.factsList.addAll(collection);
    }
    @OneToMany(cascade = {CascadeType.ALL},
    fetch = FetchType.LAZY,
    orphanRemoval = true,
    mappedBy = "category")
    private List<Facts> factsList = new ArrayList<>();
    @Override
    public Integer getId() {
        return id;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
