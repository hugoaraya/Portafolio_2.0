using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using DAO;
using APPHostal;
using Oracle.ManagedDataAccess.Client;
using Biblioteca;

namespace APPHostal.templates
{
    /// <summary>
    /// Lógica de interacción para MantenedorUsuarios.xaml
    /// </summary>
    public partial class MantenedorUsuarios : Page
    {
        public MantenedorUsuarios()
        {
            InitializeComponent();
            updateDataGrid();
        }


        private void updateDataGrid()
        {
            Usuario usu = new Usuario();
            using (EntitiesHostal con = new EntitiesHostal())
            {
                var listaUsuarios = new List();

                foreach (var a in con.USUARIO.ToList())
                {
                    usu.IDUSUARIO = a.IDUSUARIO;
                    usu.NOMBRE_USUARIO = a.NOMBRE_USUARIO;
                    usu.CONTRASENIA = a.CONTRASENIA;
                    usu.DESCRIPCION = a.TIPO_USUARIO.DESCRIPCION;
                    listaUsuarios.
                    dgManteneUsuario.ItemsSource = usu;
                    dgManteneUsuario.Items.Refresh();
                    }
                    
                }




            LimpiarCampos();
        }


        private void btnAgregar_Click(object sender, RoutedEventArgs e)
        {
                USUARIO usuario = new USUARIO();
                usuario.IDUSUARIO = 2;
                usuario.NOMBRE_USUARIO = txNombre.Text;
                usuario.CONTRASENIA = txContrasena.Text;
                usuario.TIPO_USUARIO_ID = 1;
                   
                AddUsuario(usuario);
        }

        public void AddUsuario(USUARIO usu)
            
        {
            using (EntitiesHostal con = new EntitiesHostal())
            {
                con.USUARIO.Add(usu);
                con.SaveChanges();
            }
            LimpiarCampos();
            lbMsg1.Content = "Usuario Ingresado...";
        }
        

        private void btnActualizar_Click(object sender, RoutedEventArgs e)
        {

        }

        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {
            LimpiarCampos();
        }

       

        private void dgManteneUsuario_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            using (EntitiesHostal con = new EntitiesHostal())
            {
                try
                {
                    var empleadosQuery = from d in con.USUARIO
                                      orderby d.NOMBRE_USUARIO
                                      select d;
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message);
                }
                lbMsg1.Content = "Usuarios conextados";
            }
            LimpiarCampos();
            
        }

        private void LimpiarCampos()
        {
            txNombre.Text = "";
            txContrasena.Text = "";
            txTipoUsuario.Text = "";

            btnAgregar.IsEnabled = true;
            btnActualizar.IsEnabled = false;    
        }
    }
}
