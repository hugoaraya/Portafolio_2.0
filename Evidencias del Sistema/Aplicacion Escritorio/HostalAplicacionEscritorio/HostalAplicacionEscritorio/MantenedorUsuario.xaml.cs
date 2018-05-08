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
using System.Data;
using Oracle.ManagedDataAccess.Client;
using Oracle.ManagedDataAccess.Types;
using System.Configuration;

namespace HostalAplicacionEscritorio
{
    /// <summary>
    /// Lógica de interacción para MantenedorUsuario.xaml
    /// </summary>
    public partial class MantenedorUsuario : Window
    {
        OracleConnection con = null;
        public MantenedorUsuario()
        {
            this.setConnection();
            InitializeComponent();
        }

        private void updateDataGrid()
        {
            OracleCommand cmd = con.CreateCommand();
            cmd.CommandText = "SELECT U.ID,U.NOMBRE_USUARIO NOMBRE,U.CONTRASENIA CONTRASEÑA,T.DESCRIPCION TIPO_DE_USUARIO from USUARIO U inner Join TIPO_USUARIO T on (U.TIPO_USUARIO_ID = T.ID)";
            cmd.CommandType = CommandType.Text;
            OracleDataReader dr = cmd.ExecuteReader();
            DataTable dt = new DataTable();
            dt.Load(dr);
            MydataGrid.ItemsSource = dt.DefaultView;
            dr.Close();
        }

        private void setConnection()
        {
            String connectionString = ConfigurationManager.ConnectionStrings["HostalConnection"].ConnectionString;
            con = new OracleConnection(connectionString);
            try
            {
                con.Open();
            }
            catch (Exception exp) { }
        }
        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            this.updateDataGrid();
        }

        private void Window_Closed(object sender, EventArgs e)
        {
            con.Close();
        }

        private void btnAgregar_Click(object sender, RoutedEventArgs e)
        {

        }

        private void btnActualizar_Click(object sender, RoutedEventArgs e)
        {

        }

        private void btnEliminar_Click(object sender, RoutedEventArgs e)
        {

        }

        private void btnLimpiar_Click(object sender, RoutedEventArgs e)
        {

        }
    }
}
