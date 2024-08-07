package io.codeforall.vimtages.model;


import javax.persistence.*;

@Entity
@Table(name = "facts")
public class Facts implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fact;
    @ManyToOne
    private Category category;
    @Override
    public Integer getId() {
        return id;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
