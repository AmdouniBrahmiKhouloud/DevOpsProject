package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ReglementServiceTest {
    @Mock
    ReglementRepository reglementRepository;

    @InjectMocks
    ReglementServiceImpl reglementServiceImpl;

    Reglement reglement = new Reglement(1L,11.1f,1.1f,true);
    List<Reglement> listReglements = new ArrayList<Reglement>() {
        {
            add(new Reglement(2L,12.0f,2.0f,true));
            add(new Reglement(3L,13.0f,3.0f,true));
        }
    };

    @Test
    public void testRetrieveReglement() {
        when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(reglement));
        Reglement reglement1 = reglementServiceImpl.retrieveReglement(Long.valueOf(1));
        assertNotNull(reglement1);
        verify(reglementRepository).findById((Long) any());

    }


    @Test
    void testAddOperateur() {
        Reglement reglement = new Reglement();
        reglement.setIdReglement(10L);
        reglement.setMontantPaye(15.2f);
        reglement.setMontantRestant(13.2f);
        reglement.setPayee(true);
        when(reglementRepository.save(any())).thenReturn(reglement);
        assertSame(reglement, reglementServiceImpl.addReglement(reglement));
        assertNotNull(reglement.getIdReglement());
        verify(reglementRepository).save(any());
    }


    @Test
    void testRetrieveAllReglements() {
        List<Reglement> actualRetrieveAllReglementsResult = this.reglementServiceImpl.retrieveAllReglements();
        Assertions.assertEquals(0, actualRetrieveAllReglementsResult.size());
        verify(reglementRepository).findAll();

    }

    @Test
    void testDeleteReglement() {
        Reglement reglement = new Reglement();
        reglement.setIdReglement(10L);
        reglement.setIdReglement(10L);
        reglement.setMontantPaye(15.2f);
        reglement.setMontantRestant(13.2f);
        reglement.setPayee(true);
        doNothing().when(reglementRepository).deleteById((Long) any());
        reglementServiceImpl.deleteReglement(reglement.getIdReglement());
        verify(reglementRepository).deleteById((Long) any());
    }


}