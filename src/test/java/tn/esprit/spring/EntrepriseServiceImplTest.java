package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class EntrepriseServiceImplTest {

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
        		entrepriseRepoistory.deleteAll();
    }
	
	@Test
    public void testAjouterEntreprise() {
    	Entreprise ent = new Entreprise("TestEntreprise", "SAS");
    	int entrAdded = en.ajouterEntreprise(ent); 
		assertEquals(ent.getName(), ent.getName());    
		}
	
	@Test 
	public void testGetDepartementById() {
    	Departement dept = new Departement("TestDept");
    	int deptAdded = en.ajouterDepartement(dept); 
    	List<Departement> listeDep = new ArrayList<>();
    	Departement depTest = ds.getDepartementById(deptAdded);
    	 listeDep.add(depTest);
    	 System.out.println(listeDep.toString());
    	assertEquals(1, listeDep.size());
	}
	
	@Test
    public void testAjouterDepartement() throws ParseException{
    	Departement dept = new Departement("TestDept");
    	int deptAdded = en.ajouterDepartement(dept); 
		assertEquals(dept.getName(), dept.getName());    
    }
	
/*	@Test
    public void testAffecterDepartementAEntreprise() {
    	Departement dept = new Departement("TestDept");
    	Entreprise ent = new Entreprise("TestEntreprise", "SAS");
    	int deptAdded = en.ajouterDepartement(dept); 
    	int entrAdded = en.ajouterEntreprise(ent); 
    	en.affecterDepartementAEntreprise(deptAdded, entrAdded);
    	Departement entDept = ds.getDepartementById(deptAdded);
		assertEquals(entrAdded , entDept.getEntrepriseId());    
    }*/
	
	/*@Test
    public void testGetAllDepartementsNamesByEntreprise() {
    	Entreprise ent = new Entreprise("TestEntreprise", "SAS");
    	Departement dept1 = new Departement("TestDept1");
    	Departement dept2 = new Departement("TestDept2");
    	Departement dept3 = new Departement("TestDept3");
    	int entrAdded = en.ajouterEntreprise(ent); 
    	int deptAdded1 = en.ajouterDepartement(dept1); 
    	int deptAdded2 = en.ajouterDepartement(dept2); 
    	int deptAdded3 = en.ajouterDepartement(dept3); 
    	en.affecterDepartementAEntreprise(deptAdded1, entrAdded);
    	en.affecterDepartementAEntreprise(deptAdded2, entrAdded);
    	en.affecterDepartementAEntreprise(deptAdded3, entrAdded);
    	List<String> depNames = new ArrayList<>();
    	depNames.add(dept1.getName());
    	depNames.add(dept2.getName());
    	depNames.add(dept3.getName());
        List<String> deptTest = en.getAllDepartementsNamesByEntreprise(entrAdded);
		assertEquals(3, depNames.size());
    }*/

	
	@Test
    public void testDeleteEntrepriseById() {
    	Entreprise ent = new Entreprise("TestEntreprise", "SAS");
    	int entrAdded = en.ajouterEntreprise(ent); 
    	int entrDeleted = en.deleteEntrepriseById(entrAdded);
    	assertEquals(entrAdded, entrDeleted );
    }
	
	@Test
    public void testDeleteDepartementById() {
    	Entreprise ent = new Entreprise("TestEntreprise", "SAS");
    	Departement dept = new Departement("TestDept");
    	int deptAdded = en.ajouterDepartement(dept); 
    	en.ajouterEntreprise(ent); 
    	int deptDeleted = en.deleteDepartementById(deptAdded);
    	assertEquals(deptAdded, deptDeleted );
    }
	
	@Test
    public void testGetEntrepriseById() {
    	Entreprise ent = new Entreprise("TestEntreprise", "SAS");
    	int entrAdded = en.ajouterEntreprise(ent); 
    	Entreprise entr = en.getEntrepriseById(entrAdded);
    	
    	assertEquals(entrAdded,entr.getId());
    }

}
