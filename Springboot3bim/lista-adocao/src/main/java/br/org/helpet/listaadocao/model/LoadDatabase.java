package br.org.helpet.listaadocao.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initData(AnimaisRepository repository) {
        return args ->{
            //Inserção de dados iniciais no banco
            Animais animal1 = new Animais("cachorro", "macho", "raça não definida");
            Animais animal2 = new Animais("gato", "fêmea", "Siamês");
            Animais animal3 = new Animais("gato", "macho", "Himalaio");
            Animais animal4 = new Animais("cachorro", "fêmea", "Golden retriever");
            
            List<Animais> animais = new ArrayList<>();
            LarTemp lar1 = new LarTemp("Maurício", "123.123.123-50", "12 997895642");
            animal1.setLarTemp(lar1); //necesário adicionar para sincronizar a conexão bidirecional
            animais.add(animal1); 
            animal1.setLarTemp(lar1); //necesário adicionar para sincronizar a conexão bidirecional
            animais.add(animal1);
            lar1.setAnimais(animais);
            
            LarTemp lar2 = new LarTemp("Joana", "111.222.333-44", "(11) 98877-6655");
            animal2.setLarTemp(lar2); //necesário adicionar para sincronizar a conexão bidirecional entre Lista e Tarefa
            animais.add(animal2); 
            animal4.setLarTemp(lar2); //necesário adicionar para sincronizar a conexão bidirecional
            animais.add(animal4);
            lar2.setAnimais(animais);

            log.info("Inserindo: " + repository.save(animal1));
            log.info("Inserindo: " + repository.save(animal2));
            log.info("Inserindo: " + repository.save(animal3));
            log.info("Inserindo: " + repository.save(animal4));
    };
}
}
