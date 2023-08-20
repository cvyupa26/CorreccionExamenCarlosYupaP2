package ec.edu.com.examencarlosyupa.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "empresa")
public class Empresa {
    @Id
    private String id;
    private String ruc;
    private String razonsocial;
    private String cuenprincipal;
    private List<Empleado> empleados;

}
