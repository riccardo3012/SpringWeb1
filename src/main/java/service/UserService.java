package service;

import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class UserService {
    private List<User> utente = new ArrayList<>();

    public List<User> getAllAuthors() {
        return this.utente;
    }

    public User save(User user) {
        Random rndm = new Random();
        user.setId(rndm.nextInt(1, 100));
        this.utente.add(user);
        return user;
    }

    public User findAuthorById(long id) {
        User foundUser = null;
        for (User user : this.utente) {
            if (user.getId() == id) {
                foundUser = user;
            }
        }
        return foundUser;
    }

    public User findByIdAndUpdate(int id, User user) {
        User foundUser = this.findAuthorById(id);
        foundUser.setId(id);
        foundUser.setNome(user.getNome());
        foundUser.setCognome(user.getCognome());
        foundUser.setEmail(user.getEmail());
        foundUser.setDataNascita(user.getDataNascita());
        foundUser.setAvatar(user.getAvatar());
        return foundUser;

    }

    public void findByIdAndDelete(long id) {
        ListIterator<User> iterator = this.utente.listIterator();
        while (iterator.hasNext()) {
            User current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();

            }
        }
    }
}
