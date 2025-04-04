package org.example.part6.buckpal.adapter.out;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="activity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityJpaEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private LocalDateTime timestamp;
    @Column
    private Long ownerAccountId;
    @Column
    private Long sourceAccountId;
    @Column
    private Long targetAccountId;
    @Column
    private Long amount;

}
