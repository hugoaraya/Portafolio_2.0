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
    /// Lógica de interacción para Login.xaml
    /// </summary>
    public partial class Login : Page
    {
        public Login()
        {
            InitializeComponent();
        }

        private void btnIngresar_Click(object sender, RoutedEventArgs e)
        {
            USUARIO usu = new USUARIO();
            usu.NOMBRE_USUARIO = txUsuario.Text;
            usu.CONTRASENIA = txContrasena.Text;
            MessageBox.Show(usu.CONTRASENIA);
            MessageBox.Show(ObtenerUsuario(usu));
            if (usu.CONTRASENIA == ObtenerUsuario(usu))
            {
                inicioSesion.Visibility = Visibility.Hidden;
                lbMsg.Content = "Usuario OK";
                
            }
            else
            {
                lbMsg.Content = "Usuario / Contraseña Invalidos";
            }
        }

        private string ObtenerUsuario(USUARIO usu)
        {
            USUARIO usuario = new USUARIO();
            using (EntitiesHostal con = new EntitiesHostal())
            {
                
                usuario = con.USUARIO.Find(usu.ID);
                
            }
            
            return usuario.CONTRASENIA;
        }
    }
}
