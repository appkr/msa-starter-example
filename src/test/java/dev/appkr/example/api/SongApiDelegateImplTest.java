package dev.appkr.example.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import dev.appkr.example.api.dummy.SongDetailDtoFactory;
import dev.appkr.example.api.dummy.SongDtoFactory;
import dev.appkr.example.api.error.ExceptionTranslator;
import dev.appkr.example.config.Constants;
import dev.appkr.example.service.SongService;
import dev.appkr.example.support.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
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
class SongApiDelegateImplTest {

  private MockMvc mvc;

  @Autowired private SongApiDelegate apiDelegate;
  @Autowired private ExceptionTranslator exceptionTranslator;
  @Autowired private MappingJackson2HttpMessageConverter jacksonMessageConverter;
  @Autowired @Qualifier("defaultValidator") private Validator validator;
  @MockBean private SongService songService;

  @Test
  @WithMockUser("user")
  public void testCreateSong() throws Exception {
    when(songService.createSong(any())).thenReturn(SongDtoFactory.create());

    ResultActions res = mvc.perform(
        post("/api/songs")
            .contentType(Constants.V1_MEDIA_TYPE)
            .content(TestUtils.convertObjectToString(SongDtoFactory.create()))
            .characterEncoding("utf-8")
    ).andDo(print());

    res.andExpect(status().is2xxSuccessful());
    res.andExpect(header().exists("Location"));
  }

  @Test
  @WithMockUser("user")
  public void testGetSong() throws Exception {
    when(songService.getSong(any())).thenReturn(SongDetailDtoFactory.create());

    ResultActions res = mvc.perform(
        get("/api/songs/1").accept(Constants.V1_MEDIA_TYPE)
    ).andDo(print());

    res.andExpect(status().is2xxSuccessful());
  }

  @BeforeEach
  public void setup() {
    SongApiController controller = new SongApiController(apiDelegate);
    this.mvc = MockMvcBuilders.standaloneSetup(controller)
        .setControllerAdvice(exceptionTranslator)
        .setConversionService(TestUtils.createFormattingConversionService())
        .setMessageConverters(jacksonMessageConverter)
        .setValidator(validator)
        .addFilters(new CharacterEncodingFilter("utf-8", true))
        .build();
  }
}
