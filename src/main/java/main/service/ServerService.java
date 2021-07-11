package main.service;

import main.dto.EntityResponse;
import main.dto.ServerDto;
import main.model.Server;
import main.repository.AvailableServiceRepository;
import main.repository.ServerRepository;
import main.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private AvailableServiceRepository availableServiceRepository;

    @Autowired
    private UserRepository userRepository;

    public EntityResponse saveServer(final ServerDto serverDto) {
        Server serverSaved;
        EntityResponse entityResponse;
        try {
            Server newServer = Server.builder().active(serverDto.getActive())
                    .duration(serverDto.getDuration())
                    .price(serverDto.getPrice())
                    .active(serverDto.getActive() == null || serverDto.getActive())
                    .user(userRepository.getById(serverDto.getUserId()))
                    .availableService(availableServiceRepository.getById(serverDto.getAvailableServiceId()))
                    .build();
            serverSaved = serverRepository.save(newServer);
            serverDto.setId(serverSaved.getId());
            entityResponse = EntityResponse.builder().entity(serverDto).statusCode(HttpStatus.OK).build();
        } catch ( Exception e) {
            entityResponse = EntityResponse.builder().statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                    .error("Error registrando servicio")
                    .build();
        }
        return entityResponse;
    }
}
