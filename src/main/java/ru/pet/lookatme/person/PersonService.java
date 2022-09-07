package ru.pet.lookatme.person;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<PersonModel> getAllPersons() {
        return personRepository.findAll();
    }

    public void addNewPerson(PersonModel person) {
        Optional<PersonModel> personModelByIp = personRepository.findPersonModelByIp(person.getIp());
        if (personModelByIp.isPresent()) {
            throw new IllegalStateException("the person exists");
        }
        personRepository.save(person);
    }

}
