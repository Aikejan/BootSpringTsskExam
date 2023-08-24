package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
            generator = "doctor_gen")
    @SequenceGenerator(name = "doctor_gen",
            sequenceName = "doctor_seq",
            allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @NotNull
    private String position;
    @NotNull
    @Column(unique = true)
    private String email;
    //@ManyToMany
    @ManyToMany
    @ToString.Exclude
    private List<Department> departments;
    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private List<Appointment> appointments;
    @ManyToOne
    private Hospital hospital;
    public void addDepartment(Department department) {
        this.departments.add(department);
    }
    }
