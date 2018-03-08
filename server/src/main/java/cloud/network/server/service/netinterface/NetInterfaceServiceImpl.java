package cloud.network.server.service.netinterface;

import cloud.network.server.model.NetInterface;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Service
public class NetInterfaceServiceImpl implements NetInterfaceService {

    private final static boolean VIRTUAL_CHECK = false;

    @Override
    public NetInterface getInterfaceByName(String name) throws SocketException {
        List<NetInterface> interfaceList = interfaceInformation();
        for (NetInterface netInterface : interfaceList)
            if (name.equals(netInterface.getName())) return netInterface;

        return null;
    }

    @Override
    public List<String> getNames() throws SocketException {
        List<NetInterface> interfaceList = interfaceInformation();
        List<String> names = new ArrayList<>();
        for (NetInterface netInterface : interfaceList)
            names.add(netInterface.getName());

        return names;
    }


    public List<NetInterface> interfaceInformation() throws SocketException {
        List<NetInterface> interfaceList = new ArrayList<>();

        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();

            if (VIRTUAL_CHECK) {
                if (iface.isLoopback() || !iface.isUp() || iface.isVirtual() || iface.isPointToPoint())
                    continue;
            }

            StringBuilder sb = new StringBuilder();
            byte[] mac = iface.getHardwareAddress();
            if (mac != null) {
                for (int i = 0; i < mac.length; i++)
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : ""));
            }

            List<String> inet_addr = new ArrayList<>();
            Enumeration<InetAddress> addresses = iface.getInetAddresses();
            while (addresses.hasMoreElements())
                inet_addr.add(formatIPV6(addresses.nextElement().getHostAddress()));

            NetInterface netInterface = new NetInterface();
            netInterface.setName(iface.getName());
            netInterface.setInet_addr(inet_addr);
            netInterface.setHw_addr(sb.toString());
            netInterface.setMtu(iface.getMTU());

            interfaceList.add(netInterface);
        }

        return interfaceList;
    }

    public String formatIPV6(String s) {
        return s.indexOf('%') > 0 ? s.substring(0, s.indexOf('%')) : s;
    }

}
