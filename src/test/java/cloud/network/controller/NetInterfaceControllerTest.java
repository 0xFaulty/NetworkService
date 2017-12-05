package cloud.network.controller;

import cloud.network.model.ApiVersion;
import cloud.network.service.netinterface.NetInterfaceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NetInterfaceControllerTest { //extends WebSecurityConfigurerAdapter {

    @Autowired
    private WebApplicationContext context;

//    @MockBean
//    private NetInterfaceService netInterfaceService;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test() {
//        mockMvc.perform(get())

//        this.restTemplate.getForEntity(
//                "/v1/interfaces", ApiVersion.class);
    }
}
