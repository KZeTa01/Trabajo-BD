public class Clientes {
    private String nombres;
    private String correo;
    private String telefono;
    private String ciudad;

    public Clientes() {
    }

    public Clientes(String nombres, String correo, String telefono, String ciudad) {
        this.nombres = nombres;
        this.correo = correo;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (validarTelefono(telefono)) {
            this.telefono = telefono;
        } else {
            this.telefono = "";
        }
    }

    public boolean validarTelefono(String telefono) {
        boolean valido = false;

        if (telefono != null) {
            if (telefono.length() >= 9 && telefono.length() <= 10) {
                valido = true;
            }
        }

        if (valido) {
            for (int i = 0; i < telefono.length(); i++) {
                if (!Character.isDigit(telefono.charAt(i))) {
                    valido = false;
                }
            }
        }

        return valido;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
