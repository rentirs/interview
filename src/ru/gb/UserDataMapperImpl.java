package ru.gb;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Optional;

public class UserDataMapperImpl implements UserDataMapper {

    private List<User> users = new ArrayList<>();

    public IdentityHashMap getIdentityHashMap() {
        return identityHashMap;
    }

    private IdentityHashMap<Long, User> identityHashMap = new IdentityHashMap();

    @Override
    public Optional<User> find(int userId) {
        if (identityHashMap.containsKey(userId)){return Optional.of(identityHashMap.get(userId));}
        for (User user : this.getUsers()){
            if (user.getUserId() == userId){
                return Optional.of(user);
            }}      return Optional.empty();
    }

    @Override
    public void insert(User userToBeInserted) throws DataMapperException {
        if (!this.getUsers().contains(userToBeInserted)) {
            this.getUsers().add(userToBeInserted);
            this.getIdentityHashMap().put(userToBeInserted.getUserId(), userToBeInserted);
        }else {
            throw new DataMapperException("User [" + userToBeInserted.getName() + " is exists");
        }}

    @Override
    public void update(User userToBeUpdated) throws DataMapperException {
        if ((this.getUsers().contains(userToBeUpdated))) {
            int index = this.getUsers().indexOf(userToBeUpdated);
            this.getUsers().set(index, userToBeUpdated);

        } else { throw new DataMapperException("User [" + userToBeUpdated.getName() + "] is not found");
        }
    }

    @Override
    public void delete(User userToBeDeleted) throws DataMapperException {
        if (this.getUsers().contains(userToBeDeleted)) {
            this.getUsers().remove(userToBeDeleted);
            this.getIdentityHashMap().remove(userToBeDeleted.getUserId());
        } else {
            throw new DataMapperException("User [" + userToBeDeleted.getName() + "] is not found");
        }
    }

    public List<User> getUsers() {
        return users;
    }
}