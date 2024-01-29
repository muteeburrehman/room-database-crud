package pk.codebase.roomdatabasecrud;

import pk.codebase.roomdatabasecrud.Room.Users;

public interface AdapterListener {

    void OnUpdate(Users users);
    void OnDelete(int id, int pos);
}
