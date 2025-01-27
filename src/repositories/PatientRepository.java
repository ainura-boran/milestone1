package repositories;

import dao.PatientDAO;
import data.interfaces.IDB;
import models.Patient;
import repositories.interfaces.IPatientRepository;

import java.sql.Connection;
import java.util.List;

public class PatientRepository implements IPatientRepository {
    private final PatientDAO patientDAO;

    public PatientRepository(IDB db) {
        Connection connection = db.getConnection();
        this.patientDAO = new PatientDAO(connection);
    }

    @Override
    public boolean addPatient(Patient patient) {
        return patientDAO.addPatient(patient);
    }

    @Override
    public Patient getPatientById(int id) {
        return patientDAO.getPatientById(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.getAllPatients();
    }
}
