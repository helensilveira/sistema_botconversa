package com.server.stabilityAI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.server.utils.types.botconversaChatFileResponse;
import com.server.utils.types.botconversaChatRequestBody;
import java.util.List;
import java.util.Map;

// Make sure to set the STABILITY_API_KEY environment variable in application.properties

@RestController
public class StabilityAIController {
  @Autowired
  private StabilityAIService stabilityAIService;

  @PostMapping("/stability-text-to-image")
  public botconversaChatFileResponse textToImage(@RequestBody botconversaChatRequestBody requestBody) throws Exception {
    return this.stabilityAIService.textToImage(requestBody);
  }

  @PostMapping("/stability-image-to-image")
  public botconversaChatFileResponse imageToImage(
    @RequestPart("files") List<MultipartFile> files,
    @RequestParam Map<String, String> formDataProperties) throws Exception {
    return this.stabilityAIService.imageToImage(files, formDataProperties);
  }

  @PostMapping("/stability-image-upscale")
  public botconversaChatFileResponse imageToImageUpscale(@RequestPart("files") List<MultipartFile> files) throws Exception {
    return this.stabilityAIService.imageToImageUpscale(files);
  }
}
