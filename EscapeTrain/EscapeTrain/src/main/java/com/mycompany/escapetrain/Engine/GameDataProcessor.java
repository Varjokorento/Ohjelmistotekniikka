/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.escapetrain.Engine;

import com.mycompany.escapetrain.GameObjects.Area.Area;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class GameDataProcessor {
    
    public static Map<Integer, Area> initializeAreas(){
       Map<Integer,Area> areas = new HashMap<>();
       try (Scanner areaReader = new Scanner(new File("C:\\Users\\Administrator\\ohte\\EscapeTrain\\EscapeTrain\\src\\main\\resources\\assets\\data\\areas\\areas.dat"))) {
            while (areaReader.hasNextLine()) {
                String areaName = areaReader.nextLine();
                Integer index = Integer.valueOf(areaReader.nextLine());
                String description = areaReader.nextLine();
                String indexList = areaReader.nextLine();
                List<Integer> borderingAreas = parseBorderingAreas(indexList);
              //  areas.put(index, new Area(areaName, description, borderingAreas));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
       return areas;
    }

    private static List<Integer> parseBorderingAreas(String indexList) {
          List<Integer> borderingAreas = new ArrayList<>();
          String[] borderAreas = indexList.split(",");
                for (int i = 0; i < borderAreas.length; i++) {
                    borderingAreas.add(Integer.parseInt(borderAreas[i]));
          }
          return borderingAreas;      
    }
    
    
}
