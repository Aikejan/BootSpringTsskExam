package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "departmens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "department_gen")
    @SequenceGenerator(name = "department_gen",
            sequenceName = "department_seq",
            allocationSize = 1)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "departments")
    @ToString.Exclude
    private List<Doctor> doctors;
    @OneToMany(mappedBy = "department")
    private List<Appointment> appointments;
    @ManyToOne
    private Hospital hospital;

    public void addDoctor(Doctor doctor) {
    }
}
