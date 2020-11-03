package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.services.IContratService;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ContratServiceImplTest {

	@Autowired
	IContratService co ; 	
	@Autowired
	IEmployeService en ;
	@Autowired
	ContratRepository cr ;


    @AfterEach
    public void cleanUp() {
		cr.deleteAll();
    }
	
	@Test
	public void testGetAllContrats() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat cont1 = new Contrat (d, "CDI", 12324);
		Contrat cont2 = new Contrat (d, "CDI", 23423);
		Contrat cont3 = new Contrat (d, "CDI", 43523);
		en.ajouterContrat(cont1); 
		en.ajouterContrat(cont2); 
		en.ajouterContrat(cont3); 
		List<Contrat> listContrats = co.getAllContrats(); 
		assertEquals(3, listContrats.size());
	}

}
