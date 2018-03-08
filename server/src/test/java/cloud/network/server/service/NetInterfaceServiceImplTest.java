package cloud.network.server.service;

import cloud.network.server.model.NetInterface;
import cloud.network.server.service.netinterface.NetInterfaceServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.net.SocketException;
import java.util.List;

public class NetInterfaceServiceImplTest {

    @Test
    public void displayTest() throws SocketException {
        NetInterfaceServiceImpl interfaceService = new NetInterfaceServiceImpl();
        List<NetInterface> interfaces = interfaceService.interfaceInformation();
    }

    @Test
    public void formatTest() {
        NetInterfaceServiceImpl interfaceService = new NetInterfaceServiceImpl();
        String s = "11:21:11:33:22:ad:11:55%eth2";
        Assert.assertEquals("11:21:11:33:22:ad:11:55", interfaceService.formatIPV6(s));
    }

}