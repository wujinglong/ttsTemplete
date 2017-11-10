package tts.service.impl;

import com.voicerss.tts.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tts.service.TTSService;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by wujl on 2017/11/9.
 */
@Service(value = "ttsService")
@Slf4j
public class TTSServiceImpl implements TTSService {

    private final static String MUSIC_FILE = "tts" + File.separator + "music" + File.separator + "word.wav";

    @Override
    public void TTS(String word) {
        VoiceProvider tts = new VoiceProvider("d91322df3dd94d248da9a2bb2555d823");

        VoiceParameters params = new VoiceParameters(word, Languages.Chinese_China);
        params.setCodec(AudioCodec.WAV);
        params.setFormat(AudioFormat.Format_8KHZ.AF_8khz_16bit_mono);
        params.setBase64(false);
        params.setSSML(Boolean.FALSE);
        params.setRate(0);
        log.info("start to convert, params: {}, word: {}", params.toString(), word);

        try {
            byte[] wordVoice = tts.speech(params);

            FileOutputStream outputStream = new FileOutputStream(MUSIC_FILE);
            outputStream.write(wordVoice, 0, wordVoice.length);
            outputStream.flush();
            outputStream.close();
            log.info("convert, over");
        } catch (Exception e) {
            log.info("get word voice take place error:{}", e.getMessage());
        }


    }
}