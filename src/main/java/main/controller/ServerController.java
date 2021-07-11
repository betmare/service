package main.controller;

import main.dto.EntityResponse;
import main.dto.ServerDto;
import main.service.ServerService;
import main.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/server")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseEntity<Object> registerServer(@RequestBody ServerDto server) {
        EntityResponse serverResponse = serverService.saveServer(server);

        return ResponseUtil.buildResponse(serverResponse.getEntity(), serverResponse.getStatusCode(), serverResponse.getError());
    }
}
