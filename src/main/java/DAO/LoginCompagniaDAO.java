package DAO;

import Model.Compagnia;


public interface LoginCompagniaDAO {
    public Compagnia loginCompagniaDB(String email, String password);
}
