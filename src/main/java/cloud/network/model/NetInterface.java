package cloud.network.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public @Data
class NetInterface {
    private String name;
    private String hw_addr;
    private List<String> inet_addr;
    private Integer mtu;
}
