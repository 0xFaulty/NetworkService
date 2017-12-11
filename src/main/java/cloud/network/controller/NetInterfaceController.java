package cloud.network.controller;

import cloud.network.model.ApiError;
import cloud.network.model.NetInterface;
import cloud.network.service.netinterface.NetInterfaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketException;
import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class NetInterfaceController {

    private final static Logger LOG = LoggerFactory.getLogger(NetInterfaceController.class);

    @Autowired
    private NetInterfaceService netInterfaceService;

    @RequestMapping(value = "/interfaces", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getInterfaceNames() {
        List<String> names;
        try {
            names = netInterfaceService.getNames();
            if (names != null)
                return new ResponseEntity<>(names, HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("error"));

        } catch (SocketException e) {
            LOG.error("netInterfaceService.getNames() error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError("error"));
        }

    }

    @RequestMapping(value = "/interfaces/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getInterfaceDetails(@PathVariable String name) {
        NetInterface netInterface;
        try {
            netInterface = netInterfaceService.getInterfaceByName(name);
            if (netInterface != null)
                return new ResponseEntity<>(netInterface, HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiError("interface " + name + " was not found"));
        } catch (SocketException e) {
            LOG.error("getInterfaceDetails(" + name + ") error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError("error"));
        }
    }

}


