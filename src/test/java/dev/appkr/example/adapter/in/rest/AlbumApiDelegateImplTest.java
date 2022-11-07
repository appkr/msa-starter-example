package dev.appkr.example.adapter.in.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import dev.appkr.example.adapter.in.rest.error.ExceptionTranslator;
import dev.appkr.example.config.Constants;
import dev.appkr.example.rest.AlbumApiController;
import dev.appkr.example.rest.AlbumApiDelegate;
import dev.appkr.example.support.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;
import org.springframework.web.filter.CharacterEncodingFilter;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AlbumApiDelegateImplTest {

  private MockMvc mvc;

  @Autowired private AlbumApiDelegate apiDelegate;
  @Autowired private ExceptionTranslator exceptionTranslator;
  @Autowired private MappingJackson2HttpMessageConverter jacksonMessageConverter;
  @Autowired private Validator validator;

  @Test
  @WithMockUser("user")
  void listAlbums() throws Exception {
    ResultActions res = mvc.perform(
        get("/api/albums").accept(Constants.V1_MEDIA_TYPE)
    ).andDo(print());

    res.andExpect(status().is2xxSuccessful());
  }

  @BeforeEach
  public void setup() {
    AlbumApiController controller = new AlbumApiController(apiDelegate);
    this.mvc = MockMvcBuilders.standaloneSetup(controller)
        .setControllerAdvice(exceptionTranslator)
        .setConversionService(TestUtils.createFormattingConversionService())
        .setMessageConverters(jacksonMessageConverter)
        .setValidator(validator)
        .addFilters(new CharacterEncodingFilter("utf-8", true))
        .build();
  }
}
