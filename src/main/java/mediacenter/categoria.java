/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediacenter;
 
public class categoria {
    
    private String nome;
    private Integer id;
    
    public categoria() {
        nome="";
        id=0;
    }
    
    public categoria(String nome1, Integer id1) {
        nome = nome1;
        id = id1;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Integer getID() {
        return id;
    }
    
}
