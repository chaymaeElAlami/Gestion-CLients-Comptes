package springboot.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.entity.Client;
import springboot.repository.ClientRepository;

@Service
public class ClientService {
	 private ClientRepository clientRepository;

	    @Autowired
	    public ClientService(ClientRepository clientRepository) {
	        this.clientRepository = clientRepository;
	    }

	  
	    public Client saveClient(Client client) {
	        return clientRepository.saveAndFlush(client);
	    }
	    
	    public List<Client> findAll(){
	        return clientRepository.findAll();
	    }

		public Optional<Client> findClientById(Long id) throws Exception {
	        return clientRepository.findById(id);
	    }

	    public Client findclienById(Long id) throws Exception {
	        return clientRepository.findById(id).orElseThrow(() -> new Exception("Client not found"));
	    }

	    public void deleteClient(Long id) throws Exception {
	        Client client = clientRepository.findById(id).orElseThrow(() -> new Exception("Client not found"));
	        clientRepository.delete(client);
	    }
	public List<Client> findByType(String keyword) {
		return clientRepository.findByTypeLike(keyword);
	}
	}
