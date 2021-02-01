package springboot.control;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import springboot.entity.Client;
import springboot.service.ClientService;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/clients")
    public ModelAndView getAllClients(String keyword) {
        ModelAndView modelAndView = new ModelAndView();
        List<Client> clients;
        clients = clientService.findAll();
        if (keyword != null) {
            clients = clientService.findByType(keyword);
        }
        modelAndView.addObject("keyword", keyword);
        modelAndView.addObject("clients", clients);
        modelAndView.setViewName("clients");
        return modelAndView;
    }

    @GetMapping("/delete-client/{id}")
    public ModelAndView deleteClient(@PathVariable("id") long id) throws Exception {
        clientService.deleteClient(id);
        List<Client> clients = clientService.findAll();
        ModelAndView model = new ModelAndView(new RedirectView("/clients"));
        model.addObject("clients", clients);
        return model;
    }

    @PostMapping(value = "/update-client")
    public ModelAndView updateClient(Client client, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView()); 
        clientService.saveClient(client);
        modelAndView.setViewName("redirect:clients");
        return modelAndView;
    }

    @GetMapping(value = "/edit-client/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") long id, ModelAndView modelAndView) throws Exception {
        Client client = clientService.findclienById(id);
        modelAndView.addObject("client", client);
        modelAndView.setViewName("edit-client");
        return modelAndView;
    }

  @GetMapping(value = "/add-client")
    public ModelAndView showAddConventionForm() {
        ModelAndView modelAndView = new ModelAndView();
        Client client = new Client();
        modelAndView.addObject("client", client);
        modelAndView.setViewName("add-client");
        return modelAndView;
    }
   
    @PostMapping(value = "/saveClient")
    public ModelAndView saveClient(@Valid Client client, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView());      
        clientService.saveClient(client);
        modelAndView.setViewName("redirect:clients");
        return modelAndView;
    }
    
    
	@GetMapping("/clients/showNewClientForm")
	public String showNewClientForm(Model model) {
		// create model attribute to bind form data
		Client client = new Client();
		model.addAttribute("client", client);
		return "new_client";
	}
}
