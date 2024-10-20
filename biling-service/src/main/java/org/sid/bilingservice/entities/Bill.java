package org.sid.bilingservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.bilingservice.model.Customer;


import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Bill {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Date billDate;
        private Long customerId;
        @OneToMany(mappedBy = "bill")
        private List<ProductItem> productItems;
        /*une facon de dire a jpa cette attribut il est dans la classe mais il n'est pas dans la base donne */
        @Transient
        private Customer customer;




}
