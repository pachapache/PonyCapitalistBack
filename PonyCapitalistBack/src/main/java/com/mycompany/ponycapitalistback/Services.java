package com.mycompany.ponycapitalistback;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import generated.World;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chaum
 */
public class Services {
    
    /////////////////// Version SANS utilisateur ///////////////////

    public World readWorldFromXml() throws JAXBException {
        JAXBContext cont = JAXBContext.newInstance(World.class);
        Unmarshaller u = cont.createUnmarshaller();
        World world;
        try {
            world = (World) u.unmarshal(new File("world.xml"));
        } catch (JAXBException e) {
            InputStream input = getClass().getClassLoader().getResourceAsStream("world.xml");
            world = (World) u.unmarshal(input);
            System.out.println(e.getMessage());
        }
        return world;
    }
     
    public void saveWorldToXml(World world) {
        try {
            OutputStream output = new FileOutputStream("world.xml");
            JAXBContext cont = JAXBContext.newInstance(World.class);
            Marshaller m = cont.createMarshaller();
            m.marshal(world, output);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     
    public World getWorld() throws JAXBException {
        World world = readWorldFromXml();
        saveWorldToXml(world);
        return world;
    }
    
    /////////////////////////////////////////////////////////
    
   
}