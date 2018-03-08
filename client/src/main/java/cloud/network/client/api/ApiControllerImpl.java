package cloud.network.client.api;

import cloud.network.client.model.ApiVersion;
import cloud.network.client.model.NetInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ApiControllerImpl implements ApiController {

    private String baseAddress = "http://";
    private String serverAddress;
    private OkHttpClient client = new OkHttpClient();

    public ApiControllerImpl(String server, String port) {
        this.serverAddress = server + ":" + port;
    }

    private String getJSON(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    @Override
    public ApiVersion getApiVersion() throws IOException {
        String url = baseAddress + serverAddress + "/service/version";
        String json = getJSON(url);

        return new Gson().fromJson(json, ApiVersion.class);
    }

    @Override
    public List<String> getInterfaceNames(String apiVersion) throws IOException {
        String url = baseAddress + serverAddress + "/" + apiVersion + "/interfaces";
        String json = getJSON(url);
        Type listType = new TypeToken<ArrayList<String>>() {
        }.getType();

        return new Gson().fromJson(json, listType);
    }

    @Override
    public NetInterface getInterfaceDetails(String apiVersion, String name) throws IOException {
        String url = baseAddress + serverAddress + "/" + apiVersion + "/interfaces/" + name;
        String json = getJSON(url);

        return new Gson().fromJson(json, NetInterface.class);
    }

}
