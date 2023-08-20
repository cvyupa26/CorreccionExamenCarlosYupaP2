package ec.edu.com.examencarlosyupa.dto;

import java.util.List;

import ec.edu.com.examencarlosyupa.model.Empleado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresaRQ {
    
private String ruc;
private String razonsocial;
private String cuenprincipal;
private List<Empleado> empleados;
    
}
