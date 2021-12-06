package br.org.helpet.listaadocao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.helpet.listaadocao.model.Animais;
import br.org.helpet.listaadocao.model.AnimaisRepository;
import br.org.helpet.listaadocao.model.LarTemp;
import br.org.helpet.listaadocao.model.LarTempRepository;


@CrossOrigin(origins = "http:\\localhost:3000")
@RestController
public class ListaController {
    
    private static final Logger log = LoggerFactory.getLogger(ListaController.class);

    @Autowired
    AnimaisRepository animaisRepository;
    @Autowired
    LarTempRepository larTempRepository;

    @GetMapping("/animais")
    public List<Animais> getLista(){
        return (List<Animais>) animaisRepository.findAll();
    }

    @GetMapping("/larTemps")
    public List<LarTemp> getList(){
        return (List<LarTemp>) larTempRepository.findAll();
    }

    @GetMapping("/animais/{id}")
      @ResponseBody
      public Animais getAnimalById(@PathVariable("id") Animais animal){
          return animal;
      }
    
    @PostMapping("/animais/cadastrar")
      public Animais postAnimal(@RequestBody Animais animal){
          animaisRepository.save(animal);
          if(animaisRepository.findById(animal.getId()).isPresent())
              return animal;
          return null;
      }

      @PostMapping("/larTemps/cadastrar")
      public LarTemp postLar(@RequestBody LarTemp larTemp){
          larTempRepository.save(larTemp);
          if(larTempRepository.findById(larTemp.getId()).isPresent())
              return larTemp;
          return null;
      }

      @PostMapping("/animais/{id}/adicionarLar")
      public LarTemp postLarTempToAnimais(@PathVariable Long id, @RequestBody LarTemp larTemp){
          if(animaisRepository.findById(id).isPresent()){
              Animais animal = animaisRepository.findById(id).get();
              log.debug(larTemp.getCpf());
              animal.setLarTemp(larTemp);
              larTemp = larTempRepository.save(larTemp);
              return larTemp;
          }
          return null;
      }

      @DeleteMapping("/animais/deletarAnimal/{animal}")
      public Animais deleteAnimal(@RequestBody Animais animal){
            if(animaisRepository.findById(animal.getId()).isPresent()){
              animaisRepository.delete(animal);
              return animal;
          }
          return null;
      }

      @DeleteMapping("/larTemps/deletarLar/{larTemp}")
      public LarTemp deleteLar(@RequestBody LarTemp larTemp){
            if(larTempRepository.findById(larTemp.getId()).isPresent()){
              larTempRepository.delete(larTemp);
              return larTemp;
          }
          return null;
      }

      @DeleteMapping("/animais/deletarLar/{id}")
      public LarTemp deleteLarOfAnimais(@PathVariable Long id){
          if(larTempRepository.findById(id).isPresent()){
              LarTemp larTemp = larTempRepository.findById(id).get();
              larTempRepository.delete(larTemp);
              return larTemp;
          }
          return null;
      }

      @PutMapping("/animais/alterarAnimal/{id}")
      public Animais putAnimal(@PathVariable Long id, @RequestBody Animais animal){
          if(animaisRepository.findById(id).isPresent()){
              Animais animalBanco = animaisRepository.findById(id).get();
              animalBanco.setTipoAnimal(animal.getTipoAnimal());
              animalBanco.setSexo(animal.getSexo());
              animalBanco.setRaca(animal.getRaca());
              animaisRepository.save(animalBanco);
              return animal;
          }
          return null;
      }  
      
      @PutMapping("/larTemps/alterarLar/{id}")
      public LarTemp putLarTemp(@PathVariable Long id, @RequestBody LarTemp larTemp){
          if(larTempRepository.findById(id).isPresent()){
              LarTemp larBanco = larTempRepository.findById(id).get();
              larBanco.setNome(larTemp.getNome());
              larBanco.setCpf(larTemp.getCpf());
              larBanco.setTelefone(larTemp.getTelefone());
              larTempRepository.save(larBanco);
              return larTemp;
          }
          return null;
      }  
    
    
    

}
