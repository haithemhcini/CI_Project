package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;
import tn.esprit.spring.services.ITimesheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TimesheetServiceImplTest {

	@Autowired
	ITimesheetService ts ; 	
	@Autowired
	IDepartementService dpt ; 	
	@Autowired
	IEmployeService emp ; 	
	@Autowired
	IEntrepriseService entrep ; 
	
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	ContratRepository contRepo;
	@Autowired
	MissionRepository missRepo;
	@Autowired
	TimesheetRepository timeRepo;

	@AfterEach
    public void cleanUp() {
	  timeRepo.deleteAll();
	  missRepo.deleteAll();
	  entrepriseRepoistory.deleteAll();
	  deptRepoistory.deleteAll();
	  contRepo.deleteAll();
    }
	
	@Test
	void contextLoads() {
	}
	
	@Test
    public void testAjouterMission() throws ParseException {
		Timesheet timesheet = new Timesheet();
    	Departement dept = new Departement("TestDept3");
    	int deptAdded = entrep.ajouterDepartement(dept); 
		Mission mission = new Mission("TEST","DESC");
		mission.setDepartement(dept);
		Mission missionAdded = ts.ajouterMission(mission); 
		assertEquals(mission.getName(), missionAdded.getName());    
		}
	
	
}
