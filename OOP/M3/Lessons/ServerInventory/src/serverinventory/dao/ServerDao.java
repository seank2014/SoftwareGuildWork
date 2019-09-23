/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverinventory.dao;

import java.util.List;
import java.util.Map;
import serverinventory.dto.Server;

/**
 *
 * @author seanking
 */
public interface ServerDao {
    
    public void addServer (Server server);
    public Server getServer(String name);
    public void removerServer(String name);
    public List<Server> getAllServers();
    public Map <String, List<Server>> getAllServersGroupByManufactuer();
    public List <Server> getSAerversByManufacturer(String manfactuer);
    public List <Server> getServersOlderThan(int ageInYears);
    public Map<String, List<Server>> getSeversOlderThanGroupByManufactuer (int ageInYears);
    public double getAverageServerAge();
    
    
    
}
