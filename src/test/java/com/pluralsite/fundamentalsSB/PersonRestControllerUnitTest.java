package com.pluralsite.fundamentalsSB;

import com.pluralsite.fundamentalsSB.data.Passport;
import com.pluralsite.fundamentalsSB.data.Person;
import com.pluralsite.fundamentalsSB.service.PassportService;
import com.pluralsite.fundamentalsSB.service.PersonService;
import com.pluralsite.fundamentalsSB.web.PersonRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonRestController.class)
public class PersonRestControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PersonService personService;
    @MockBean
    PassportService passportService;

    @Test
    public void getAllPersons() throws Exception {
        ArrayList<Person> people = new ArrayList<>();
        Person person = new Person();
        person.setName("uair");
        people.add(person);
        when(personService.listOfPersons()).thenReturn(people);
        mockMvc.perform(get("/info/person/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(personService, times(1)).listOfPersons();
    }


}
