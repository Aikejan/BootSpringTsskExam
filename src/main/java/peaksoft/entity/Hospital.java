package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.FetchType.EAGER;

@Entity
@Table(name = "hospitals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "hospital_gen")
    @SequenceGenerator(name = "hospital_gen",
            sequenceName = "hospital_seq",
            allocationSize = 1)

    private Long id;
    @Column(length = 2000)
    private String image;
    private String name;
    private String address;

    @OneToMany(mappedBy = "hospital", cascade = {REFRESH, DETACH, REMOVE, MERGE}, fetch = EAGER)
    @ToString.Exclude
    private List<Department> departments;

    @OneToMany(mappedBy = "hospital", cascade = {REFRESH, MERGE, DETACH, REMOVE}, fetch = EAGER)
    @ToString.Exclude
    private List<Doctor> doctors;

    @OneToMany(mappedBy = "hospital", cascade = {REFRESH, MERGE, REMOVE, DETACH}, fetch = EAGER)
    @ToString.Exclude
    private List<Patient> patients;

    @OneToMany
    private List<Appointment> appointments;


    public void setDepartment(Department department) {
        this.departments.add(department);

    }

    public void setDoctor(Doctor doctor) {
        this.doctors.add(doctor);

    }

    public void addAppointment(Appointment newAppointment) {
        this.appointments.add(newAppointment);

    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);

    }

    public void setPatient(Patient patient) {
        this.patients.add(patient);
    }
}
