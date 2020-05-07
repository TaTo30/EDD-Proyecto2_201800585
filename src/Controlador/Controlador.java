
package Controlador;

import Modelos.*;
import Vista.*;
import java.io.*;
import static java.lang.Thread.sleep;
import java.net.*;
import java.math.BigInteger;
import javax.swing.JOptionPane;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Controlador {
    
    private final AVLTree<Categorias> categorias;
    private final HashTable<Usuario> usuarios;
    private Usuario logeado;
    private List<NodoRed> nodos;

    
    
    public Controlador(){
        this.usuarios = new HashTable<>(45);
        this.categorias = new AVLTree<>();
        Usuario Predeterminado = new Usuario(100000000,"Predeterminado","Predeterminado","Predeterminado","Predeterminado");
        usuarios.Insertar(100000000, Predeterminado);
        //IniciarServidor();
        //this.host = "localhost";
        nodos = new List<>();
        
    }
   
    
    /**************************/
    /* METODOS SOBRE USUARIOS */
    /**************************/    
    //Obtiene informacion del usuario logeado actualmente
    public Usuario ObtenerLogeado(){
        return this.logeado;
    }
    //Lee el archivo en formate JSON sobre los usuarios que se ingresen
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
    //Registra a un usuario nuevo desde el formulario del registro
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
    //Parsea el archivo JSON y registra un usuarios
    private void ParseUsuario(JSONObject user){        
        Usuario temp = new Usuario( Integer.parseInt(user.get("Carnet").toString()),user.get("Nombre").toString(), user.get("Apellido").toString(), user.get("Carrera").toString(), MD5(user.get("Password").toString()));
        usuarios.Insertar(temp.getCarnet(), temp);        
    }
    //Logea un usuario verificando su carnter y contraseña
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
    //Deslogea un usuario devolviendo el formulario de login
    public boolean Deslogin(){
        if (JOptionPane.showConfirmDialog(null, "¿Esta Seguro de salir?", "Terminar Sesion", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            Login temp = new Login(this);
            temp.setVisible(true);
            return true;
        }else{
            return false;
        }
    }
    //Modifica los datos de un usuario dentro del la tabla hash
    public boolean ModificarUsuario(String nombre, String apell, String carrera){
        logeado.setApellido(apell);
        logeado.setNombre(nombre);
        logeado.setCarrera(carrera);
        JOptionPane.showMessageDialog(null, "Datos Actualizados", "Actualizacion", JOptionPane.OK_OPTION);
        return true;
    }
    //Elimina un usuario de la tabla hash
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
    //Retorna un usuario que con el carnet especificado
    public Usuario ObtenerUser(int carnet){        
        Usuario temp = usuarios.Obtener(carnet);
        if (temp != null) {
            return temp;
        }else{
            return usuarios.Obtener(100000000);
        }
    }
    
    
    
    
    
    /************************/
    /* METODOS SOBRE LIBROS */
    /************************/ 
    //Carga un libro a travez de la carga masiva de libros    
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
    //Carga un libro a travez del formulario de registro de libros
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
    //Parsea un libro y lo carga a la estructura
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
    //Obtiene un libro con la ISBN y categoria especificada
    /*public Libro ObtenerLibro(int ISBN, String categoria){
        return categorias.Find(categoria.charAt(0)).getLibreria().Find(ISBN);
    }*/
    //Obtiene un libro con el ISBN especificada
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
    //Elimina un libro de la estructura
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
    
    
    
    
    
    
    
    /************************/
    /* METODOS SOBRE LIBROS */
    /************************/ 
    //crea una Nueva categoria
    public void CrearCategoria(String nombre){
        Categorias temp = new Categorias(nombre, logeado.getCarnet());
        categorias.Add(temp.getNombre().charAt(0), temp);
    }
    //returna una categoria
    public Categorias ObtenerCategoria(String nombre){
        return categorias.Find(nombre.charAt(0));
    }
    //elimina una categoria
    public void EliminarCategoria(String nombre){
        Categorias temp = categorias.Find(nombre.charAt(0));
        if (temp.getCarnet() == logeado.getCarnet()) {
            categorias.Delete(nombre.charAt(0));
        }else{
            JOptionPane.showMessageDialog(null, "Esta Categoria no te pertenece", "Eliminacion de categorias", JOptionPane.ERROR_MESSAGE);
        }        
    }
    //Obtiene un array de categorias    
    public Categorias[] ObtenerCategorias(){
        return categorias.InOrden(Categorias.class);
    }
    
    
    
    
    
    
    /***********************************/
    /* METODOS SOBRE CONECCION SOCKETS */
    /***********************************/
    private int puerto;
    private String host;
    public void IniciarServidor(String host, int puerto){
        this.host = host;
        this.puerto = puerto;
        new Servidor(puerto,this).start();
    }
    //Ingresa a la lista de Nodos cada vez que la aplicacion se instancia
    public void IngresarRed(){
        nodos.AddLast(new NodoRed(puerto, host), 0);
        ImprimirNodos();
    }
    //Agrega nodos a la red de nodos o instancias de aplicacion
    public void AgregarNodo(NodoRed dato){ 
        boolean existe = false;
        for (int i = 0; i < nodos.Size(); i++) {
            NodoRed temp = nodos.ElementAt(i);
            if ((temp.getIP().equals(dato.getIP())) && (temp.getPuerto()==dato.getPuerto())) {
                existe = true;
            }
        }
        if (!existe)
            nodos.AddLast(dato, 0);        
        ImprimirNodos();
    }
    //Elimina un nodo especificado
    public void EliminarNodo(NodoRed dato){
        for (int i = 0; i < nodos.Size(); i++) {
            if (nodos.ElementAt(i) == dato) {
                nodos.RemoveAt(i);
                break;
            }
        }
        ImprimirNodos();
    }
    //Añade nodos de una coneccion directa de red
    public String ProcesoAgregarNodo(String host, int puerto){
        JSONArray array = new JSONArray();
        for (int i = 0; i < nodos.Size(); i++) {
            JSONObject temp = new JSONObject();
            temp.put("IP", nodos.ElementAt(i).getIP());
            temp.put("Puerto", nodos.ElementAt(i).getPuerto());
            array.add(temp);
        }
        for (int i = 1; i < nodos.Size(); i++) {
            try {
                NodoRed temp = nodos.ElementAt(i);
                System.out.println("Al puerto "+temp.getPuerto()+" enviarle "+puerto);
                JSONObject obj = new JSONObject();
                obj.put("IP", host);
                obj.put("Puerto", puerto);
                JSONObject ins = new JSONObject();
                ins.put("Instruccion", 2);
                ins.put("Dato", obj);
                System.out.println("Envio: 0000"+ins.toJSONString());
                /*BufferedWriter writeFile = new BufferedWriter(new FileWriter("Instrucciones.json"));
                writeFile.write(ins.toJSONString());
                writeFile.close();*/
                System.out.println(temp.getIP() + temp.getPuerto());
                Socket cliente = new Socket(temp.getIP(), temp.getPuerto());
                PrintStream salida = new PrintStream(cliente.getOutputStream(),true);
                salida.println(ins.toJSONString()); 
                salida.close();
                System.out.println(cliente.isConnected());
                System.out.println(cliente.getPort());
                sleep(3000);
            } catch (IOException ex) { } catch (InterruptedException ex) { 
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        JSONObject ins = new JSONObject();
        ins.put("Instruccion", 1);
        ins.put("Dato", array);
        AgregarNodo(new NodoRed(puerto, host));
        return ins.toJSONString();
    }
    //envia una solicitud de red
    public void RegistroNodoRedClienteSide(int puerto, String ipH){
        try{
            //CREAMOS UN ARCHIVO JSON CON LAS INSTRUCCIONES
            JSONObject obj = new JSONObject();
            obj.put("IP", this.host);
            obj.put("Puerto", this.puerto);
            JSONObject ins = new JSONObject();
            ins.put("Instruccion", 0);
            ins.put("Dato", obj);
            /*BufferedWriter writeFile = new BufferedWriter(new FileWriter("Instrucciones.json"));
            writeFile.write(ins.toJSONString());
            writeFile.close();*/
            Socket cliente = new Socket(ipH, puerto);
            PrintStream salida = new PrintStream(cliente.getOutputStream(),true);
            salida.println(ins.toJSONString()); 
            salida.close();
            System.out.println(cliente.getPort());
            System.out.println(cliente.isConnected());       
        }catch(IOException e){System.out.println(e.toString());}
    }
    //Registra todos los nodos que envia el nodo servidor
    public void RegistrarNodosMasivos(String json){
        try {
            JSONParser parser = new JSONParser();        
            JSONArray puertos = (JSONArray) parser.parse(json);
            puertos.forEach(port -> ParseNodos((JSONObject)port));
        } catch (ParseException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Parsea los nodos de un array json
    public void ParseNodos(JSONObject o){
        String ip = o.get("IP").toString();
        int puertoparse = Integer.parseInt(o.get("Puerto").toString());
        AgregarNodo(new NodoRed(puertoparse, ip));
    }
    //Imprime los nodos que hay en una red
    public void ImprimirNodos(){
        for (int i = 0; i < nodos.Size(); i++) {
            System.out.println(nodos.ElementAt(i).getIP()+" -> "+nodos.ElementAt(i).getPuerto());
        }
    }
    
    public boolean PruebaRed(){
        return nodos.Size() > 1;
    }
    
    public String Parametraje(){
        return "IP: "+this.host+"   Puerto: "+this.puerto;
    }
    
    
    
    
    
    /***************************/
    /* METODOS DE ENCRIPTACION */
    /***************************/     
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
    
    
    
    
    
    
    /********************************/
    /* METODOS SOBRE DE GRAFICACION */
    /********************************/     
    public void ImprimirAVL() throws IOException{
        categorias.Graficar();
    }
    
    public void ImprimirHash(){
        usuarios.Graficar();
    }
    
    public Categorias[] AVLInorden(){
        return categorias.InOrden(Categorias.class);
    }
    
    public Categorias[] AVLPreorden(){
        return categorias.PreOrden(Categorias.class);
    }
    
    public Categorias[] AVLPostorden(){
        return categorias.PostOrden(Categorias.class);
    }
 }
