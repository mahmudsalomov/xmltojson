package com.example.xmltojson.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JacksonXmlRootElement(localName = "StudentXml")
@XmlRootElement
public class StudentXml implements Serializable {
//    @XmlElement
    private Long id;
//    @XmlElement
    private String name;
//    @XmlElement
    private int course;
}
