package com.examly.springapp.service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.examly.springapp.model.Springapp;

public interface SpringappService {
    List<Springapp> alltasks();
	void saveTask(Springapp stud);
	Springapp getTaskById(long id);
	void deleteTask(long ID);
    void changeStatus(Springapp sp);
	Page<Springapp> findPaginated(int pageNo,int ps, String sortf, String sortd);
}



