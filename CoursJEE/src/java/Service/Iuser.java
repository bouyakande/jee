/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Utilisateur;

/**
 *
 * @author ghost
 */
public interface Iuser {
    public Utilisateur FindUser(String log,String password);
    
}
