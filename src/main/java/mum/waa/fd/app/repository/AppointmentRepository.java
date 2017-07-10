package mum.waa.fd.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.waa.fd.app.domain.Appointment;



@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

}
