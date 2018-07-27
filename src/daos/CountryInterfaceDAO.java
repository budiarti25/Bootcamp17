/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Country;
import entities.Region;
import java.util.List;

/**
 *
 * @author budiarti
 */
public interface CountryInterfaceDAO {
    public boolean insert(Country country);
    public boolean update(Country country);
    public boolean delete(String id);
    public List<Country> getAll();
    public List<Country> getAllSort(String category, String sort);
    public List<Country> search(String category, String data);
    public Country getById(int id);
//    public Region getRegId(int id);
    
}
