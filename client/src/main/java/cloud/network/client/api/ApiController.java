package cloud.network.client.api;

import cloud.network.client.model.ApiVersion;
import cloud.network.client.model.NetInterface;

import java.io.IOException;
import java.util.List;

public interface ApiController {

    ApiVersion getApiVersion() throws IOException;

    List<String> getInterfaceNames(String apiVersion) throws IOException;

    NetInterface getInterfaceDetails(String apiVersion, String name) throws IOException;

}
