package Utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDetails {
    public void CreateDetails() throws JsonProcessingException
    {
        Details det = new Details();
        det.setUsername("Yogesh");
        det.setJob("Mechanical Engineer");
        det.setEmailId("yogi12@gmail.com");

        ObjectMapper objmapper = new ObjectMapper();
        String userJSON = objmapper.writeValueAsString(det);
        System.out.println(userJSON);

    }
}
