package tn.esp.team1.controllers;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import tn.esp.team1.dto.FactureDTO;
import tn.esp.team1.entities.Facture;
import tn.esp.team1.services.IFactureService;


@RestController
@Api(tags = "Gestion des factures")
@RequestMapping("/facture")
@CrossOrigin("*")
public class FactureRestController {

    @Autowired
    IFactureService factureService;

    @Autowired
    private ModelMapper modelMapper;

    // http://localhost:8089/SpringMVC/facture/retrieve-all-factures
    @GetMapping("/retrieve-all-factures")
    @ResponseBody
    public List<Facture> getFactures() {
        return factureService.retrieveAllFactures();
    }

    // http://localhost:8089/SpringMVC/facture/retrieve-facture/8
    @GetMapping("/retrieve-facture/{facture-id}")
    @ResponseBody
    public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
        return factureService.retrieveFacture(factureId);
    }

    @PostMapping("/add-facture")
    @ResponseBody
    public FactureDTO addFacture(@RequestBody FactureDTO f) {
        return factureService.addFacture(f);
    }

    /*
     * une facture peut etre annulé si elle a été saisie par erreur Pour ce
     * faire, il suffit de mettre le champs active à false
     */
    @PutMapping("/cancel-facture/{facture-id}")
    @ResponseBody
    public void cancelFacture(@PathVariable("facture-id") Long factureId) {
        factureService.cancelFacture(factureId);
    }

    @GetMapping("/getFactureByFournisseur/{fournisseur-id}")
    @ResponseBody
    public List<Facture> getFactureByFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
        return factureService.getFacturesByFournisseur(fournisseurId);
    }

    // http://localhost:8089/SpringMVC/facture/assignOperateurToFacture/1/1
    @PutMapping(value = "/assignOperateurToFacture/{idOperateur}/{idFacture}")
    public void assignOperateurToFacture(@PathVariable("idOperateur") Long idOperateur, @PathVariable("idFacture") Long idFacture) {
        factureService.assignOperateurToFacture(idOperateur, idFacture);
    }

    @GetMapping(value = "/pourcentageRecouvrement/{startDate}/{endDate}")
    public float pourcentageRecouvrement(
            @PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        try {
            return factureService.pourcentageRecouvrement(startDate, endDate);
        } catch (Exception e) {
            return 0;
        }
    }

}
