import gui.Constants;
import java.util.*;
import java.util.stream.Collectors;



public class DroneBase {
    private final Map<String, Object> droneDetails;
    private final Map<String, Object> droneTypeInfo;
    private final List<Map<String, Object>> droneDynamicsInfo;
    private Map<String, Object> droneLatestData;

    public DroneBase(Map<String, Object> droneDetails, Map<String, Object> droneTypeInfo, List<Map<String, Object>> droneDynamicsInfo) {
        this.droneDetails = droneDetails;
        this.droneTypeInfo = droneTypeInfo;
        this.droneDynamicsInfo = droneDynamicsInfo;
    }

    public void updateLatestData() {
        List<Map<String, Object>> dynamicsInfo = getDroneDynamicsInfo();
        if (!dynamicsInfo.isEmpty()) {
            dynamicsInfo.sort(Comparator.comparing(d -> (String) d.get(Constants.TIMESTAMP)));
            Collections.reverse(dynamicsInfo);
            this.droneLatestData = dynamicsInfo.get(0);
        }
    }

    /**
     * @return a Map containing drone details. Returns Empty Map if there are no details.
     */
    public Map<String, Object> getDroneDetails() {
        return droneDetails != null ? Collections.unmodifiableMap(droneDetails) : Collections.emptyMap();
    }

    /**
     * @return a Map containing drone type information. Returns null if there is no type information.
     */
    public Map<String, Object> getDroneTypeInfo() {
        return droneTypeInfo != null ? Collections.unmodifiableMap(droneTypeInfo) : Collections.emptyMap();
    }

    /**
     * @return List of Map objects containing drone dynamics.
     * Empty List if there is no dynamics.
     */
    public List<Map<String, Object>> getDroneDynamicsInfo() {
        return droneDynamicsInfo != null ? droneDynamicsInfo.stream().map(HashMap::new).collect(Collectors.toList()) : Collections.emptyList();
    }

    /**
     * @return Map containing the latest drone data. Empty Map if there is no data.
     */
    public Map<String, Object> getDroneLatestData() {
        return droneLatestData != null ? Collections.unmodifiableMap(droneLatestData) : Collections.emptyMap();
    }
}