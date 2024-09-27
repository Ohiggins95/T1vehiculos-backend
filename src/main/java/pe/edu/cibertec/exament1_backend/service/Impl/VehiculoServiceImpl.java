package pe.edu.cibertec.exament1_backend.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.exament1_backend.dto.VehiculoRequestDTO;
import pe.edu.cibertec.exament1_backend.service.VehiculoService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@Service
public class VehiculoServiceImpl implements VehiculoService {
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] buscarVehiculo(VehiculoRequestDTO vehiculoRequestDTO) throws IOException {

        String[] datosVehiculo = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            System.out.println("Archivo leído desde: " + resource.getFile().getAbsolutePath());

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                if (vehiculoRequestDTO.placa().equals(datos[0])) {
                    datosVehiculo = new String[5];
                    datosVehiculo[0] = datos[1]; // Marca
                    datosVehiculo[1] = datos[2]; // Modelo
                    datosVehiculo[2] = datos[3]; // Número de asientos
                    datosVehiculo[3] = datos[4]; // Precio
                    datosVehiculo[4] = datos[5]; // Color
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            datosVehiculo = null;
            throw new IOException(e);
        }


        return datosVehiculo;
    }

}
