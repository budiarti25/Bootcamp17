/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Region;
import java.util.List;

/**
 *
 * @author budiarti
 */
public interface RegionInterfaceController {
    public boolean save(String regionId, String regionName);
    public boolean edit(String regionId, String regionName);
    public boolean drop(int id);
    public List<Region> binding();
    public List<Region> bindingSort(String category, String sort);
    public List<Region> find(String category, String data);
    public Region findById(int id);
}
