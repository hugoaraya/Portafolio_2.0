
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
namespace APPHostal
{
    /// <summary>
    /// Lógica de interacción para Main.xaml
    /// </summary>
    public partial class Main : Page
    {
        public Main()
        {
            InitializeComponent();
        }
        
        private void btnIngresar_Click(object sender, RoutedEventArgs e)
        {
            //Validacion de Usuario
            //USUARIO usu = new USUARIO();
            //usu.NOMBRE_USUARIO = txUsuario.Text;
            //usu.CONTRASENIA = txContrasena.Text;
            //MessageBox.Show(usu.CONTRASENIA);
            //MessageBox.Show(ObtenerUsuario(usu));
            //if (usu.CONTRASENIA == ObtenerUsuario(usu))
            //{
            //    inicioSesion.Visibility = Visibility.Hidden;
            //    lbMsg.Content = "Usuario OK";

            //}
            //else
            //{
            //    lbMsg.Content = "Usuario / Contraseña Invalidos";
            //}
            inicioSesion.Visibility = Visibility.Hidden;
            Menus.Visibility = Visibility.Visible;
        }

        private string ObtenerUsuario(USUARIO usu)
        {
            USUARIO usuario = new USUARIO();
            using (EntitiesHostal con = new EntitiesHostal())
            {
                //Revisar busqueda de usuario
                usuario = con.USUARIO.Find();
            }
            String pass = usuario.CONTRASENIA;
            return pass;
        }

        private void btnCerrarSesion(object sender, RoutedEventArgs e)
        {
            inicioSesion.Visibility = Visibility.Visible;
            Contenidos.Content = "";
            Menus.Visibility = Visibility.Hidden;
        }

        private void btnSalir(object sender, RoutedEventArgs e)
        {
            App.Current.Shutdown();
        }

        private void btnMantenedorUsuarios(object sender, RoutedEventArgs e)
        {
            //Contenidos.Visibility = Visibility.Visible;
            templates.MantenedorUsuarios m1 = new templates.MantenedorUsuarios();
            Contenidos.Navigate(m1);
        }

        private void btnMantenedorEmpleados(object sender, RoutedEventArgs e)
        {
            //Contenidos.Visibility = Visibility.Visible;
            templates.MantenedorEmpleados e1 = new templates.MantenedorEmpleados();
            Contenidos.Navigate(e1);
        }
    }
}
