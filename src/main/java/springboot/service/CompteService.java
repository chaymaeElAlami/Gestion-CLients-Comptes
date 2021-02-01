package springboot.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.entity.Compte;
import springboot.repository.CompteRepository;

@Service
public class CompteService {
	private CompteRepository compteRepository;

    @Autowired
    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    public Compte saveCompte(Compte compte) {
        return compteRepository.saveAndFlush(compte);
    }
    
    public List<Compte> findAll(){
        return compteRepository.findAll();
    }
    

    public void deleteCompte(Long id) throws Exception {
        Compte compte = compteRepository.findById(id).orElseThrow(() -> new Exception("Account not found"));
        compteRepository.delete(compte);
    }
	
	   public Optional<Compte> findCompteById(Long id) {
        return compteRepository.findById(id);
    }
    
    
    public Compte findCompById(Long id) throws Exception {
        return compteRepository.findById(id).orElseThrow(() -> new Exception("Account not found"));
    }
    public List<Compte> findCompteByClientId(Long id){
        return compteRepository.getComptesByClientId(id);
    }
    public List<Compte> findByType(String keyword) {
        return compteRepository.findByTypeLike(keyword);
    }
}
