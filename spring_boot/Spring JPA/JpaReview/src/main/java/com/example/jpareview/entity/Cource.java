package com.example.jpareview.entity;
import com.example.jpareview.statics.Type;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Set;
@Entity
@Table(name = "cource")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String name;

    String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Type type;

    String thumbnail;

    @ManyToOne
    @JoinColumn(name = "supporter_id")
    Supporter supporter;

    @ManyToMany
    @JoinTable(name = "cource_topic",
            joinColumns = @JoinColumn(name = "cource_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id"))
    Set<Topic> topics;
}
