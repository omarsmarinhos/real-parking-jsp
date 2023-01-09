package test;

import com.RealParking.domain.service.IncidentServiceTestImpl;
import com.RealParking.persitence.entity.Incident;
import com.RealParking.persitence.entity.Voucher;
import com.RealParking.persitence.repository.IncidentRepository;
import com.RealParking.persitence.repository.IncidentRepositoryImplement;
import com.RealParking.persitence.repository.VoucherRepositoryImplement;
import jakarta.inject.Inject;

import java.util.List;

public class Test {
    @Inject
    IncidentRepository incidentRepository;


    public static void main(String[] args) {


        IncidentRepositoryImplement incidentRepositoryImplement = new IncidentRepositoryImplement();
        System.out.println(incidentRepositoryImplement.listarIncidentes());
    }

}
