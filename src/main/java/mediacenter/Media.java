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
public class Media {
    private String nome;
    private String tempo;
    private String autor;
    private String tamanho;
    private String formato;
    private String diretoria;
    private String uploadedBy;
    private String added;
    private String categoria; 
   
    private Integer id;
    
    public Media() {
        nome ="";
        tempo="";
        autor="";
        tamanho="";
        formato="";
        diretoria="";
        uploadedBy="";
        added="";
        categoria="";
      
        id = 0;
   
    }
    public Media(String nome1, String tempo1, String autor1, String tamanho1, String formato1, String diretoria1, String uploadedBy1, String added1, String categoria1, Integer id1) {
        nome = nome1;
        tempo = tempo1;
        autor = autor1;
        tamanho = tamanho1;
        formato = formato1;
        diretoria = diretoria1;
        uploadedBy = uploadedBy1;
        added = added1;
        categoria = categoria1;
        id = id1;
    }
    
    
    public String getNome() {
        return nome;
    }

    /**
     * 
     * @param nome
     */
    public void setNome(String nome) {
            this.nome = nome;
    }
 
    public String getFormat() {
            return this.formato;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public String getAutor() {
        return autor;
    }

    /**
     * 
     * @param format
     */
    public void setFormat(String format) {
            this.formato = format;
    }

    public String getTempo() {
            return this.tempo;
    }

    /**
     * 
     * @param tempo
     */
    public void setTempo(String tempo) {
            this.tempo = tempo;
    }

    public String getUploadedBy() {
            return this.uploadedBy;
    }

    /**
     * 
     * @param uploadedBy
     */
    public void setUploadedBy(String uploadedBy) {
            this.uploadedBy = uploadedBy;
    }
    
    
    /**
     * 
     * @param autor
     */
    public void setAutor(String autor) {
            this.autor = autor;
    }    
    
        /**
     * 
     * @param tamanho
     */
    public void setTamanho(String tamanho) {
            this.tamanho = tamanho;
    }
    
    
    
     /**
     * 
     * @param formato
     */
    public void setFormato(String formato) {
            this.formato = formato;
    }
    
 
     /**
     * 
     * @param diretoria
     */
    public void setDiretoria(String diretoria) {
            this.diretoria = diretoria;
    }
    
    
     /**
     * 
     * @param added
     */
    public void setAdded(String added) {
            this.added = added;
    }
    
    
     /**
     * 
     * @param categoria
     */
    public void setCategoria(String categoria) {
            this.categoria = categoria;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getDiretoria() {
        return diretoria;
    }

    public String getAdded() {
        return added;
    }

    public Integer getID() {
        return id;
    }

    public void setID(int id1) {
        
        id = id1;
    }
}
