package src;

public class Atributo {
    private String nombre;
    private int valor;

    public Atributo(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        
        Atributo atributo = (Atributo) o;
        return nombre.equals(atributo.getNombre());
    }

}
