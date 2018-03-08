package cloud.network.client.model;

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

    @Override
    public String toString() {
        return name + ":\t Hw_addr: " + hw_addr + '\n'
                + "\t inet_addr=" + inet_addr + '\n'
                + "\t MTU:" + mtu;
    }

}
