package asios.sh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asios.sh.entities.Destinataire;
import asios.sh.services.DestinataireService;

@RestController
@RequestMapping("/destinataire")
public class DestinataireController {

	@Autowired
	DestinataireService destinataireService;
	
	@GetMapping("/consulterDestinataires")
    public List<Destinataire> consulterDestinataires() {
        return destinataireService.consulterDestinataire();
    }
}
