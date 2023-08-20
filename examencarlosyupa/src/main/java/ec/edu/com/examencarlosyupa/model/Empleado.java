package ec.edu.com.examencarlosyupa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {

    private String cedulaIdentidad;
    private String apellidos;
    private String nombres;
    private String numeroDeCuenta;
}
