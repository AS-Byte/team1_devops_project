package tn.esp.team1.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;
import tn.esp.team1.DTO.FactureDTO;
import tn.esp.team1.entities.*;
import tn.esp.team1.repositories.*;

@Service
@Slf4j
@Transactional
public class FactureServiceImpl implements IFactureService {

    @Autowired
    FactureRepository factureRepository;
    @Autowired
    OperateurRepository operateurRepository;
    @Autowired
    DetailFactureRepository detailFactureRepository;
    @Autowired
    FournisseurRepository fournisseurRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    ReglementServiceImpl reglementService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Facture> retrieveAllFactures() {
        List<Facture> factures = factureRepository.findAll();
        for (Facture facture : factures) {
            log.info(" facture : " + facture);
        }
        return factures;
    }


    public FactureDTO addFacture(FactureDTO f) {
        Facture factureEntity = modelMapper.map(f, Facture.class);
        Facture facture = factureRepository.save(factureEntity);
        return modelMapper.map(facture, FactureDTO.class);
    }

    /*
     * calculer les montants remise et le montant total d'un détail facture
     * ainsi que les montants d'une facture
     */


    @Override
    public void cancelFacture(Long factureId) {
        // Méthode 01

        Facture facture = factureRepository.findById(factureId).orElse(new Facture());
        facture.setArchivee(true);
        factureRepository.save(facture);
        //Méthode 02 (Avec JPQL)
        factureRepository.updateFacture(factureId);
    }

    @Override
    public Facture retrieveFacture(Long factureId) {

        Optional<Facture> facture = factureRepository.findById(factureId);
        if(facture.isPresent()){
            log.info("facture :" + facture);

            return facture.get();

        }else{
            return null;
        }

    }

    @Override
    public List<Facture> getFacturesByFournisseur(Long idFournisseur) {
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(idFournisseur);
        if(fournisseur.isPresent()){
            return (List<Facture>) fournisseur.get().getFactures();

        }else{
            return new ArrayList<>();
        }
    }

    @Override
    public void assignOperateurToFacture(Long idOperateur, Long idFacture) {
        Facture facture = factureRepository.findById(idFacture).orElse(null);
        Optional<Operateur> operateur = operateurRepository.findById(idOperateur);
        if(operateur.isPresent()){
            operateur.get().getFactures().add(facture);
            operateurRepository.save(operateur.get());
        }

    }

    @Override
    public float pourcentageRecouvrement(Date startDate, Date endDate) {
        float totalFacturesEntreDeuxDates = factureRepository.getTotalFacturesEntreDeuxDates(startDate,endDate);
        float totalRecouvrementEntreDeuxDates =reglementService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
        return (totalRecouvrementEntreDeuxDates/totalFacturesEntreDeuxDates)*100;

    }


}
