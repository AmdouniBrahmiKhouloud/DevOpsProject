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

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ReglementServiceTest {
    @Mock
    ReglementRepository reglementRepository;

    @InjectMocks
    ReglementServiceImpl reglementServiceImpl;

    Reglement reglement = new Reglement(1L,11,1,true);
    List<Reglement> listReglements = new ArrayList<Reglement>() {
        {
            add(new Reglement(2L,12,2,true));
            add(new Reglement(3L,13,3,true)));
        }
    };

    @Test
    public void testRetrieveReglement() {
        when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(reglement));
        Reglement reglement1 = reglementServiceImpl.retrieveReglement(Long.valueOf(1));
        assertNotNull(reglement1);
        verify(reglementRepository).findById((Long) any());

    }
//
//
//    @Test
//    void testAddOperateur() {
//        Operateur operateur = new Operateur();
//        operateur.setIdOperateur(10L);
//        operateur.setNom("op1");
//        operateur.setPassword("123");
//        operateur.setPrenom("pre1");
//        when(operateurRepository.save(any())).thenReturn(operateur);
//        assertSame(operateur, operateurServiceImpl.addOperateur(operateur));
//        assertNotNull(operateur.getIdOperateur());
//        verify(operateurRepository).save(any());
//    }
//
//
//    @Test
//    void testRetrieveAllOperateurs() {
//        List<Operateur> actualRetrieveAllOperateursResult = this.operateurServiceImpl.retrieveAllOperateurs();
//        Assertions.assertEquals(0, actualRetrieveAllOperateursResult.size());
//        verify(operateurRepository).findAll();
//
//    }
//
//    @Test
//    void testDeleteOperateur() {
//        Operateur operateur = new Operateur();
//        operateur.setIdOperateur(10L);
//        operateur.setNom("op1");
//        operateur.setPassword("123");
//        operateur.setPrenom("pre1");
//        doNothing().when(operateurRepository).deleteById((Long) any());
//        operateurServiceImpl.deleteOperateur(operateur.getIdOperateur());
//        verify(operateurRepository).deleteById((Long) any());
//    }


}