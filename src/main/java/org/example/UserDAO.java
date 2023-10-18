package org.example;

public interface UserDAO {
    UserDTO getUserById(Long id);
    void createUser(UserDTO User);
    void updateUser(UserDTO User);
    void deleteUser(Long id);
}
