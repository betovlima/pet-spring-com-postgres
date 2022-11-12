package br.com.cursojava.petshop.service;

import br.com.cursojava.petshop.dto.RequestNewAnimalDTO;
import br.com.cursojava.petshop.dto.ResultListAnimalDTO;
import br.com.cursojava.petshop.model.Animal;
import br.com.cursojava.petshop.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO ajustar com anotation lombok para deixar código
// mais clean sem construtor declarado
@AllArgsConstructor
@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final ModelMapper mapper;

    //TODO ajustar para popular DTO com mapper
    public List<ResultListAnimalDTO> getAnimal() {
        var result = new ArrayList<ResultListAnimalDTO>();
        this.animalRepository
                .findAll()
                .iterator()
                .forEachRemaining(e -> result.add(mapper.map(e, ResultListAnimalDTO.class)
                ));
        return result;

    }

    public List<Animal> getAnimalPorNome(String nome) {
        return animalRepository.findByNome(nome);
    }

    public List<Animal> getAnimalPorRaca(String raca) {
        return animalRepository.findByRaca(raca);
    }

    public List<Animal> getAnimalPorIdade(Integer idade) {
        return animalRepository.findByIdade(idade);
    }

    public Optional<Animal> criarAnimal(RequestNewAnimalDTO novo) {
        return Optional.of(animalRepository
                .save(
                        this.mapper.map(novo, Animal.class)
                ));
    }

    public Animal alteraAnimal(Animal animal) {
        if (animalRepository.existsById(animal.getId())) {
            return animalRepository.save(animal);
        } else {
            throw new RuntimeException(String.format("O animal com o ID %d não existe!", animal.getId()));
        }
    }

    public Animal deletaAnimal(Animal animal) {
        if (animalRepository.existsById(animal.getId())) {
            animalRepository.delete(animal);
            return animal;
        } else {
            throw new RuntimeException(String.format("O animal com o ID %d não existe!", animal.getId()));
        }
    }
}
