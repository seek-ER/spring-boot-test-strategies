package me.aikin.test.strategies.component;


import me.aikin.test.strategies.resource.AboutController;
import me.aikin.test.strategies.service.AboutService;
import me.aikin.test.strategies.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.hamcrest.Matchers.equalTo;

@ContextConfiguration(
    classes = {
        AboutService.class,
        UserService.class,
        AboutController.class
    })
public class AboutControllerTest extends ApiBaseTest<AboutController> {

    @Autowired
    private AboutController aboutController;

    @Override
    protected AboutController getApi() {
        return aboutController;
    }

    @Test
    public void should_return_correct_content_when_get_about() {
        given().

        when().
                get("/api/about").
        then().
                body(equalTo("aikin: about."));
    }
}
