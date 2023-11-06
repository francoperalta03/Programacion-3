class Nodo {
    private int contenido;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

    public Nodo(int contenido) {
        this.contenido = contenido;
    }

    public int contenido() {
        return contenido;
    }

    public Nodo hijoIzquierdo() {
        return hijoIzquierdo;
    }

    public Nodo hijoDerecho() {
        return hijoDerecho;
    }

    public void establecerHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void establecerHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public boolean esHoja() {
        return (hijoIzquierdo == null && hijoDerecho == null);
    }

    @Override
    public String toString() {
        return String.valueOf(contenido);
    }
}