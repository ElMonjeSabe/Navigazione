package DAO;

import Model.Passeggero;

public interface loginPasseggeroDAO {

    public Passeggero loginPasseggeroDB(String email, String password);
}
