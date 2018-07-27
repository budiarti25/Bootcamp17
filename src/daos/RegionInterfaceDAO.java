/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import entities.Region;
import java.util.List;
/**
 *
 * @author Budiarti
 */
public interface RegionInterfaceDAO {
    public boolean insert(Region region);
    public boolean update(Region region);
    public boolean delete(int id);
    public List<Region> getAll();
    public List<Region> getAllSort(String category, String sort);
    public List<Region> search(String category, String data);
    public Region getById(int id);
}
