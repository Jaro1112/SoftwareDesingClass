package Restaurante.Pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class InterfazUsuario extends JFrame {
	
	 private List<Ingrediente> listaIngredientes;
	 private List<Receta> listaRecetas;
	 private Map<String, Integer> recetasPreparadas;


    public InterfazUsuario() {
    	
    	// Agregar un cuadro de diálogo para el inicio de sesión
        String usuarioIngresado = JOptionPane.showInputDialog("Ingrese el nombre de usuario:");
        String contrasenaIngresada = JOptionPane.showInputDialog("Ingrese la contraseña:");
        
        if (verificarCredenciales(usuarioIngresado, contrasenaIngresada)) {
        	
            // Inicializar las listas de ingredientes y recetas
            listaIngredientes = new ArrayList<>();
            listaRecetas = new ArrayList<>();
            recetasPreparadas = new HashMap<>();

            setTitle("Sistema de Gestión de Recetas");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(11, 1));

            JButton verIngredientesButton = new JButton("1. Ver Ingredientes");
            JButton editarIngredientesButton = new JButton("2. Editar Ingredientes");
            JButton eliminarIngredientesButton = new JButton("3. Eliminar Ingredientes");
            JButton agregarIngredientesButton = new JButton("4. Agregar Ingredientes");
            JButton salirProgramaButton = new JButton("5. Salir del Programa");
            JButton verificandoRecetasButton = new JButton("6. Verificando Recetas");
            JButton editarRecetasButton = new JButton("7. Editar Recetas");
            JButton agregarRecetasButton = new JButton("8. Agregar Recetas");
            JButton eliminarRecetasButton = new JButton("9. Eliminar Recetas");
            JButton prepararRecetasButton = new JButton("10. Preparar Recetas");
            JButton recetasPreparadasButton = new JButton("11. Mostrar Recetas Preparadas");
            
            
            verIngredientesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Ver Ingredientes
                    StringBuilder ingredientesTexto = new StringBuilder("<html><b>Lista de Ingredientes:</b><br>");

                    for (Ingrediente ingrediente : listaIngredientes) {
                        ingredientesTexto.append(ingrediente.toString()).append("<br>");
                    }

                    ingredientesTexto.append("</html>");

                    JTextPane ingredientesPane = new JTextPane();
                    ingredientesPane.setContentType("text/html");
                    ingredientesPane.setText(ingredientesTexto.toString());
                    ingredientesPane.setEditable(false);

                    JScrollPane scrollPane = new JScrollPane(ingredientesPane);

                    JOptionPane.showMessageDialog(null, scrollPane, "Ver Ingredientes", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            editarIngredientesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	// Editar Ingredientes
                    String nombreEditar = JOptionPane.showInputDialog("Ingrese el nombre del ingrediente que desea editar:");

                    Ingrediente ingredienteAEditar = null;

                    for (Ingrediente ingrediente : listaIngredientes) {
                        if (ingrediente.getNombre().equalsIgnoreCase(nombreEditar)) {
                            ingredienteAEditar = ingrediente;
                            break;
                        }
                    }

                    if (ingredienteAEditar != null) {
                        String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", ingredienteAEditar.getNombre());
                        int nuevaUnidad = Integer.parseInt(JOptionPane.showInputDialog("Nueva unidad:", ingredienteAEditar.getUnidad()));
                        double nuevoValor = Double.parseDouble(JOptionPane.showInputDialog("Nuevo valor por unidad:", ingredienteAEditar.getValorUnidad()));
                        String nuevoProveedor = JOptionPane.showInputDialog("Nuevo proveedor (nombre del proveedor):", ingredienteAEditar.getSitioCompra());
                        Proveedor proveedor = Proveedor.valueOf(nuevoProveedor.toUpperCase());
                        double nuevasCalorias = Double.parseDouble(JOptionPane.showInputDialog("Nuevas calorías por unidad:", ingredienteAEditar.getCaloriasUnidad()));

                        // Actualizar los atributos del ingrediente
                        ingredienteAEditar.setNombre(nuevoNombre);
                        ingredienteAEditar.setUnidad(nuevaUnidad);
                        ingredienteAEditar.setValorUnidad(nuevoValor);
                        ingredienteAEditar.setSitioCompra(proveedor);
                        ingredienteAEditar.setCaloriasUnidad(nuevasCalorias);

                        JOptionPane.showMessageDialog(null, "Ingrediente editado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el ingrediente con el nombre proporcionado.");
                    }
                }
            });

            eliminarIngredientesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Eliminar Ingredientes
                    String nombreEliminar = JOptionPane.showInputDialog("Ingrese el nombre del ingrediente que desea eliminar:");

                    // Validar que se haya ingresado un nombre
                    if (nombreEliminar != null && !nombreEliminar.isEmpty()) {
                        Ingrediente ingredienteAEliminar = null;
                        for (Ingrediente ingrediente : listaIngredientes) {
                            if (ingrediente.getNombre().equalsIgnoreCase(nombreEliminar)) {
                                ingredienteAEliminar = ingrediente;
                                break;
                            }
                        }

                        if (ingredienteAEliminar != null) {
                            listaIngredientes.remove(ingredienteAEliminar);
                            JOptionPane.showMessageDialog(null, "Ingrediente eliminado con éxito.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró el ingrediente con el nombre proporcionado.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el ingrediente. Asegúrese de ingresar un nombre válido.");
                    }
                }
            });

            agregarIngredientesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	// Agregar ingrediente

                    JTextField nombreField = new JTextField();
                    JTextField unidadField = new JTextField();
                    JTextField valorField = new JTextField();
                    JTextField proveedorField = new JTextField();
                    JTextField caloriasField = new JTextField();

                    Object[] message = {
                            "Nombre:", nombreField,
                            "Cantidad:", unidadField,
                            "Valor por Unidad:", valorField,
                            "Proveedor (nombre):", proveedorField,
                            "Calorías por Unidad:", caloriasField
                    };

                    int option = JOptionPane.showConfirmDialog(null, message, "Agregar Ingrediente", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        String nombreNuevo = nombreField.getText();
                        int unidadNueva = Integer.parseInt(unidadField.getText());
                        double valorNuevo = Double.parseDouble(valorField.getText());
                        String proveedorNuevo = proveedorField.getText();
                        double caloriasNuevas = Double.parseDouble(caloriasField.getText());

                        Proveedor proveedor = Proveedor.valueOf(proveedorNuevo.toUpperCase());

                        Ingrediente nuevoIngrediente = new Ingrediente(nombreNuevo, unidadNueva, valorNuevo, proveedor, caloriasNuevas);
                        listaIngredientes.add(nuevoIngrediente);

                        JOptionPane.showMessageDialog(null, "Ingrediente agregado con éxito.");
                    }
                }
            });

            salirProgramaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Seleccionaste Salir del Programa");
                    System.exit(0);
                }
            });

            verificandoRecetasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Verificando Recetas
                    StringBuilder recetasTexto = new StringBuilder();
                    recetasTexto.append("Verificando recetas disponibles...\n");

                    if (listaRecetas.isEmpty()) {
                        recetasTexto.append("No hay recetas disponibles.");
                    } else {
                        for (Receta receta : listaRecetas) {
                            recetasTexto.append(receta).append("\n----------------------------------------\n");
                        }
                    }

                    JTextArea recetasTextArea = new JTextArea(recetasTexto.toString());
                    recetasTextArea.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(recetasTextArea);

                    JOptionPane.showMessageDialog(null, scrollPane, "Recetas Disponibles", JOptionPane.INFORMATION_MESSAGE);
                }
            });

            editarRecetasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	// Editar Recetas
                    String nombreRecetaEditar = JOptionPane.showInputDialog("Ingrese el nombre de la receta que desea editar:");

                    Receta recetaAEditar = null;

                    for (Receta receta : listaRecetas) {
                        if (receta.getNombreReceta().equalsIgnoreCase(nombreRecetaEditar)) {
                            recetaAEditar = receta;
                            break;
                        }
                    }

                    if (recetaAEditar != null) {
                        // Editar detalles de la receta
                        String nuevoNombreReceta = JOptionPane.showInputDialog("Nuevo nombre de receta:", recetaAEditar.getNombreReceta());
                        double nuevoTiempoPreparacion = Double.parseDouble(JOptionPane.showInputDialog("Nuevo tiempo de preparación en minutos:", recetaAEditar.getTiempoPreparacion()));
                        int nuevoNumeroPersonas = Integer.parseInt(JOptionPane.showInputDialog("Nuevo número de personas:", recetaAEditar.getNumeroPersonas()));
                        String nuevaDescripcionReceta = JOptionPane.showInputDialog("Nueva descripción de la receta:", recetaAEditar.getDescripcion());

                        recetaAEditar.setNombreReceta(nuevoNombreReceta);
                        recetaAEditar.setTiempoPreparacion(nuevoTiempoPreparacion);
                        recetaAEditar.setNumeroPersonas(nuevoNumeroPersonas);
                        recetaAEditar.setDescripcion(nuevaDescripcionReceta);

                        // Puedes agregar la lógica para editar la lista de ingredientes si lo necesitas

                        JOptionPane.showMessageDialog(null, "Receta editada con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la receta con el nombre proporcionado.");
                    }
                }
            });

            agregarRecetasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Agregar Receta
                    String nuevoNombreReceta = JOptionPane.showInputDialog("Ingrese el nombre de la nueva receta:");
                    double nuevoTiempoPreparacion = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tiempo de preparación en minutos:"));
                    int nuevoNumeroPersonas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de personas:"));
                    String nuevaDescripcionReceta = JOptionPane.showInputDialog("Ingrese la descripción de la receta:");

                    // Crear una nueva lista de ingredientes para la receta
                    List<String> ingredientesReceta = new ArrayList<>();

                    // Permitir al usuario agregar hasta dos ingredientes a la receta
                    for (int i = 0; i < 2; i++) {
                        String nuevoIngrediente1 = JOptionPane.showInputDialog("Ingrese un ingrediente (" + (i + 1) + "/2):");

                        // Verificar si se ingresó un ingrediente antes de agregarlo
                        if (nuevoIngrediente1 != null && !nuevoIngrediente1.isEmpty()) {
                            ingredientesReceta.add(nuevoIngrediente1);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se ingresó un ingrediente válido. La receta puede quedar sin ingredientes.");
                            break;
                        }
                    }

                    // Crear la nueva receta con los ingredientes
                    Receta nuevaReceta = new Receta(nuevoNombreReceta, nuevoTiempoPreparacion, nuevoNumeroPersonas, ingredientesReceta, nuevaDescripcionReceta);
                    listaRecetas.add(nuevaReceta);

                    JOptionPane.showMessageDialog(null, "Receta agregada con éxito.");
                }
            });

            eliminarRecetasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Eliminar Receta
                    String nombreRecetaEliminar = JOptionPane.showInputDialog("Ingrese el nombre de la receta que desea eliminar:");

                    Receta recetaAEliminar = null;

                    for (Receta receta : listaRecetas) {
                        if (receta.getNombreReceta().equalsIgnoreCase(nombreRecetaEliminar)) {
                            recetaAEliminar = receta;
                            break;
                        }
                    }

                    if (recetaAEliminar != null) {
                        listaRecetas.remove(recetaAEliminar);
                        JOptionPane.showMessageDialog(null, "Receta eliminada con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la receta con el nombre proporcionado.");
                    }
                }
            });
            
            // ActionListener 
            prepararRecetasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    prepararReceta();
                }
            });
            
            recetasPreparadasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarRecetasPreparadas();
                }
            });

            


            // Agregar los ActionListener para cada botón aquí (código sin cambios)

            panel.add(verIngredientesButton);
            panel.add(editarIngredientesButton);
            panel.add(eliminarIngredientesButton);
            panel.add(agregarIngredientesButton);
            panel.add(salirProgramaButton);
            panel.add(verificandoRecetasButton);
            panel.add(editarRecetasButton);
            panel.add(agregarRecetasButton);
            panel.add(eliminarRecetasButton);
            panel.add(prepararRecetasButton);
            panel.add(recetasPreparadasButton);

            add(panel);
            setVisible(true);
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Saliendo del programa.");
            System.exit(0);
        }    
  
    }
     
 
    private boolean verificarCredenciales(String usuario, String contrasena) {
        // Verificar si el usuario y la contraseña coinciden con las credenciales válidas
        return (usuario.equals("admin") && contrasena.equals("admin")) ||
               (usuario.equals("cocinero") && contrasena.equals("123"));
    }
    
    // Método para preparar una receta
    private void prepararReceta() {
        // Verificar si hay recetas disponibles
        if (listaRecetas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay recetas disponibles para preparar.");
            return;
        }

        // Crear un arreglo de strings con los nombres de las recetas disponibles
        String[] nombresRecetas = new String[listaRecetas.size()];
        for (int i = 0; i < listaRecetas.size(); i++) {
            nombresRecetas[i] = listaRecetas.get(i).getNombreReceta();
        }


     // Mostrar un cuadro de diálogo para que el usuario elija una receta
        String recetaSeleccionada = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una receta para preparar:",
                "Preparar Recetas",
                JOptionPane.QUESTION_MESSAGE,
                null,
                nombresRecetas,
                nombresRecetas[0]);
        
        // Verificar si se seleccionó una receta
        if (recetaSeleccionada != null) {
            // Buscar la receta seleccionada en la lista
            Receta receta = null;
            for (Receta r : listaRecetas) {
                if (r.getNombreReceta().equals(recetaSeleccionada)) {
                    receta = r;
                    break;
                }
            }

            if (receta != null) {
                // Verificar la disponibilidad de ingredientes
                if (verificarIngredientesDisponibles(receta.getListaIngredientes())) {
                    // Calcular el tiempo estimado para preparar la receta
                    double tiempoEstimado = receta.getTiempoPreparacion() * receta.getNumeroPersonas() / 2;
                    JOptionPane.showMessageDialog(null, "La receta estará lista en aproximadamente " + tiempoEstimado + " minutos.");

                    // Restar 1 a la cantidad de ingredientes utilizados
                    restarIngredientes(receta.getListaIngredientes());
                } else {
                    JOptionPane.showMessageDialog(null, "No hay suficientes ingredientes para preparar la receta.");
                }
            }
        }
    }

 // verificar la disponibilidad de ingredientes
    private boolean verificarIngredientesDisponibles(List<String> ingredientesReceta) {
        for (String ingredienteReceta : ingredientesReceta) {
            boolean encontrado = false;
            for (Ingrediente ingrediente : listaIngredientes) {
                if (ingrediente.getNombre().equalsIgnoreCase(ingredienteReceta) &&
                        ingrediente.getUnidad() > 0) {
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                return false; // Si falta algún ingrediente o no hay suficiente cantidad, retornar false
            }
        }
        return true; // Todos los ingredientes están disponibles
    }
    // Restar 1 a la cantidad de ingredientes utilizados
    private void restarIngredientes(List<String> ingredientesReceta) {
        for (String ingredienteReceta : ingredientesReceta) {
            for (Ingrediente ingrediente : listaIngredientes) {
                if (ingrediente.getNombre().equalsIgnoreCase(ingredienteReceta)) {
                    // Restar 1 a la cantidad del ingrediente
                    int cantidadActual = ingrediente.getUnidad();
                    if (cantidadActual > 0) {
                        ingrediente.setUnidad(cantidadActual - 1);
                    }
                    break;
                }
            }
        }
    }

    private void mostrarRecetasPreparadas() {
        StringBuilder mensaje = new StringBuilder("Recetas preparadas:\n");
        for (Map.Entry<String, Integer> entry : recetasPreparadas.entrySet()) {
            mensaje.append(entry.getKey()).append(": ").append(entry.getValue()).append(" veces\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazUsuario();
            }
        });
    }
    
}