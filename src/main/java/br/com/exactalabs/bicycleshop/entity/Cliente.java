package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo",
        discriminatorType = DiscriminatorType.STRING)
@Table(name = "cliente")
public abstract class Cliente {

    @Id
    private Long id;
    private String name;
    private String document;

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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

}
