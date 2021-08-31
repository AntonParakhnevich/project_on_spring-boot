package com.example.budjet_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by .
 */

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "incomes")
public class Income implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "income",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Builder.Default
    private Set<CategoryIncome> categoryIncomes = new HashSet<>();

    @Column
    private int totalIncome;

    public void addCategory(CategoryIncome income){
        categoryIncomes.add(income);
    }

    public int calculationTotalIncome() {
        int totalIncome = 0;
        for (CategoryIncome c : categoryIncomes) {
            totalIncome += c.getValue();
        }
        return totalIncome;
    }
}
