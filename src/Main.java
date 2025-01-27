import application.DoctorApplication;
import controllers.DoctorController;
import data.PostgresDB;
import repositories.DoctorRepository;

public class Main {
    public static void main(String[] args) {
        PostgresDB db = new PostgresDB("jdbc:postgresql://localhost:5432", "postgres", "0000", "medicalInformationSystem");

        DoctorRepository doctorRepository = new DoctorRepository(db);
        DoctorController doctorController = new DoctorController(doctorRepository);
        DoctorApplication app = new DoctorApplication(doctorController);

        app.start();
    }
}
