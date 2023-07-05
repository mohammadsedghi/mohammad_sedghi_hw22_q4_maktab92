package entity;

import base.entity.BaseEntity;
import jakarta.persistence.Entity;
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
public class Vote extends BaseEntity<Long> {

    String vote;
}
