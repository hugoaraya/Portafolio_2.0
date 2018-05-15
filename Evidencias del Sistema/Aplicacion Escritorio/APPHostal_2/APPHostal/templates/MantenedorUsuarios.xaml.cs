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
using Oracle.ManagedDataAccess.Client;
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
            
        }


        private void btnAgregar_Click(object sender, RoutedEventArgs e)
        {
                USUARIO usuario = new USUARIO();
                usuario.ID = 5;
                usuario.NOMBRE_USUARIO = "prueba";
                usuario.CONTRASENIA = "prueba";
                usuario.TIPO_USUARIO_ID = 2;
                   
                AddUsuario(usuario);
        }




        public void AddUsuario(USUARIO usu)

        {
            using (EntitiesHostal con = new EntitiesHostal())
            {
                con.USUARIO.Add(usu);
                con.SaveChanges();
            }
            
        }
        

        private void btnActualizar_Click(object sender, RoutedEventArgs e)
        {

        }

        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {

        }

        private void dgManteneUsuario_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }

        private void LimpiarCampos()
        {
            txId.Text = "";
            txNombre.Text = "";
            txContrasena.Text = "";
            txTipoUsuario.Text = "";

            btnAgregar.IsEnabled = true;
            btnActualizar.IsEnabled = false;    
        }
    }
}
