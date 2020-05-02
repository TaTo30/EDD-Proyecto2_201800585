
package Controlador;

import Modelos.*;
import Vista.Formulario;
import Vista.Login;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import javax.swing.JOptionPane;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class Controlador {
    
    private final AVLTree<Categorias> categorias;
    private final HashTable<Usuario> usuarios;
    private Usuario logeado;

    
    
    public Controlador(){
        this.usuarios = new HashTable<>(45);
        this.categorias = new AVLTree<>();
        Usuario Predeterminado = new Usuario(100000000,"Predeterminado","Predeterminado","Predeterminado","Predeterminado");
        usuarios.Insertar(100000000, Predeterminado);
    }
    
    public Usuario ObtenerLogeado(){
        return this.logeado;
    }
    
    public boolean CargaLibro(String path){
        try{
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(new FileReader(path));
            JSONArray array = (JSONArray) json.get("libros");
            array.forEach(temp -> ParseLibro((JSONObject) temp));
            return true;
        }catch(IOException | ParseException e){
            JOptionPane.showMessageDialog(null, e, "Ha ocurrido un error en la carga de datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean CargaLibro(int ISBN, String titulo, String Autor, String Editorial, int Ano, int Edicion, String Categoria, String Idioma){
        if (categorias.Check(Categoria.charAt(0))) {
            //si existe la categoria añadimos
            if (ObtenerLibro(ISBN) == null) {
                //si no existe el ISBN, añadimos
                Libro temp = new Libro(ISBN, titulo, Autor, Editorial, Ano, Edicion, Categoria, Idioma, logeado.getCarnet());
                categorias.Find(Categoria.charAt(0)).AgregarLibro(temp);
                return true;
            }else{
                //el libro ya existe
                JOptionPane.showMessageDialog(null, "El libro ya existe en la biblioteca", "Error de carga", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }else{
            if (JOptionPane.showConfirmDialog(null, "¿Desea añadir la categoria \""+Categoria+"\" a la biblioteca?", "Creacion de Categorias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                //si no existe, creamos la categoria
                
                //añadimos el libro
                if (ObtenerLibro(ISBN) == null) {
                    //si no existe el ISBN, añadimos
                    CrearCategoria(Categoria);
                    Libro temp = new Libro(ISBN, titulo, Autor, Editorial, Ano, Edicion, Categoria, Idioma, logeado.getCarnet());
                    categorias.Find(Categoria.charAt(0)).AgregarLibro(temp);
                    JOptionPane.showMessageDialog(null, "Categoria "+Categoria+" creada", "Categoria Añadida", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }else{
                    //ya existe se cacela la operacion
                    JOptionPane.showMessageDialog(null, "El libro ya existe en la biblioteca", "Error de carga", JOptionPane.ERROR_MESSAGE);
                    return false;
                }                
            }else{
                //no se añade la categoria
                return false;
            }
        }
    }
    
    private void ParseLibro(JSONObject libro){
        String cat = libro.get("Categoria").toString();
        int ISBN = Integer.parseInt(libro.get("ISBN").toString());
        
        if (categorias.Check(cat.charAt(0))) {
            //si la categoria existe verificamos el isbn
            if (ObtenerLibro(ISBN) == null) {
                //si el libro no existe lo agregamos
                Libro temp = new Libro(ISBN, libro.get("Titulo").toString(), libro.get("Autor").toString(), libro.get("Editorial").toString(), Integer.parseInt(libro.get("Año").toString()), Integer.parseInt(libro.get("Edicion").toString()), cat, libro.get("Idioma").toString(), logeado.getCarnet());
                categorias.Find(cat.charAt(0)).AgregarLibro(temp);
            }else{
                //el libro ya existe
                JOptionPane.showMessageDialog(null, "El libro ya existe en la biblioteca", "Error de carga", JOptionPane.ERROR_MESSAGE);
            }
        }else{            
            if (JOptionPane.showConfirmDialog(null, "¿Desea añadir la categoria \""+cat+"\" a la biblioteca?", "Creacion de Categorias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                //si no existe, creamos la categoria
                //añadimos el libro
                if (ObtenerLibro(ISBN) == null) {
                    //si no existe el ISBN, añadimos
                    CrearCategoria(cat);
                    Libro temp = new Libro(ISBN, libro.get("Titulo").toString(), libro.get("Autor").toString(), libro.get("Editorial").toString(), Integer.parseInt(libro.get("Año").toString()), Integer.parseInt(libro.get("Edicion").toString()), cat, libro.get("Idioma").toString(), logeado.getCarnet());
                    categorias.Find(cat.charAt(0)).AgregarLibro(temp);
                    JOptionPane.showMessageDialog(null, "Categoria "+cat+" creada", "Categoria Añadida", JOptionPane.INFORMATION_MESSAGE);                    
                }                
            }        
        }
    }
    
    public void CrearCategoria(String nombre){
        Categorias temp = new Categorias(nombre, logeado.getCarnet());
        categorias.Add(temp.getNombre().charAt(0), temp);
    }
    
    public Categorias ObtenerCategoria(String nombre){
        return categorias.Find(nombre.charAt(0));
    }
    
    public void EliminarCategoria(String nombre){
        Categorias temp = categorias.Find(nombre.charAt(0));
        if (temp.getCarnet() == logeado.getCarnet()) {
            categorias.Delete(nombre.charAt(0));
        }else{
            JOptionPane.showMessageDialog(null, "Esta Categoria no te pertenece", "Eliminacion de categorias", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public boolean CargaUsuarios(String path){        
        try{
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(new FileReader(path));
            JSONArray array = (JSONArray) json.get("Usuarios");
            array.forEach(user -> ParseUsuario((JSONObject) user)); 
            return true;
        }catch(IOException | ParseException e){
            JOptionPane.showMessageDialog(null, e, "Ha ocurrido un error en la carga de datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean CargaUsuarios(int Carnet, String Nombre, String Apellido, String Carrera, String Password){
        try{
            Usuario temp = new Usuario(Carnet, Nombre, Apellido, Carrera, MD5(Password));
            usuarios.Insertar(Carnet, temp);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e, "Ha ocurrido un error en la carga de datos", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private void ParseUsuario(JSONObject user){        
        Usuario temp = new Usuario( Integer.parseInt(user.get("Carnet").toString()),user.get("Nombre").toString(), user.get("Apellido").toString(), user.get("Carrera").toString(), MD5(user.get("Password").toString()));
        usuarios.Insertar(temp.getCarnet(), temp);        
    }
    
    public boolean Login(int carnet, String Password){
        Usuario temp = usuarios.Obtener(carnet);
        if (temp != null) {
            if (temp.getPassword().equals(MD5(Password))) { 
                logeado = temp;
                Formulario form = new Formulario(this);
                form.setVisible(true);
                
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public boolean Deslogin(){
        if (JOptionPane.showConfirmDialog(null, "¿Esta Seguro de salir?", "Terminar Sesion", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            Login temp = new Login(this);
            temp.setVisible(true);
            return true;
        }else{
            return false;
        }
    }
    
    public Categorias[] ObtenerCategorias(){
        return categorias.InOrden(Categorias.class);
    }
    
    public Libro ObtenerLibro(int ISBN, String categoria){
        return categorias.Find(categoria.charAt(0)).getLibreria().Find(ISBN);
    }
    
    public Libro ObtenerLibro(int ISBN){
        Categorias[] array = categorias.InOrden(Categorias.class);
        Libro toReturn = null;
        for (Categorias cat : array){
            if (cat != null) {
                if (cat.getLibreria().Count()!=0) {
                    if (cat.getLibreria().Check(ISBN)) {
                    toReturn = cat.getLibreria().Find(ISBN);
                    break;
                }
                }
                
            }
        }
        return toReturn;
    }
    
    
    public Usuario ObtenerUser(int carnet){
        
        Usuario temp = usuarios.Obtener(carnet);
        if (temp != null) {
            return temp;
        }else{
            return usuarios.Obtener(100000000);
        }
    }
    
    public boolean EliminarLibro(int carnet, int ISBN, String Categoria){
        if (carnet == logeado.getCarnet()) {
            //es dueño se puede eliminar
            categorias.Find(Categoria.charAt(0)).EliminarLibro(ISBN);
            //
            int vacio = categorias.Find(Categoria.charAt(0)).getLibreria().Count();
            if (vacio == 0) {
                //categoria sin libros
                categorias.Delete(Categoria.charAt(0));
            }
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Tu no eres el dueño de este libro", "¡Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }        
    }
    
    private String MD5(String password){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            byte[] mssDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, mssDigest);
            
            String hashText = no.toString(16);
            while(hashText.length() < 32){
                hashText = "0" + hashText;
            }
            return hashText;
            
        }catch(NoSuchAlgorithmException e){
            System.out.println(e);
            
            return null;
        }
    }
    
    public boolean EliminarUsuario(){        
        if (JOptionPane.showConfirmDialog(null,"¿Estas Seguro?\nTodos los datos asociados a este usuario se eliminaran", "Eliminacion de usuario",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            Categorias[] temp = categorias.InOrden(Categorias.class);
            for (Categorias cat : temp){
                if (cat != null) {
                    Libro[] libros = cat.getLibreria().RecorridoOrdenado();
                    for(Libro lib : libros){
                        if (lib != null) {
                            if (lib.getCarnet()==logeado.getCarnet())
                                lib.setCarnet(100000000);
                        }
                    }
                }                
            }
            usuarios.Eliminar(logeado.getCarnet());
            Login log = new Login(this);
            log.setVisible(true);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean ModificarUsuario(String nombre, String apell, String carrera){
        logeado.setApellido(apell);
        logeado.setNombre(nombre);
        logeado.setCarrera(carrera);
        JOptionPane.showMessageDialog(null, "Datos Actualizados", "Actualizacion", JOptionPane.OK_OPTION);
        return true;
    }
}
