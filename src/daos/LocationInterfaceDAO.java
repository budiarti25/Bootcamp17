/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Location;
import java.util.List;

/**
 *
 * @author Gusma
 */
public interface LocationInterfaceDAO {
    public boolean insert(Location location);

    public boolean update(Location location);

    public boolean delete(int id);

    public List<Location> getAll();

    public List<Location> getAllCs(String category, String sort);

    public List<Location> search(String category, String data);

    public Location getById(int id);
}
