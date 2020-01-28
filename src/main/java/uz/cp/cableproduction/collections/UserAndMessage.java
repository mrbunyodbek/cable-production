package uz.cp.cableproduction.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.cp.cableproduction.db.entities.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAndMessage {

    private User user;

    private String message;

}
