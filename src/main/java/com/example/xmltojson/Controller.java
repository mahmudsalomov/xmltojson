package com.example.xmltojson;

import com.example.xmltojson.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @PostMapping("/json")
    public ResponseEntity json(@RequestBody Object student) throws JsonProcessingException {
        JacksonXmlModule module = new JacksonXmlModule();
//        ObjectMapper Obj = new ObjectMapper();
//        System.out.println(Obj.writeValueAsString(student));

        module.setDefaultUseWrapper(false);
        XmlMapper xmlMapper = new XmlMapper(module);
        final String xml = xmlMapper.writeValueAsString(student);



        System.out.println(student);
        System.out.println(student);
        System.out.println(xml);
        return ResponseEntity.ok(xml);
    }


    @PostMapping(value = "/xml", consumes= MediaType.APPLICATION_XML_VALUE,
            produces=MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity xml(@RequestBody Object studentXml) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();

        //        System.out.println(xmlMapper.readValue(studentXml));
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(studentXml);
        return ResponseEntity.ok(json);
    }

}
