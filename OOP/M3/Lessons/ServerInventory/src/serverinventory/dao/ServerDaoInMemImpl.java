/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverinventory.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import serverinventory.dto.Server;

/**
 *
 * @author seanking
 */
public class ServerDaoInMemImpl implements ServerDao {
    
    private Map<String, Server> serverMap = new HashMap<>();
    

    @Override
    public void addServer(Server server) {
        serverMap.put(server.getName(), server);
    }

    @Override
    public Server getServer(String name) {
        return serverMap.get(name);

    }

    @Override
    public void removerServer(String name) {
        serverMap.remove(name);
    }

    @Override
    public List<Server> getAllServers() {
        return new ArrayList<Server>(serverMap.values());

    }

    @Override
    public Map<String, List<Server>> getAllServersGroupByManufactuer() {
      return  serverMap.values()
                .stream()
                .collect(Collectors.groupingBy(Server::getManufactuer));
    }

    @Override
    public List<Server> getSAerversByManufacturer(String manfactuer) {
        return serverMap.values()
                .stream()
                .filter(s -> s.getManufactuer().equalsIgnoreCase(manfactuer))
                .collect(Collectors.toList());
                
    }

    @Override
    public List<Server> getServersOlderThan(int ageInYears) {
        return serverMap.values()
                .stream()
                .filter(s -> s.getServerAge() > ageInYears)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Server>> getSeversOlderThanGroupByManufactuer(int ageInYears) {
        return serverMap.values()
                .stream()
                .filter(s -> s.getServerAge() > ageInYears)
                .collect(Collectors.groupingBy(Server :: getManufactuer));
    }

    @Override
    public double getAverageServerAge() {
        return serverMap.values()
               .stream()
               .mapToLong(Server :: getServerAge)
               .average()
               .getAsDouble();
    }
    
}
