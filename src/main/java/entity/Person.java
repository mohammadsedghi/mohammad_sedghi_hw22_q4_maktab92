package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person extends BaseEntity<Long> {
    String name;
    String family;
    String username;
    String password;
    @ManyToOne
    Vote vote;
}
