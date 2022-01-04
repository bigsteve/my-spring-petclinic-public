/**

Copyright (c) 2021 Stefan Miller

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

*/
package stefan.spring.petclinicweb.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import stefan.spring.petclinicdata.model.Owner;
import stefan.spring.petclinicdata.service.sdjpa.OwnerServiceJpa;

/**
 * @author stefan
 *
 */
@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {
    @Mock
    OwnerServiceJpa ownerServiceJpa;
    @InjectMocks
    OwnerController ownerController;

    MockMvc mockMvc;

    Set<Owner> owners;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    /**
     * Test method for
     * {@link stefan.spring.petclinicweb.controllers.OwnerController#findOwners()}.
     * @throws Exception 
     */
    @Test
    void testFindOwners() throws Exception {

        mockMvc.perform(get("/owners/find/"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/findOwners"));
        verifyNoInteractions(ownerServiceJpa);
    }
    
    /**
     * Test method for
     * {@link stefan.spring.petclinicweb.controllers.OwnerController#showOwner(Long)}.
     * @throws Exception 
     */
    @Test
    void testDisplayOwner() throws Exception {
        
        when(ownerServiceJpa.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
        mockMvc.perform(get("/owners/111/"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/ownerDetails"))
        .andExpect(model().attribute("owner", hasProperty("id",is(1L))));
    }
    


    @Test
    void initCreationForm() throws Exception {
        mockMvc.perform(get("/owners/new/"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createUpdateOwner"))
                .andExpect(model().attributeExists("owner"));

        verifyNoInteractions(ownerServiceJpa);
    }

    @Test
    void processCreationForm() throws Exception {
        when(ownerServiceJpa.save(ArgumentMatchers.any())).thenReturn(Owner.builder().id(1l).build());

        mockMvc.perform(post("/owners/new/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1/"))
                .andExpect(model().attributeExists("owner"));

        verify(ownerServiceJpa).save(ArgumentMatchers.any());
    }

    @Test
    void initUpdateOwnerForm() throws Exception {
        when(ownerServiceJpa.findById(anyLong())).thenReturn(Owner.builder().id(1l).build());

        mockMvc.perform(get("/owners/1/edit/"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createUpdateOwner"))
                .andExpect(model().attributeExists("owner"));
        verifyNoMoreInteractions(ownerServiceJpa);

    }

    @Test
    void processUpdateOwnerForm() throws Exception {
        when(ownerServiceJpa.save(ArgumentMatchers.any())).thenReturn(Owner.builder().id(1l).build());

        mockMvc.perform(post("/owners/1/edit/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/1/"))
                .andExpect(model().attributeExists("owner"));

        verify(ownerServiceJpa).save(ArgumentMatchers.any());
    }

}
