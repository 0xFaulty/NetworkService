package cloud.network.service.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    final static Logger LOG = LoggerFactory.getLogger(ApiServiceImpl.class);

    @Override
    public String getVersion() {
        return "v1";
    }

}
