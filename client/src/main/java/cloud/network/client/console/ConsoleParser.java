package cloud.network.client.console;

import cloud.network.client.api.ApiController;
import cloud.network.client.api.ApiControllerImpl;
import cloud.network.client.model.ApiVersion;
import cloud.network.client.model.NetInterface;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ConnectException;
import java.util.List;

public class ConsoleParser {

    private final static Logger LOG = LoggerFactory.getLogger(ConsoleParser.class);
    private Options options = new Options();

    public ConsoleParser() {
        Option address = new Option("s", "server", true, "api server address");
        address.setRequired(true);
        options.addOption(address);

        Option port = new Option("p", "port", true, "api server port");
        port.setRequired(true);
        options.addOption(port);

        Option help = new Option("h", "help", false, "usage info");
        help.setRequired(false);
        options.addOption(help);

        Option version = new Option("v", "version", false, "version info");
        version.setRequired(false);
        options.addOption(version);

        Option show = new Option("show", "show", true, "get interface details");
        show.setRequired(false);
        options.addOption(show);

        Option list = new Option("l", "list", false, "get interface list");
        list.setRequired(false);
        options.addOption(list);
    }

    public void parse(String[] args) {
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cl;

        try {
            cl = parser.parse(options, args);

            String server = cl.getOptionValue("s");
            String port = cl.getOptionValue("p");

            if (server != null && port != null) {
                if (cl.hasOption("v")) {
                    version(server, port);
                    return;
                }
                if (cl.hasOption("list")) {
                    list(server, port);
                    return;
                }
                if (cl.hasOption("show")) {
                    String name = cl.getOptionValue("show");
                    show(name, server, port);
                }
            }
        } catch (UnrecognizedOptionException e) {
            LOG.info("Error: Unrecognized option");
            formatter.printHelp("cli_net ", options);
        } catch (ParseException e) {
            LOG.error("Error while parse options", e);
        } catch (ConnectException e) {
            LOG.info("Can't connect to server");
        } catch (IOException e) {
            LOG.error("Error while perform command", e);
        }
    }

    private void version(String server, String port) throws IOException {
        ApiController apiController = new ApiControllerImpl(server, port);
        ApiVersion version = apiController.getApiVersion();
        System.out.println(version);
    }

    private void show(String name, String server, String port) throws IOException {
        ApiController apiController = new ApiControllerImpl(server, port);
        ApiVersion version = apiController.getApiVersion();
        NetInterface netInterface = apiController.getInterfaceDetails(version.getVersion(), name);
        System.out.println(netInterface);
    }

    private void list(String server, String port) throws IOException {
        ApiController apiController = new ApiControllerImpl(server, port);
        ApiVersion version = apiController.getApiVersion();
        List<String> nameList = apiController.getInterfaceNames(version.getVersion());
        System.out.println(nameList);
    }

}
