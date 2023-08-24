package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.Date;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.DETACH;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "doctor_gen")
    @SequenceGenerator(name = "doctor_gen",
            sequenceName = "department_seq",
            allocationSize = 1)
    private Long id;
    @NotNull
    private LocalDate Date;
    @ManyToOne
    @ToString.Exclude
    private Patient patient;
    @ManyToOne(cascade = {REFRESH, PERSIST, MERGE, DETACH})
    @ToString.Exclude
    private Doctor doctor;
    @ManyToOne
    private Department department;
    @Transient
    private Long doctorId;
    @Transient
    private Long departmentId;
    @Transient
    private Long patientId;



}
