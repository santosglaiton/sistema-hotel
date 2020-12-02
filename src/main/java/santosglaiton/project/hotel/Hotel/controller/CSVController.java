package santosglaiton.project.hotel.Hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import santosglaiton.project.hotel.Hotel.helper.CSVReader;
import santosglaiton.project.hotel.Hotel.message.ResponseMessage;
import santosglaiton.project.hotel.Hotel.service.CSVService;

@Controller
@RequestMapping("api/csv")
public class CSVController {

    @Autowired
    CSVService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (CSVReader.temFormatoCsv(file)){
            try{
                fileService.save(file);
                message = "Arquivo upado com sucesso: " + file.getOriginalFilename();
                String fileDonwloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/api/csv/download")
                        .path(file.getOriginalFilename())
                        .toUriString();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message, fileDonwloadUri));
            }catch (Exception e){
                message = "Falha ao fazer upload do arquivo: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message, ""));
            }
        }
        message = "Por favor adiciona um arquivo CSV!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message, message));
    }

}
