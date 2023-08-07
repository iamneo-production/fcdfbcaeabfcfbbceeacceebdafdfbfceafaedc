package com.examly.springapp.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Springapp;
import com.examly.springapp.repository.SpringappRepository;
@Service
public class SpringappServiceImpl implements SpringappService {
	@Autowired
	private SpringappRepository springapprep;
	@Override
	public List<Springapp> alltasks(){
		return springapprep.findAll();
	}
	@Override
	public void saveTask(Springapp springapp) {
		this.springapprep.save(springapp);
	}
	@Override
	public Springapp getTaskById(long ID) {
		return springapprep.findById((int) ID).orElseThrow();
	}
@Override
public void deleteTask(long ID) {
	this.springapprep.deleteById((int) ID);
}
@Override
public void changeStatus(Springapp sp){
	this.springapprep.save(sp);
}
@Override
public Page<Springapp> findPaginated(int pageNo,int ps, String sortf, String sortd){
	Sort s=sortd.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortf).ascending():Sort.by(sortf).descending();
	Pageable pga=PageRequest.of(pageNo-1, ps,s);
	return this.springapprep.findAll(pga);
}
}

