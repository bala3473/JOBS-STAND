package emp.enq.dao;

import emp.enq.models.ProfilePicture;

public interface ProfilePictureDao {
void saveOrUpdateProfilePicture(ProfilePicture profilePicture);
//insert into profilepicture values (email,image) or
//update profilepicture set image=? where email=?

ProfilePicture  getProfilePicture(String email);
}
