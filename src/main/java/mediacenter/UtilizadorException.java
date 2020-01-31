/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter;

/**
 *
 * @author Utilizador
 */
public class UtilizadorException extends Exception{
    public UtilizadorException(String aviso) {
        super(aviso);
    }

    public UtilizadorException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
