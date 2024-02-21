package com.home.boot.boot2.model.emb;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class orderTbl {
    @EmbeddedId
    private orderId orderId;
    @Embedded
    private address address;
    private String otherField;
}
