package cloud.network.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NetInterface {
    private String name;
    private String hw_addr;
    private List<String> inet_addr;
    private Integer mtu;
}
