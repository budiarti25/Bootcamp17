/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Location;
import java.util.List;

/**
 *
 * @author Gusma
 */
public interface LocationInterfaceController {
    public boolean save(String locationId, String streetAddress ,String postalCode, String city,String stateProvince, String countryId );

    public boolean edit(String locationId, String streetAddress ,String postalCode, String city,String stateProvince, String countryId );

    public boolean drop(int id);

    public List<Location> binding();

    public List<Location> bindingsort(String category, String sort);

    public List<Location> find(String category, String data);

    public Location findById(int id);
}
