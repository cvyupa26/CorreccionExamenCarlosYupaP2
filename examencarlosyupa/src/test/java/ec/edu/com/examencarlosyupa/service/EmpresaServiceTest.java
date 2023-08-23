package ec.edu.com.examencarlosyupa.service;

import ec.edu.com.examencarlosyupa.dto.EmpresaRQ;
import ec.edu.com.examencarlosyupa.model.Empleado;
import ec.edu.com.examencarlosyupa.model.Empresa;
import ec.edu.com.examencarlosyupa.repository.EmpresaRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmpresaServiceTest {
    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private EmpresaService empresaService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void empresaServiceTestCrearEmpresaSuccess(){
        Empleado mockEmpleado1 = new Empleado(
                "0000012547",
                "Yupa",
                "Carlos",
                "00368660"
        );
        Empleado mockEmpleado2 = new Empleado(
                "0000012548",
                "Silva",
                "Dayanna",
                "00368661"
        );
        List<Empleado> mockEmpleadosRQ = new ArrayList<>();
        mockEmpleadosRQ.add(mockEmpleado1);
        mockEmpleadosRQ.add(mockEmpleado2);

        EmpresaRQ mockEmpresaRQ = EmpresaRQ.builder()
                .ruc("1234567890")
                .razonsocial("Empresa 1")
                .cuenprincipal("1234567890")
                .empleados(mockEmpleadosRQ)
                .build();
        Empresa mockEmpresa = Empresa.builder()
                .ruc("1234567890")
                .razonsocial("Empresa 1")
                .cuenprincipal("1234567890")
                .empleados(mockEmpleadosRQ)
                .build();

        when(empresaRepository.save(any())).thenReturn(mockEmpresa);

        empresaService.crearEmpresa(mockEmpresaRQ);

        verify(empresaRepository, times(1)).save(mockEmpresa);
    }

    @Test
    public void empresaServiceCrearEmpresaFailure(){
        Empleado mockEmpleado1 = new Empleado(
                "0000012547",
                "Yupa",
                "Carlos",
                "00368660"
        );
        Empleado mockEmpleado2 = new Empleado(
                "0000012548",
                "Silva",
                "Dayanna",
                "00368661"
        );
        List<Empleado> mockEmpleadosRQ = new ArrayList<>();
        mockEmpleadosRQ.add(mockEmpleado1);
        mockEmpleadosRQ.add(mockEmpleado2);

        EmpresaRQ mockEmpresaRQ = EmpresaRQ.builder()
                .ruc("1234567890")
                .razonsocial("Empresa 1")
                .cuenprincipal("1234567890")
                .empleados(mockEmpleadosRQ)
                .build();

        when(empresaRepository.save(any())).thenThrow(new RuntimeException("Simulated force error"));

        Assertions.assertThrows(RuntimeException.class, () -> empresaService.crearEmpresa(mockEmpresaRQ));

    }


}
