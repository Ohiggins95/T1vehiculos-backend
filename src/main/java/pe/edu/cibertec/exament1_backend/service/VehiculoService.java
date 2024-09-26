package pe.edu.cibertec.exament1_backend.service;

import pe.edu.cibertec.exament1_backend.dto.VehiculoRequestDTO;

import java.io.IOException;

public interface VehiculoService {
    String[] buscarVehiculo(VehiculoRequestDTO vehiculoRequestDTO)
            throws IOException;

}
