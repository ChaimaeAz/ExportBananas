package asios.sh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validator;
import javax.validation.metadata.ConstraintDescriptor;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import asios.sh.entities.Commande;
import asios.sh.entities.Destinataire;
import asios.sh.repositories.CommandeRepository;
import asios.sh.services.CommandeServiceImpl;

@ExtendWith(SpringExtension.class)
public class CommandeServiceImplTest {

    @InjectMocks
    private CommandeServiceImpl commandeService;

    @Mock
    private CommandeRepository commandeRepository;
    
    @Mock
    private Validator validator;

    @BeforeEach
    public void setUp() {
    	
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testCreerCommande_WithValidData() {
        // Create a valid Commande object
    	Destinataire dest = new Destinataire(1, "", "", "", "", "");
    	Commande commande = new Commande(1,10,123, LocalDate.now(),null);
    	List<Commande> listCommande = new ArrayList<Commande>();
    	listCommande.add(commande);
    	commande.setDestinataire(dest);
    	
    	commande.setDateLivraison(LocalDate.now().plusDays(10)); // Valide date
        commande.setQuantite(100); // Valide quantite

        // Mock validator pour returner un empty set de ConstraintViolations
        when(validator.validate(commande)).thenReturn(new HashSet<ConstraintViolation<Commande>>());

        //doNothing().when(commandeRepository.creerCommande(commande)).voidMethod();

        commandeService.creerCommande(commande);

        // Verify that the commandeRepository's method was called with the expected argument
        verify(commandeRepository, times(1)).creerCommande(commande);
    }
    
    @Test
    public void testCreerCommande_WithInvalidData() {
    	// Create a valid Commande object
    	Destinataire dest = new Destinataire(1, "", "", "", "", "");
    	Commande commande = new Commande(1,10,123, LocalDate.now(),null);
    	List<Commande> listCommande = new ArrayList<Commande>();
    	listCommande.add(commande);
    	commande.setDestinataire(dest);
        // Mock the validator to return a set of ConstraintViolations (invalid data)
        Set<ConstraintViolation<Commande>> violations = new HashSet<>();
        // Add ConstraintViolations to the violations set for invalid fields
        violations.add(new ConstraintViolation<Commande>() {
			
			@Override
			public <U> U unwrap(Class<U> type) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Class<Commande> getRootBeanClass() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Commande getRootBean() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Path getPropertyPath() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getMessageTemplate() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getMessage() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getLeafBean() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getInvalidValue() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getExecutableReturnValue() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object[] getExecutableParameters() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ConstraintDescriptor<?> getConstraintDescriptor() {
				// TODO Auto-generated method stub
				return null;
			}
		});
        when(validator.validate(commande)).thenReturn(violations);

        // Call the method under test
        commandeService.creerCommande(commande);

        // Verify that the commandeRepository's method was not called
        verify(commandeRepository, times(0)).creerCommande(commande);
    }


    
    @Test
    public void testconsulterCommandesParDestinataire() {

    	Destinataire dest = new Destinataire(1, "", "", "", "", "");
    	Commande commande = new Commande(1,10,123, LocalDate.now(),null);
    	List<Commande> listCommande = new ArrayList<Commande>();
    	listCommande.add(commande);
    	commande.setDestinataire(dest);

    	when(commandeRepository.consulterCommandesParDestinataire(dest)).thenReturn(listCommande);

    	assertEquals(commandeService.consulterCommandesParDestinataire(dest), listCommande);

        verify(commandeRepository, times(1)).creerCommande(any(Commande.class));
    
    }
    
    

}

