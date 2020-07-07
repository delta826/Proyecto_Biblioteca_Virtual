


public class Document {
    public String name;
    public String autor;
    public String editorial;
    public String section;
    public int total;
    public int disponible;
    public boolean available;

    public Document(String name, String autor, String editorial, String section) {
        this.name = name;
        this.autor = autor;
        this.editorial = editorial;
        this.section = section;
        this.total = 1;
        this.disponible = 1;
        this.available = true;
    }

    
    public boolean prestar(){
        boolean prestado = false;
        if(isAvailable()){
            this.disponible--;
            prestado = true;
        }
        if(disponible==0) this.available = false;
        return prestado;
    }
    
    public boolean devolver(){
        boolean devuelto = false;
        if(disponible!=total){
            this.disponible++;
            devuelto = true;
            if(!isAvailable()) this.available = true;
        }
        return devuelto;
    }
    
    public void borrar(){
        if(total==0) return;
        this.total--;
        if(disponible!=0) this.disponible--;
        if(disponible==0) this.available = false;
    }
    
    //Getters
    public String getName() {
        return name;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getSection() {
        return section;
    }

    public int getTotal() {
        return total;
    }

    public int getDisp() {
        return disponible;
    }

    public boolean isAvailable() {
        return available;
    }


    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setDisp(int disponible) {
        this.disponible = disponible;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
}
