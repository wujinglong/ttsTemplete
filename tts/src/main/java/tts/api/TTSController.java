package tts.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tts.service.TTSService;

/**
 * Created by wujl on 2017/11/9.
 */
@RestController
@RequestMapping("api")
public class TTSController {

    @Autowired
    private TTSService ttsService;

    @RequestMapping(value = "tts", method = RequestMethod.POST)
    public void tts(@RequestParam String word) {
        ttsService.TTS(word);
    }
}
