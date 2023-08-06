package com.rui.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.rui.library.Controller.CampusController;
import com.rui.library.Models.Campus;
import com.rui.library.Repositories.CampusRepository;


public class CampusControllerTest {

    @InjectMocks
    private CampusController underTest;

    @Mock
    private CampusRepository campusRepository;

    @Mock
    private Campus campus1;
    @Mock
    private Campus campus2;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldReturnAllCampuses() {
        Collection<Campus> allCampuses = Arrays.asList(campus1, campus2);
        when(campusRepository.findAll()).thenReturn(allCampuses);
        underTest.displayCampuses(model);
        verify(model).addAttribute("campuses", allCampuses);
    }

    @Test
    public void shouldAddNewCampus(){
        underTest.addCampus("Cleveland");
        verify(campusRepository).save(new Campus("Cleveland"));
    }

    @Test
    public void shouldAddCampusAndRedirect(){
        String results = underTest.addCampus("Cleveland");
        assertEquals("redirect:campuses",results);
    }
}
