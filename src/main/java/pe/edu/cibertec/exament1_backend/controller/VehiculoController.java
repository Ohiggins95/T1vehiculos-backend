package pe.edu.cibertec.exament1_backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.exament1_backend.dto.VehiculoRequestDTO;
import pe.edu.cibertec.exament1_backend.dto.VehiculoResponseDTO;
import pe.edu.cibertec.exament1_backend.service.VehiculoService;

import java.io.IOException;

@RestController
@RequestMapping("/inicio")
public class VehiculoController {


    @Autowired
    VehiculoService vehiculoService;

    @PostMapping("/buscar")
    public VehiculoResponseDTO buscar(@RequestBody VehiculoRequestDTO vehiculoRequestDTO) {
        try {
            String[] datosBusqueda = vehiculoService.buscarVehiculo(vehiculoRequestDTO);
            if (datosBusqueda == null) {
                return new VehiculoResponseDTO("01", "Error: Ocurrió un problema", 
                        "", "", "", "", "");

            }
            return new VehiculoResponseDTO("00", "Correcto: Vehiculo encontrado", datosBusqueda[0],
                    datosBusqueda[1] , datosBusqueda[2], datosBusqueda[3], datosBusqueda[4]);

        } catch (IOException e) {
            return new VehiculoResponseDTO("99", "Error: Ocurrió un problema",
                    "", "" , "", "", "");
        }


    }}
