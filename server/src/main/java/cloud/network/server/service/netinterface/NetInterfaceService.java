package cloud.network.server.service.netinterface;

import cloud.network.server.model.NetInterface;

import java.net.SocketException;
import java.util.List;

public interface NetInterfaceService {

    NetInterface getInterfaceByName(String name) throws SocketException;

    List<String> getNames() throws SocketException;

}
