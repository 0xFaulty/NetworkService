package cloud.network.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiVersion {
    private String version;

    @Override
    public String toString() {
        return "version = '" + version + "'";
    }

}
