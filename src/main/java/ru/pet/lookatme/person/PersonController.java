package ru.pet.lookatme.person;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<PersonModel> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/mydata")
    public String getPersonExternal() {
        String url = "https://json.geoiplookup.io/";
        RestTemplate restTemplate = new RestTemplate();
        PersonModel personModel = restTemplate.getForObject(url, PersonModel.class);
        System.out.println(personModel.ip);
        return personModel.toString();
    }

    @PostMapping
    public void addNewPerson(@RequestBody PersonModel person) {
        System.out.println(person);
        personService.addNewPerson(person);
    }

}
