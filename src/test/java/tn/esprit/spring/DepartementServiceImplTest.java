package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEntrepriseService;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class DepartementServiceImplTest {

	@Autowired
	IDepartementService ds ; 	
	@Autowired
	IEntrepriseService en ; 
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
    
    @AfterEach
    public void cleanUp() {
        		deptRepoistory.deleteAll();;
    }
    
	@Test
	public void testAjouterDepartement() {
    	Departement dept1 = new Departement("TestDept1");
    	Departement dept2 = new Departement("TestDept2");
    	Departement dept3 = new Departement("TestDept3");
    	int deptAdded1 = en.ajouterDepartement(dept1); 
    	int deptAdded2 = en.ajouterDepartement(dept2); 
    	int deptAdded3 = en.ajouterDepartement(dept3); 
    	List<Departement> listDeps = ds.getAllDepartements(); 
		assertEquals(3, listDeps.size());    
	}


}
