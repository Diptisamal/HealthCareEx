package in.nareshit.dipti.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nareshit.dipti.entity.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

	@Query("SELECT COUNT(specCode) FROM Specialization  WHERE specCode=:specCode")
	Integer getSpecCodeCount(String specCode);
	
}