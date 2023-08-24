package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.BatchSize;
import org.intellij.lang.annotations.Pattern;
import peaksoft.enums.Gender;

import java.util.List;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_gen")
    @SequenceGenerator(
            name = "patient_gen",
            sequenceName = "patient_seq",
            allocationSize = 1)
    private Long id;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
//    @Pattern(regexp = "^(?!\\+996)\\d+$")
//    @BatchSize(value = int size=13)
    @Column(name = "phone_number")
    private String phoneNumber;
    @NotNull()
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull
    @Column(unique = true)
    private String email;
    @ManyToOne
    private Hospital hospital;
    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private List<Appointment> appointments;
}

