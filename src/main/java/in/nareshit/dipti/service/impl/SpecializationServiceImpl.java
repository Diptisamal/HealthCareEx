package in.nareshit.dipti.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.dipti.entity.Specialization;
import in.nareshit.dipti.exception.SpecializationNotFoundException;
import in.nareshit.dipti.repo.SpecializationRepository;
import in.nareshit.dipti.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService {

	@Autowired
	private SpecializationRepository repo;

	public Long saveSpecialization(Specialization spec) {
		return repo.save(spec).getId();
	}

	public List<Specialization> getAllSpecializations() {
		return repo.findAll();
	}

	public void removeSpecialization(Long id) {
		repo.deleteById(id);
	}


	public Specialization getOneSpecialization(Long id) {
		Optional<Specialization>  optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new SpecializationNotFoundException(id+ " Not Found");
		}
		/*return repo.findById(id).orElseThrow(
				()-> new SpecializationNotFoundException(id+ " Not Found")
				);*/
	}

	public void updateSpecialization(Specialization spec) {
		repo.save(spec);
	}

	public boolean isSpecCodeExist(String specCode) {
		/*Integer count = repo.getSpecCodeCount(specCode);
		boolean exist = count>0 ? true : false;
		return exist;*/
		return repo.getSpecCodeCount(specCode)>0;
	}
}