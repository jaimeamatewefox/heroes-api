package com.stark.industries.document;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "heroes")
public class HeroDBDocument {
    @Id
    private String id;

    private String name;

    @Field(name = "super_powers")
    private List<String> superPowers;

}
